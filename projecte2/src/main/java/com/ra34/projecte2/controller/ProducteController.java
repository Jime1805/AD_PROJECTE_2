package com.ra34.projecte2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.model.Condition;
import com.ra34.projecte2.model.Producte;
import com.ra34.projecte2.service.ProducteService;
import org.springframework.web.bind.annotation.PutMapping;


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

    @PatchMapping("/producte/borratlogic")
    public ResponseEntity<String> borratLogicById(@RequestParam Long id) {
        String respons = producteService.borratLogicById(id);
        return ResponseEntity.status(HttpStatus.OK).body(respons);
    }

    // Separació Eric a baix, Marc a dalt.

    @GetMapping("/producte")
    public ResponseEntity<List<Producte>> getAllProductes() {
        List<Producte> finded = producteService.getingAllProductes();
        if (finded == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(finded);
    }

    @GetMapping("/producte/id/{id}")
    public ResponseEntity<Producte> getProductesById(@PathVariable Long id) {
        Producte finded = producteService.getingProducteById(id);
        if (finded == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(finded);
    }

    @PostMapping("/producte/producte")
    public ResponseEntity<String> postProducte(@RequestBody Producte producte) {
        Producte posting = producteService.postingProducte(producte);
        if (posting == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No s'ha pogut afegir l'usuari");
        }
        return ResponseEntity.status(HttpStatus.OK).body("S'ha afegit correctament l'usuari");
    }

    @PutMapping("/producte/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable String id, @RequestBody Producte producte) {
        Producte updating = producteService.updatingProducte(producte);
        if (updating == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No s'ha pogut actualitzar el producte");
        }
        return ResponseEntity.status(HttpStatus.OK).body("S'ha actualitzat el producte correctament");
    }

    @GetMapping("/producte/search/condition") // 4.1 Integrant 2
    public ResponseEntity<List<Producte>> getByCondition(@RequestParam Condition condition) {
        List<Producte> finded = producteService.getingByCondition(condition);
        if (finded == null || finded.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(finded);
    }

    @GetMapping("/api/products/search/condition") // 4.2 Integrant 2
    public ResponseEntity<List<Producte>> getByRattingWithOrder(@RequestParam String camp, @RequestParam String order) {
        List<Producte> finded = producteService.gettingByRattingWithOrder(camp, order);
        if (finded == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(finded);
        }
        return ResponseEntity.status(HttpStatus.OK).body(finded);
    }
    
    @GetMapping("/products/search/order/{rating_min}/{rating_max}/{limit}") // 5.1 Integrant 2
    public ResponseEntity<List<Producte>> getByPriceLimitAndRatingRange(@PathVariable float rating_min, @PathVariable float rating_max, @PathVariable float limit, @RequestParam String camp, @RequestParam String order) {
        List<Producte> finded = producteService.gettingByPriceLimitAndRatingRange(rating_min, rating_max, order, limit);
        if (finded == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(finded);
        }
        return ResponseEntity.status(HttpStatus.OK).body(finded);
    }

    @GetMapping("/products/page") // 6.1 Integrant 2
    public Page<Producte> getWithPage() {
        Pageable pageable = PageRequest.of(0, 5);
        return producteService.gettingWithPage(pageable);
    }
    
    
}
