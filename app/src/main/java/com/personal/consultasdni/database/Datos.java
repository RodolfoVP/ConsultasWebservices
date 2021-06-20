package com.personal.consultasdni.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.personal.consultasdni.database.entidades.Personas;
import com.personal.consultasdni.utils.Utils;

@Database(
        entities = {
                Personas.tb.class
        },
        version = 1,
        exportSchema = false
)
public abstract class Datos extends RoomDatabase {
    public static Datos INSTANCE;

    /*  TABLAS  */
    public abstract  Personas.sql tb_personas();

    public static Datos DB(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder( context, Datos.class, Utils.var.DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
