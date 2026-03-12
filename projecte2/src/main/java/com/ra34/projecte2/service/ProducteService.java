package com.ra34.projecte2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.ra34.projecte2.model.Condition;
import com.ra34.projecte2.model.Producte;
import com.ra34.projecte2.repository.ProducteRepository;

@Service
public class ProducteService {

    @Autowired
    ProducteRepository producteRepository;

    public String updateEstocProducte(Long id, int newEstoc) {
        String updated = producteRepository.updateEstocById(id, newEstoc);

        if (updated == null) return "No s'ha trobat el producte amb id: " + id;

        return "S'ha modificat l'estoc del producte: {" + id + "} a {" + newEstoc + "}.";
    }

    public String updatePreuProducte(Long id, int newPreu) {
        String updated = producteRepository.updatePreuById(id, newPreu);

        if (updated == null) return "No s'ha trobat el producte amb id: " + id;

        return "S'ha modificat el preu del producte: {" + id + "} a {" + newPreu + "}.";
    }

    public String borratLogicById(Long id) {
        String respons = producteRepository.updateStatusById(id, true);

        if (respons == null) return "No s'ha trobat el producte amb id: " + id;

        return "S'ha fet el borrat logic del producte: {" + id + "}";
    }

    public String deleteProducteById(Long id) {
        producteRepository.deleteById(id);

        Optional<Producte> exists = producteRepository.findById(id);

        if (exists.isEmpty()) return "S'ha borrat el producte: {" + id + "}";
            
        return "No s'ha pogut borrar el producte amb id: " + id;
    }

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

    public List<Producte> getingByCondition(Condition condition){ //4.1 Integrant 2
        return producteRepository.findByConditionAndStatusTrue(condition);
    }

    public List<Producte> gettingByRattingWithOrder(String camp, String order){ //4.2 Integrant 2
        if (camp.equalsIgnoreCase("price")) {
            return producteRepository.findByPriceRange(order);
        }
        else if(camp.equalsIgnoreCase("rating")){
            return producteRepository.findByRatingRange(order);
        }
        return null;
    }

    public List<Producte> gettingByPriceLimitAndRatingRange(double ratingMin, double ratingMax, String order, double limit){
        return producteRepository.findByRatingRange(ratingMin, ratingMax, order, limit);
    }
        
}
