package com.example.SpringMongoScientia.Controller;

import com.example.SpringMongoScientia.Entity.Universidad;

import com.example.SpringMongoScientia.Service.ServicioUniversidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/universidad")
public class ControladorUniversidad {

    @Autowired
    private ServicioUniversidad servicioUniversidad;


    @PostMapping(value = "/save") //api/v1/universidad/save
    private String guardarUniversidad(@RequestBody Universidad universidad){
        servicioUniversidad.saveorUpdate(universidad);
        return universidad.get_id();
    }

    @GetMapping(value = "/getAll")//api/v1/universidad/getAll
    private Iterable<Universidad> listarUniversidades(){
        return servicioUniversidad.listAll();
    }

    @PutMapping(value = "/edit/{id}")//api/v1/universidad/edit/{id}
    private Universidad actualizar(@RequestBody Universidad universidad, @PathVariable(name="id") String _id) {
        universidad.set_id(_id);
        servicioUniversidad.saveorUpdate(universidad);
        return universidad;
    }
    @DeleteMapping(value = "/delete/{id}")
    private void eliminar(@PathVariable("id") String _id) {
        servicioUniversidad.delete(_id);
    }

    @RequestMapping("/search/{id}")
    private Universidad getUniversidad(@PathVariable(name="id")String universidadid){

        return servicioUniversidad.getUniversidadPorId(universidadid);
    }


}
