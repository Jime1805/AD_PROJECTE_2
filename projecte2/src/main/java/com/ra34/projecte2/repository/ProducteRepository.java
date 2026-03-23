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

    @Query("SELECT p FROM productos p WHERE p.nombre LIKE :prefix'%' AND p.status = true")
    List<Producte> findNombreByPrefix(@Param("prefix") String prefix);

    @Query("SELECT p FROM Producte p WHERE p.status = true ORDER BY " +
            "CASE WHEN :order = 'asc' THEN p.precio END ASC, " +
            "CASE WHEN :order = 'desc' THEN p.precio END DESC")
    List<Producte> findProducteByPriceOrder(@Param("order") String order);

    @Query("SELECT p FROM Producte p WHERE p.precio BETWEEN :priceMin AND :priceMax " +
            "AND p.nombre LIKE :prefix% " +
            "AND p.status = 1")
    List<Producte> findProducteByPriceRange(
            @Param("priceMin") Double priceMin,
            @Param("priceMax") Double priceMax,
            @Param("prefix") String prefix);

    // Separació Eric a baix, Marc a dalt.

    List<Producte> findByConditionAndStatusTrue(Condition condition); // 4.1 Integrant 2

    @Query("SELECT p FROM Producte p WHERE p.status = true ORDER BY CASE WHEN :order = 'asc' THEN p.price END ASC, CASE WHEN :order = 'desc' "
            + " THEN p.price END DESC")
    List<Producte> findByPriceRange(@Param("order") String order); // 4.2 Integrant 2

    @Query("SELECT p FROM Producte p WHERE p.status = true ORDER BY CASE WHEN :order = 'asc' THEN p.rating END ASC, CASE WHEN :order = 'desc' "
            + " THEN p.rating END DESC")
    List<Producte> findByRatingRange(@Param("order") String order); // 4.2 Integrant 2

    @Query("SELECT p FROM Producte p WHERE p.rating BETWEEN :ratingMin AND :ratingMax AND p.status=true and p.price <= :limit ORDER BY "
            +
            "CASE WHEN :order = 'asc' THEN p.rating END ASC, CASE WHEN :order = 'desc' THEN p.rating END DESC")
    List<Producte> findPriceByRatingRange(@Param("ratingMin") double ratingMin, @Param("ratingMax") double ratingMax,
            @Param("order") String order, @Param("limit") double limit); // 5.1 Integrant 2

    @Query("SELECT p FROM Producte p WHERE p.rating BETWEEN :ratingMin AND :ratingMax AND p.status=true and p.rating <= :limit ORDER BY "
            +
            "CASE WHEN :order = 'asc' THEN p.rating END ASC, CASE WHEN :order = 'desc' THEN p.rating END DESC")
    List<Producte> findRatingByRatingRange(@Param("ratingMin") double ratingMin, @Param("ratingMax") double ratingMax,
            @Param("order") String order, @Param("limit") double limit); // 5.1 Integrant 2
}
