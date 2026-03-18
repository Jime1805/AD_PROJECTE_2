package com.ra34.projecte2.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "producte")
public class Producte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private int stock;
    private float price;
    private float rating;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "`condition`")
    private Condition condition;
    
    private boolean status;

    @Column(name = "data_created", insertable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataCreated;
    
    @Column(name = "data_updated", insertable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataUpdated;

    public Producte() {
    }

    public Producte(Long id, String nombre, String descripcion, int stock, float price, float rating,
            Condition condition, boolean status, Date dataCreated, Date dataUpdated) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.price = price;
        this.rating = rating;
        this.condition = condition;
        this.status = status;
        this.dataCreated = dataCreated;
        this.dataUpdated = dataUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Date dataCreated) {
        this.dataCreated = dataCreated;
    }

    public Date getDataUpdated() {
        return dataUpdated;
    }

    public void setDataUpdated(Date dataUpdated) {
        this.dataUpdated = dataUpdated;
    }
}
