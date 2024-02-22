package com.example.SpringMongoScientia.Repo;

import com.example.SpringMongoScientia.Entity.Universidad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoUniversidad extends MongoRepository<Universidad, String > {
}
