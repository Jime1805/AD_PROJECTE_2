package com.ra34.projecte2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ra34.projecte2.model.Producte;

public interface ProducteRepository extends JpaRepository<Producte, Long> {
    
    @Query("update Producte p set p.estoc = :estoc where id = :id")
    String updateEstocById(@Param("id") Long id, @Param("estoc") int estoc);

    @Query("update Producte p set p.preu = :preu where id = :id")
    String updatePreuById(@Param("id") Long id, @Param("preu") int preu);

    // Borrat logic
    @Query("update Producte p set p.status = :status where id = :id")
    String updateStatusById(@Param("id") Long id, @Param("status") boolean status);

    // Separació Eric a baix, Marc a dalt.

}
