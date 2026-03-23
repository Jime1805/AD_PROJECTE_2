package com.ra34.projecte2.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ra34.projecte2.model.Condition;
import com.ra34.projecte2.model.Producte;
import com.ra34.projecte2.repository.ProducteRepository;

import jakarta.transaction.Transactional;

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
        String respons = producteRepository.updateStatusById(id, false);

        if (respons == null) return "No s'ha trobat el producte amb id: " + id;

        return "S'ha fet el borrat logic del producte: {" + id + "}";
    }

    public String deleteProducteById(Long id) {
        producteRepository.deleteById(id);

        Optional<Producte> exists = producteRepository.findById(id);

        if (exists.isEmpty()) return "S'ha borrat el producte: {" + id + "}";
            
        return "No s'ha pogut borrar el producte amb id: " + id;
    }

    @Transactional
    public String createProducteBatchCSV(MultipartFile csvFile) {
        int numeroLinia = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csvFile.getInputStream()))) {
            String linia = br.readLine();

            while ((linia = br.readLine()) != null) {
                numeroLinia++;
                // Separar per comes (CSV simple)
                String[] camps = linia.split(",");

                if (camps.length != 7) throw new Exception("");

                Producte p = new Producte();

                p.setNombre(camps[0]);
                p.setDescripcion(camps[1]);
                p.setStock(Integer.parseInt(camps[2]));
                p.setPrice(Float.parseFloat(camps[3]));
                p.setRating(Float.parseFloat(camps[4]));
                p.setCondition(Condition.valueOf(camps[5].toUpperCase()));

                producteRepository.save(p);
            }

            // Path pathDirectori = Paths.get("accessadades-ra2-ac2/private/csv_processed");
            // Path pathFitxer = Paths.get("accessadades-ra2-ac2/private/csv_processed/"
            //         + System.currentTimeMillis() + csvFile.getOriginalFilename());

            // Files.createDirectories(pathDirectori);
            // Files.copy(csvFile.getInputStream(), pathFitxer);

            return numeroLinia + " usuaris creats";
        } catch (Exception e) {
            return "Error en la linia: " + numeroLinia + " del fitxer.";
        }
    }

    public List<Producte> findProductsByNameWithPrefix(String prefix) {
        List<Producte> productes = producteRepository.findNombreByPrefix(prefix);

        return productes;
    }

    public List<Producte> findProductOrderByPrice(String order) {
        List<Producte> productesOrdenars = producteRepository.findProducteByPriceOrder(order);
        return productesOrdenars;
    }

    public List<Producte> findProducteByPriceRange(Double priceMin, Double priceMax, String prefix) {
        List<Producte> productes = producteRepository.findProducteByPriceRange(priceMin, priceMax, prefix);
        return productes;
    }

    public List<Producte> findProducteTop5QualitatPreu() {
        List<Producte> productes = producteRepository.findProducteTop5QualitatPreu();
        return productes;
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
        producte.setId(null);
        return producteRepository.save(producte);
    }

    public Producte updatingProducte(Long id, Producte producte){
        Optional<Producte> existing = producteRepository.findById(id);

        if (existing.isPresent()) {
            Producte prod = existing.get();
            BeanUtils.copyProperties(producte, prod, "id", "dataUpdated");
            prod.setDataUpdated(new Date());
            return producteRepository.save(prod);
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

    public List<Producte> gettingByCampLimitAndRatingRange(String camp, double ratingMin, double ratingMax, String order, double limit){
        if (camp.equalsIgnoreCase("price")) {
            return producteRepository.findPriceByRatingRange(ratingMin, ratingMax, order, limit);
        } 
        else if (camp.equals("rating")) {
            return producteRepository.findRatingByRatingRange(ratingMin, ratingMax, order, limit);
        }
        return null;
    }

    public Page<Producte> gettingWithPage(Pageable pageable){
        return producteRepository.findAll(pageable);
    }
        
}
