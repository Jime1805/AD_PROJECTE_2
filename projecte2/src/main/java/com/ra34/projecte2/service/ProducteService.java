package com.ra34.projecte2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.model.Producte;
import com.ra34.projecte2.repository.ProducteRepository;

@Service
public class ProducteService {
    
    @Autowired
    ProducteRepository producteRepository;

    // Separació Eric a baix, Marc a dalt.

    public List<Producte> getingAllProductes(){
        return producteRepository.findAll();
    }

    public Producte getingProducteById(Long id){
        Optional<Producte> finded = producteRepository.findById(id);
        if (!finded.isPresent()) {
            return null;
        }
        return finded.get();
    }

    public Producte postingProducte(Producte producte){
        Producte entity = new Producte();
        if (producteRepository.findById(producte.getId()).isPresent()) {
            BeanUtils.copyProperties(producte, entity);
            entity.setId(null);
            return producteRepository.save(entity);
        }
        return null;
    }

    public Producte updatingProducte(Producte producte){
        Producte entity = new Producte();
        if (producteRepository.findById(producte.getId()).isPresent()) {
            BeanUtils.copyProperties(producte, entity);
            return producteRepository.save(entity);
        }
        return null;
    }

}
