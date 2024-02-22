package com.example.SpringMongoScientia.Repo;

import com.example.SpringMongoScientia.Entity.Estudiante;

public interface EstudianteService {
    Estudiante login(String correo, String password);
}
