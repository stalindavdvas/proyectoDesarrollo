package com.example.SpringMongoScientia.Controller;

import com.example.SpringMongoScientia.Entity.Carrera;
import com.example.SpringMongoScientia.Entity.CarreraConNombreUniversidad;
import com.example.SpringMongoScientia.Entity.Estudiante;
import com.example.SpringMongoScientia.Service.ServicioCarrera;
import com.example.SpringMongoScientia.Service.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/carreras")
public class ControladorCarreras {
    @Autowired
    private ServicioCarrera servicioCarrera;


        @PostMapping(value = "/save")
    private String guardarCarrera(@RequestBody Carrera carrera){
        servicioCarrera.saveorUpdate(carrera);
        return carrera.get_id();
    }
    @GetMapping(value = "/getAll")
    private Iterable<Carrera> listarCarreras(){
        return servicioCarrera.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Carrera actualizar(@RequestBody Carrera carrera, @PathVariable(name="id") String _id) {
        carrera.set_id(_id);
        servicioCarrera.saveorUpdate(carrera);
        return carrera;
    }
    @DeleteMapping(value = "/delete/{id}")
    private void eliminar(@PathVariable("id") String _id) {
        servicioCarrera.delete(_id);
    }

    @RequestMapping("/search/{id}")
    private Carrera getCarrera(@PathVariable(name="id")String carreraid){

        return servicioCarrera.getCarreraPorId(carreraid);
    }
    @GetMapping(value = "/getByUniversidad/{id}")
    private Iterable<Carrera> listarCarrerasPorUniversidad(@PathVariable(name="id") String universidadid){
        return servicioCarrera.carreraPorUniversidad(universidadid);
    }

    @GetMapping("/conUniversidad")
    public List<CarreraConNombreUniversidad> encontrarCarreraUniversidad() {
        return servicioCarrera.obtenerCarrerasConNombreUniversidad();
    }
}
