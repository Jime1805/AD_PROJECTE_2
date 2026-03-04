package com.ra34.projecte2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // Separació Eric a baix, Marc a dalt.

}
