package com.example.SpringMongoScientia.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class CarreraConNombreUniversidad {
    private String _id;
    private String nombre;
    private String titulo;
    private int duracion;
    private String idUniversidad;
    private String universidad;

    // Getters y Setters

    // Constructor vacío requerido por Spring Data
    public CarreraConNombreUniversidad() {
    }

    // Constructor con parámetros para inicializar los campos
    public CarreraConNombreUniversidad(String _id, String nombre, String titulo, int duracion, String idUniversidad, String universidad) {
        this._id = _id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.duracion = duracion;
        this.idUniversidad = idUniversidad;
        this.universidad = universidad;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(String idUniversidad) {
        this.idUniversidad = idUniversidad;
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



    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return "CarreraConNombreUniversidad{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", idUniversidad=" + idUniversidad +
                ", universidad='" + universidad + '\'' +
                '}';
    }
}
