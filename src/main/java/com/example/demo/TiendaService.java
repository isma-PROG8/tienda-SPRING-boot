package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TiendaService {

    @Autowired
    private ProductoRepository productoRepository;
    // Inyectamos el repositorio real


    public void agregar(Producto p) {
        // Antes: lista.add(p)
        // AHORA:
        productoRepository.save(p);
    }

    public List<Producto> obtenerTodos() {
        // Antes: return lista
        // AHORA:
        return productoRepository.findAll();
    }
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
    public List<Producto> buscarBaratos(double precioMax) {
        return productoRepository.findByPrecioLessThan(precioMax);
    }
    public double obtenerMediaPrecio(){
        List<Producto>todos=productoRepository.findAll();
        System.out.println("He encontrado estos productos: " + todos.size());
        if (todos.isEmpty()) return 0.0;
        double suma=0;
        for (Producto p :todos){
            suma=suma+p.precio;
        }
        return suma / todos.size();

    }
    public List<Producto> buscarPorNombre(String palabra) {
        // Llamamos al repo y devolvemos la lista que nos dé
        return productoRepository.findByNombreContainingIgnoreCase(palabra);
    }
    public Producto buscarPorId(long id){
        return  productoRepository.findById(id).orElse(null);


    }

}