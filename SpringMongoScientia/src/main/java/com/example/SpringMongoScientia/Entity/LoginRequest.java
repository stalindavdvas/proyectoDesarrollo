package com.example.SpringMongoScientia.Entity;

public class LoginRequest {
    private String correo;
    private String password;

    // Constructor vacío requerido por Spring para la deserialización
    public LoginRequest() {
    }

    // Constructor con parámetros
    public LoginRequest(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    // Getter y Setter para correo
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter y Setter para password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
