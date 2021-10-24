/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import tutoria.domingo.modelo.motorbike;
import tutoria.domingo.repositorio.repositorioMotorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author MANDO
 */
@Service
public class serviciosMotorbike {
    @Autowired
    private repositorioMotorbike metodosCrud;
    
    public List<motorbike> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<motorbike> getMoto(int id){
        return metodosCrud.getMotorbike(id);
    }
    
    public motorbike save(motorbike motorbike) {
        if (motorbike.getId() == null) {
            return metodosCrud.save(motorbike);
        } else {
            Optional<motorbike> mot = metodosCrud.findById(motorbike.getId());
            if (mot.isEmpty()) {
                return metodosCrud.save(motorbike);
            } else {
                return motorbike;
            }
        }
    }

    public motorbike update(motorbike moto) {
        if (moto.getId() != null) {
            Optional<motorbike> mot = metodosCrud.findById(moto.getId());
            if (!mot.isEmpty()) {
                if (moto.getName() != null) {
                    mot.get().setName(moto.getName());
                }
                if (moto.getBrand() != null) {
                    mot.get().setBrand(moto.getBrand());
                }
                if (moto.getYear() != null) {
                    mot.get().setYear(moto.getYear());
                }
                if (moto.getDescription() != null) {
                    mot.get().setDescription(moto.getDescription());
                }
                if (moto.getCategory() != null) {
                    mot.get().setCategory(moto.getCategory());
                }
                metodosCrud.save(mot.get());
                return mot.get();
            } else {
                return moto;
            }
        } else {
            return moto;
        }

    }

    public boolean deleteMoto(int id) {
        Boolean motoBoolean = metodosCrud.findById(id).map(moto -> {
            metodosCrud.delete(moto);
            return true;
        }).orElse(false);
        return motoBoolean;
    }

    public Optional<motorbike> getMotos(int motoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteOrtesis(int motoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
