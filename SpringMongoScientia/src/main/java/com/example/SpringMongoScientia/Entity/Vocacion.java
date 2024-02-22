package com.example.SpringMongoScientia.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vocacion")
public class Vocacion {
    @Id
    private String _id;
    private String pregunta;
    private String respuesta;
    private String idEstudiante;

    public Vocacion() {
    }

    public Vocacion(String _id,String pregunta, String respuesta, String idEstudiante) {
        this._id = _id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.idEstudiante = idEstudiante;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "Vocacion{" +
                "_id='" + _id + '\'' +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", idEstudiante='" + idEstudiante + '\'' +
                '}';
    }
}
