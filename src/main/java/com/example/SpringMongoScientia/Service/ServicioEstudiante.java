package com.example.SpringMongoScientia.Service;

import com.example.SpringMongoScientia.Entity.Estudiante;
import com.example.SpringMongoScientia.Repo.RepoEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEstudiante {
    @Autowired
    private RepoEstudiante repoEstudiante;
    public void saveorUpdate(Estudiante estudiante) {
    repoEstudiante.save(estudiante);
    }

    public Iterable<Estudiante> listAll() {
       return this.repoEstudiante.findAll();
    }

    public void delete(String id) {
        this.repoEstudiante.deleteById(id);
    }

    public Estudiante getEstudiantePorId(String estudianteid) {
       return this.repoEstudiante.findById(estudianteid).get();
    }
}
