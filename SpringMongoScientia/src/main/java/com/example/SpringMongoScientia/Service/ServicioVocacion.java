package com.example.SpringMongoScientia.Service;

import com.example.SpringMongoScientia.Entity.Vocacion;
import com.example.SpringMongoScientia.Repo.RepoVocacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioVocacion {
    @Autowired
    private final RepoVocacion repoVocacion;

    public ServicioVocacion(RepoVocacion repoVocacion) {
        this.repoVocacion = repoVocacion;
    }



    public void saveorUpdate(Vocacion vocacion) {
        repoVocacion.save(vocacion);
    }

    public Iterable<Vocacion> listAll() {
        return this.repoVocacion.findAll();
    }

    public void delete(String id) {
        this.repoVocacion.deleteById(id);
    }

    public Vocacion getvocacionPorId(String vocacionid) {
        return this.repoVocacion.findById(vocacionid).get();
    }

    public Iterable<Vocacion> vocacionPorEstudiante(String idEstudiante) {
        return repoVocacion.findByidEstudiante(idEstudiante);
    }
}
