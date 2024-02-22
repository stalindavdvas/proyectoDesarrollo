package com.example.SpringMongoScientia.Controller;

import com.example.SpringMongoScientia.Entity.Estudiante;
import com.example.SpringMongoScientia.Entity.LoginRequest;
import com.example.SpringMongoScientia.Service.ServicioEstudiante;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/estudiante")
public class ControladorEstudiante {

    @Autowired
    private ServicioEstudiante servicioEstudiante;


//    @PostMapping(value = "/save")
//    private String guardarEstudiante(@RequestBody Estudiante estudiante){
//        servicioEstudiante.saveorUpdate(estudiante);
//        return estudiante.get_id();
//    }
@PostMapping(value = "/save")
public ResponseEntity<String> guardarEstudiante(@RequestBody Estudiante estudiante) {
    try {
        servicioEstudiante.saveorUpdate(estudiante);
        return new ResponseEntity<>("Estudiante guardado correctamente", HttpStatus.CREATED);
    } catch (DuplicateKeyException e) {
        // Manejar el error y devolver un mensaje personalizado al usuario
        String mensajeError = "El estudiante con correo o DNI duplicado ya existe.";
        return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
    }
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

    @PostMapping("/login")
    public ResponseEntity<Estudiante> login(@RequestBody LoginRequest loginRequest) {
        String correo = loginRequest.getCorreo();
        String password = loginRequest.getPassword();

        Estudiante estudiante = servicioEstudiante.login(correo, password);

        if (estudiante != null) {
            // Login exitoso, devolver el objeto completo
            return ResponseEntity.ok(estudiante);
        } else {
            // Credenciales inválidas
            return ResponseEntity.status(401).body(null);
        }
    }
}
