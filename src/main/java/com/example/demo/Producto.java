package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Esto le dice a Spring que cree una tabla llamada "producto"
public class Producto {

    @Id // Define que este campo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hace que el ID sea 1, 2, 3... automático
    private Long id;

    public String nombre;
    public double precio;

    // Constructor vacío (OBLIGATORIO para que Spring pueda leer de la base de datos)
    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters para el ID (puedes generarlos con Click derecho -> Generate -> Getter and Setter)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}