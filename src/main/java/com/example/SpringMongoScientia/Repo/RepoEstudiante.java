package com.example.SpringMongoScientia.Repo;

import com.example.SpringMongoScientia.Entity.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoEstudiante extends MongoRepository<Estudiante, String > {

}
