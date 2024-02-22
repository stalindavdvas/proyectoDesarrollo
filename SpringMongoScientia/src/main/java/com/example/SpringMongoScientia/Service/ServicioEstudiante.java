package com.example.SpringMongoScientia.Service;

import com.example.SpringMongoScientia.Entity.Estudiante;
import com.example.SpringMongoScientia.Repo.EstudianteService;
import com.example.SpringMongoScientia.Repo.RepoEstudiante;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEstudiante implements EstudianteService {
    @Autowired
    private RepoEstudiante repoEstudiante;
    public void saveorUpdate(Estudiante estudiante) {
        try {
            repoEstudiante.save(estudiante);
        } catch (DuplicateKeyException e) {
            // Manejar el error, por ejemplo, devolver un mensaje de error al usuario
            // o realizar alguna otra acción apropiada.
            // Puedes personalizar el manejo del error según tus necesidades.

            System.out.println("Estudiante con cedula ya existe "+e.toString());// O loggear el error para referencia futura
        }
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
    @Override
    public Estudiante login(String correo, String password) {
        return repoEstudiante.findByCorreoAndPassword(correo, password);
    }
}
