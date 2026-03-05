package com.ra34.projecte2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ra34.projecte2.model.Condition;
import com.ra34.projecte2.model.Producte;

public interface ProducteRepository extends JpaRepository<Producte, Long> {
    
    @Query("update Producte p set p.estoc = :estoc where id = :id")
    String updateEstocById(@Param("id") Long id, @Param("estoc") int estoc);

    @Query("update Producte p set p.preu = :preu where id = :id")
    String updatePreuById(@Param("id") Long id, @Param("preu") int preu);

    // Separació Eric a baix, Marc a dalt.

    List<Producte> findByConditionAndStatusTrue(Condition condition); // Cambiar si esta mal

}
