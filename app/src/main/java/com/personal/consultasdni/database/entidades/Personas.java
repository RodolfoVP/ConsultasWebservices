package com.personal.consultasdni.database.entidades;

import android.content.IntentFilter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class Personas {
    @Entity( tableName = "personas")
    public static class tb {
        @PrimaryKey
        @ColumnInfo(name = "dni") @NonNull private String dni;
        @ColumnInfo(name = "cod_verificacion") @Nullable private String cod_verificacion;
        @ColumnInfo(name = "nombre") @NonNull private String nombre;
        @ColumnInfo(name = "ap_paterno") @NonNull private String ap_paterno;
        @ColumnInfo(name = "ap_materno") @NonNull private String ap_materno;
        @ColumnInfo(name = "nacimiento") @Nullable private String nacimiento;
        @ColumnInfo(name = "edad") @Nullable private String edad;
        @ColumnInfo(name = "sexo") @Nullable private String sexo;
        @ColumnInfo(name = "ubi_dist") @Nullable private String ubi_dist;
        @ColumnInfo(name = "ubi_prov") @Nullable private String ubi_prov;
        @ColumnInfo(name = "ubi_depa") @Nullable private String ubi_depa;

        public tb(@NonNull String dni, @Nullable String cod_verificacion, @NonNull String nombre, @NonNull String ap_paterno, @NonNull String ap_materno, @Nullable String nacimiento, @Nullable String edad, @Nullable String sexo, @Nullable String ubi_dist, @Nullable String ubi_prov, @Nullable String ubi_depa) {
            this.dni = dni;
            this.cod_verificacion = cod_verificacion;
            this.nombre = nombre;
            this.ap_paterno = ap_paterno;
            this.ap_materno = ap_materno;
            this.nacimiento = nacimiento;
            this.edad = edad;
            this.sexo = sexo;
            this.ubi_dist = ubi_dist;
            this.ubi_prov = ubi_prov;
            this.ubi_depa = ubi_depa;
        }

//        public tb(@NonNull String dni, @NonNull String nombre, @NonNull String apellido) {
//            this.dni = dni;
//            this.nombre = nombre;
//            this.apellido = apellido;
//        }

//        @NonNull
//        public String getDni() { return dni; }
//        public void setDni(@NonNull String dni) { this.dni = dni; }
//
//        @NonNull
//        public String getNombre() { return nombre; }
//        public void setNombre(@NonNull String nombre) { this.nombre = nombre; }
//
//        @NonNull
//        public String getApellido() { return apellido; }
//        public void setApellido(@NonNull String apellido) { this.apellido = apellido; }

        @NonNull
        public String getDni() {
            return dni;
        }

        public void setDni(@NonNull String dni) {
            this.dni = dni;
        }

        @Nullable
        public String getCod_verificacion() {
            return cod_verificacion;
        }

        public void setCod_verificacion(@Nullable String cod_verificacion) {
            this.cod_verificacion = cod_verificacion;
        }

        @NonNull
        public String getNombre() {
            return nombre;
        }

        public void setNombre(@NonNull String nombre) {
            this.nombre = nombre;
        }

        @NonNull
        public String getAp_paterno() {
            return ap_paterno;
        }

        public void setAp_paterno(@NonNull String ap_paterno) {
            this.ap_paterno = ap_paterno;
        }

        @NonNull
        public String getAp_materno() {
            return ap_materno;
        }

        public void setAp_materno(@NonNull String ap_materno) {
            this.ap_materno = ap_materno;
        }

        @Nullable
        public String getNacimiento() {
            return nacimiento;
        }

        public void setNacimiento(@Nullable String nacimiento) {
            this.nacimiento = nacimiento;
        }

        @Nullable
        public String getEdad() {
            return edad;
        }

        public void setEdad(@Nullable String edad) {
            this.edad = edad;
        }

        @Nullable
        public String getSexo() {
            return sexo;
        }

        public void setSexo(@Nullable String sexo) {
            this.sexo = sexo;
        }

        @Nullable
        public String getUbi_dist() {
            return ubi_dist;
        }

        public void setUbi_dist(@Nullable String ubi_dist) {
            this.ubi_dist = ubi_dist;
        }

        @Nullable
        public String getUbi_prov() {
            return ubi_prov;
        }

        public void setUbi_prov(@Nullable String ubi_prov) {
            this.ubi_prov = ubi_prov;
        }

        @Nullable
        public String getUbi_depa() {
            return ubi_depa;
        }

        public void setUbi_depa(@Nullable String ubi_depa) {
            this.ubi_depa = ubi_depa;
        }
    }

    @Dao
    public interface sql{

        @Insert
        void insert( tb persona);

        @Update
        void update( tb persona );

        @Query( "SELECT * FROM personas" )
        List<tb> all();

        @Query( "SELECT COUNT(0) FROM personas" )
        int count();

        @Query( "SELECT * FROM personas WHERE dni =:dni LIMIT 1" )
        tb find ( String dni );

    }
}
