package com.ra34.projecte2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.model.Producte;
import com.ra34.projecte2.service.ProducteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
public class ProducteController {

    @Autowired
    ProducteService producteService;


    // Separació Eric a baix, Marc a dalt.

    @GetMapping("/producte")
    public ResponseEntity<List<Producte>> getAllProductes() {
        List<Producte> finded = producteService.getingAllProductes();
        if (finded == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(finded);
    }

    @GetMapping("/producte/{id}")
    public ResponseEntity<Producte> getMethodName(@PathVariable Long id) {
        Producte finded = producteService.getingProducteById(id);
        if (finded == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(finded);
    }
    
    @PostMapping("path")
    public ResponseEntity<String> postMethodName(@RequestBody Producte producte) {
        Producte posting = producteService.postingProducte(producte);
        if (posting == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No s'ha pogut afegir l'usuari");
        }
        return ResponseEntity.status(HttpStatus.OK).body("S'ha afegit correctament l'usuari");
    }

    //falta endpoint update
    
}
