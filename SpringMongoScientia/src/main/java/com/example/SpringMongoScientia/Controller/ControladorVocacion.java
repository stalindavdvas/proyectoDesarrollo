package com.example.SpringMongoScientia.Controller;

import com.example.SpringMongoScientia.Entity.Vocacion;
import com.example.SpringMongoScientia.Service.ServicioVocacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/vocacion")
public class ControladorVocacion {
    @Autowired
    private ServicioVocacion servicioVocacion;
    @PostMapping(value = "/save")
    private String guardarCarrera(@RequestBody Vocacion vocacion){
        servicioVocacion.saveorUpdate(vocacion);
        return vocacion.get_id();
    }
    @GetMapping(value = "/getAll")
    private Iterable<Vocacion> listarVocacion(){
        return servicioVocacion.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Vocacion actualizar(@RequestBody Vocacion vocacion, @PathVariable(name="id") String _id) {
        vocacion.set_id(_id);
        servicioVocacion.saveorUpdate(vocacion);
        return vocacion;
    }
    @DeleteMapping(value = "/delete/{id}")
    private void eliminar(@PathVariable("id") String _id) {
        servicioVocacion.delete(_id);
    }

    @RequestMapping("/search/{id}")
    private Vocacion getVocacion(@PathVariable(name="id")String carreraid){

        return servicioVocacion.getvocacionPorId(carreraid);
    }
    @GetMapping(value = "/getByEstudiante/{id}")
    private Iterable<Vocacion> listarVocacionPorEstudiante(@PathVariable(name="id") String estudianteid){
        return servicioVocacion.vocacionPorEstudiante(estudianteid);
    }

}
