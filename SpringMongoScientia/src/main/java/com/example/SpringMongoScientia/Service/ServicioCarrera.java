package com.example.SpringMongoScientia.Service;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import com.example.SpringMongoScientia.Entity.Carrera;
import com.example.SpringMongoScientia.Entity.CarreraConNombreUniversidad;
import com.example.SpringMongoScientia.Entity.Universidad;
import com.example.SpringMongoScientia.Repo.RepoCarrera;
import com.example.SpringMongoScientia.Repo.RepoUniversidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCarrera {
     private final RepoCarrera repoCarrera;
    private final MongoTemplate mongoTemplate;


    @Autowired
    public ServicioCarrera(RepoCarrera repoCarrera, MongoTemplate mongoTemplate) {
        this.repoCarrera = repoCarrera;
        this.mongoTemplate = mongoTemplate;
    }
    public void saveorUpdate(Carrera carrera) {
        repoCarrera.save(carrera);
    }

    public Iterable<Carrera> listAll() {
        return this.repoCarrera.findAll();
    }

    public void delete(String id) {
        this.repoCarrera.deleteById(id);
    }

    public Carrera getCarreraPorId(String carreraid) {
        return this.repoCarrera.findById(carreraid).get();
    }

    public Iterable<Carrera> carreraPorUniversidad(String idUniversidad) {
        return repoCarrera.findByidUniversidad(idUniversidad);
    }
    public List<CarreraConNombreUniversidad> obtenerCarrerasConNombreUniversidad() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.lookup("universidad", "idUniversidad", "_id", "universidad"),
                Aggregation.unwind("universidad"),
                Aggregation.project()
                        .andExclude("_id")
                        .and("nombre").as("nombre")
                        .and("titulo").as("titulo")
                        .and("duracion").as("duracion")
                        .and("idUniversidad").as("idUniversidad")
                        .and("universidad.nombre").as("universidad")
        );

        AggregationResults<CarreraConNombreUniversidad> result = mongoTemplate.aggregate(aggregation, "carreras", CarreraConNombreUniversidad.class);

        return result.getMappedResults();
    }
}
