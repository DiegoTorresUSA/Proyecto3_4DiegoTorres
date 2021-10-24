/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tutoria.domingo.modelo.motorbike;
import tutoria.domingo.servicios.serviciosMotorbike;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Motorbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebMoto {
    
    @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo Tutoria";
    }

    
    @Autowired
    private serviciosMotorbike servicio;
    
    @GetMapping("all")
    public List <motorbike> getMotos(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<motorbike> getMotos(@PathVariable("id") int motoId) {
        return servicio.getMotos(motoId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public motorbike save(@RequestBody motorbike motorbike) {
        return servicio.save(motorbike);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public motorbike update(@RequestBody motorbike motorbike) {
        return servicio.update(motorbike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int motoId) {
        return servicio.deleteOrtesis(motoId);
    }
    
}
