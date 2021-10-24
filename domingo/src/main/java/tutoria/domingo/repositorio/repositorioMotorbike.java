/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.repositorio;

import tutoria.domingo.interfaces.interfaceMotorbike;
import tutoria.domingo.modelo.motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MANDO
 */

@Repository
public class repositorioMotorbike {
    
    @Autowired
    private interfaceMotorbike crud4;
    

    public List<motorbike> getAll(){
        return (List<motorbike>) crud4.findAll();       
    }
    
    public Optional <motorbike> getMotorbike(int id){
        return crud4.findById(id);
    }
    
    public motorbike save(motorbike motorbike){
        return crud4.save(motorbike);
    }
     public void delete(motorbike motorbike){
        crud4.delete(motorbike);
    }

    public Optional<motorbike> findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
