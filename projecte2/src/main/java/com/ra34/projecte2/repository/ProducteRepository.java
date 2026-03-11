package com.ra34.projecte2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ra34.projecte2.model.Condition;
import com.ra34.projecte2.model.Producte;


public interface ProducteRepository extends JpaRepository<Producte, Long> {
    
    @Query("update Producte p set p.stock = :stock where id = :id")
    String updateEstocById(@Param("id") Long id, @Param("stock") int stock);

    @Query("update Producte p set p.price = :price where id = :id")
    String updatePreuById(@Param("id") Long id, @Param("price") int price);

    // Borrat logic
    @Query("update Producte p set p.status = :status where id = :id")
    String updateStatusById(@Param("id") Long id, @Param("status") boolean status);

    // Separació Eric a baix, Marc a dalt.

    List<Producte> findByConditionAndStatusTrue(Condition condition); // 4.1 Integrant 2
    
    @Query("SELECT p FROM Product p WHERE p.status = true ORDER BY CASE WHEN :order = 'asc' THEN p.price END ASC, CASE WHEN :order = 'desc' "
        + " THEN p.price END DESC"
    )
    List<Producte> findByPriceRange(String order); //4.2 Integrant 2

    @Query("SELECT p FROM Product p WHERE p.status = true ORDER BY CASE WHEN :order = 'asc' THEN p.rating END ASC, CASE WHEN :order = 'desc' "
        + " THEN p.rating END DESC"
    )
    List<Producte> findByRatingRange(String order); // 4.2 Integrant 2

    @Query("SELECT p FROM Product p WHERE p.rating BETWEEN :ratingMin AND :ratingMax AND p.status=true ORDER BY " +
            "CASE WHEN :order = 'asc' THEN p.rating END ASC, CASE WHEN :order = 'desc' THEN p.rating END DESC")
    List<Producte> findByRatingRange(double ratingMin, double ratingMax, String order); //5.1 Integrant 2 revisar
}
