package com.personal.consultasdni;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.personal.consultasdni.database.Datos;
import com.personal.consultasdni.database.entidades.Personas;
import com.personal.consultasdni.utils.Utils;

import cz.msebera.android.httpclient.Header;

public class Principal extends AppCompatActivity {

    private Datos sqLite;

    private EditText txt_search;
    private Button btn_search;
    private TextView lbl_result;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        sqLite = Datos.DB ( Principal.this );

        Personas.tb persona = sqLite.tb_personas().find("");

        txt_search = (EditText) findViewById(R.id.txt_search);
        btn_search = (Button) findViewById(R.id.btn_search);
        lbl_result = (TextView) findViewById(R.id.lbl_result);

        progressDialog = new ProgressDialog( Principal.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("Consultando DNI");
        progressDialog.setMessage("Espere respuesta...");

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty( txt_search.getText().toString() )){
                    if ( txt_search.getText().toString().length() == 8 ) {

                        progressDialog.show();
                        v.setEnabled( false );
                        try {

                            AsyncHttpClient cliente = new AsyncHttpClient();
                            cliente.get((Utils.var.WS + txt_search.getText().toString()), null, new AsyncHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                    if( statusCode == 200 ){
                                        try {
                                            LogUtils.d( new String(responseBody));
                                            if( !TextUtils.isEmpty( (new String(responseBody))) ){
                                                lbl_result.setText( ( new String(responseBody)));
                                            }
                                        }catch(Exception ex){
                                            ex.printStackTrace();
                                        }finally {
                                            if(progressDialog.isShowing()){
                                                progressDialog.cancel();
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                    error.printStackTrace();
                                    if(progressDialog.isShowing()){
                                        progressDialog.cancel();
                                    }
                                }

                                @Override
                                public void onFinish() {
                                    super.onFinish();
                                }
                            });

                        }catch (Exception ex ){
                            ex.printStackTrace();
                        }finally {
                            v.setEnabled( true );
                        }
                    }
                    else{
                        Utils.function.showToastError( "DNI no valido" );
                    }
                }
                else{
                    Utils.function.showToastError( "Escribe un DNI valido" );
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("APP" , "onResumen");
        //LogUtils.d("onResumen"); //LIbreria
        super.onResume();
    }

}

