package com.example.SpringMongoScientia.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carreras")
public class Carrera {
    @Id
    private String _id;
    private String nombre;
    private String titulo;
    private int duracion;
    private String idUniversidad;
    public Carrera() {
    }

    public Carrera(String _id, String nombre, String titulo, int duracion, String idUniversidad) {
        this._id = _id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.duracion = duracion;
        this.idUniversidad=idUniversidad;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(String idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "_id='" + _id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", idUniversidad='" + idUniversidad + '\'' +
                '}';
    }
}
