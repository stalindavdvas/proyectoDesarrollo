package com.example.SpringMongoScientia.Repo;

import com.example.SpringMongoScientia.Entity.Carrera;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepoCarrera extends MongoRepository<Carrera, String > {
    Iterable<Carrera> findByidUniversidad(String idUniversidad);

}
