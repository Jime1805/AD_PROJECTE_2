package com.ra34.projecte2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.service.ProducteService;
import org.springframework.web.bind.annotation.PatchMapping;



@RestController
@RequestMapping("/api")
public class ProducteController {

    @Autowired
    ProducteService producteService;

    
    @PatchMapping("/producte/estoc")
    public ResponseEntity<String> updateEstocProducte(@RequestParam Long id, @RequestParam int newEstoc) {
        String updated = producteService.updateEstocProducte(id, newEstoc);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @PatchMapping("/producte/preu")
    public ResponseEntity<String> updatePreuProducte(@RequestParam Long id, @RequestParam int newPreu) {
        String updated = producteService.updatePreuProducte(id, newPreu);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    

    // Separació Eric a baix, Marc a dalt.

}
