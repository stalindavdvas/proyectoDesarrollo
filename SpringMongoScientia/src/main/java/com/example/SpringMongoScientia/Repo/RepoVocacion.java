package com.example.SpringMongoScientia.Repo;

import com.example.SpringMongoScientia.Entity.Carrera;
import com.example.SpringMongoScientia.Entity.Vocacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoVocacion extends MongoRepository<Vocacion, String > {
    Iterable<Vocacion> findByidEstudiante(String idEstudiante);
}
