package com.example.SpringMongoScientia.Controller;

import com.example.SpringMongoScientia.Entity.Estudiante;
import com.example.SpringMongoScientia.Service.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/estudiante")
public class ControladorEstudiante {

    @Autowired
    private ServicioEstudiante servicioEstudiante;


    @PostMapping(value = "/save")
    private String guardarEstudiante(@RequestBody Estudiante estudiante){
        servicioEstudiante.saveorUpdate(estudiante);
        return estudiante.get_id();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Estudiante> listarEstudiantes(){
        return servicioEstudiante.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Estudiante actualizar(@RequestBody Estudiante estudiante, @PathVariable(name="id") String _id) {
        estudiante.set_id(_id);
        servicioEstudiante.saveorUpdate(estudiante);
        return estudiante;
    }
    @DeleteMapping(value = "/delete/{id}")
    private void eliminar(@PathVariable("id") String _id) {
        servicioEstudiante.delete(_id);
    }

    @RequestMapping("/search/{id}")
    private Estudiante getEstudiante(@PathVariable(name="id")String estudianteid){

        return servicioEstudiante.getEstudiantePorId(estudianteid);
    }

}
