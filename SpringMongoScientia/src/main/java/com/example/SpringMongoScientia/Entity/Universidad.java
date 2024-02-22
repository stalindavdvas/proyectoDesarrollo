package com.example.SpringMongoScientia.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "universidad")
public class Universidad {
    @Id
    private String _id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String pagina;


    public Universidad() {

    }

    public Universidad(String _id, String nombre, String direccion, String telefono, String pagina) {
        this._id = _id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pagina = pagina;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }


    @Override
    public String toString() {
        return "Universidad{" +
                "_id='" + _id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pagina='" + pagina + '\'' +
                '}';
    }
}
