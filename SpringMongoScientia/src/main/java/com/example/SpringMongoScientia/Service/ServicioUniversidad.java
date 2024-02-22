package com.example.SpringMongoScientia.Service;

import com.example.SpringMongoScientia.Entity.Universidad;
import com.example.SpringMongoScientia.Repo.RepoUniversidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUniversidad {
   @Autowired
    private RepoUniversidad repoUniversidad;
    public void saveorUpdate(Universidad universidad) {
        repoUniversidad.save(universidad);
    }

    public Iterable<Universidad> listAll() {
        return this.repoUniversidad.findAll();
    }

    public void delete(String id) {
        this.repoUniversidad.deleteById(id);
    }

    public Universidad getUniversidadPorId(String univerisadid) {
        return this.repoUniversidad.findById(univerisadid).get();
    }
}
