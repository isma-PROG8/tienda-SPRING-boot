package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HolaController {

    @Autowired
    private TiendaService tiendaService; // Conectamos con el almacén de productos



    @GetMapping("/tienda/guardar")
    public String guardar(@RequestParam String nombre, @RequestParam double precioUnidad ,@RequestParam int stock) {
        // Creamos el producto y lo guardamos en el servicio
        Producto nuevo = new Producto(nombre, precioUnidad , stock);
        tiendaService.agregar(nuevo);
        return "Has guardado : " + nombre + " por " + precioUnidad + "€. ¡Producto guardado!";
    }

    @GetMapping("/tienda/ver-todos")
    public List<Producto> verTodos() {
        return tiendaService.obtenerTodos();
    }

    @GetMapping("/calculadora")
    public String calcularIva(@RequestParam double precio) {
        if (precio <= 0) return "El precio debe ser mayor a cero";
        return "El precio con IVA es: " + (precio * 1.21);
    }
    @GetMapping("/tienda/borrar")
    public String borrar(@RequestParam Long id) {
        tiendaService.eliminar(id);
        return "Producto con ID " + id + " eliminado con éxito.";
    }
    @GetMapping("/tienda/baratos")
    public List<Producto> verBaratos(@RequestParam double precio) {
        return tiendaService.buscarBaratos(precio);
    }
    @GetMapping("/tienda/media")
    public String verMedia() {
        double media= tiendaService.obtenerMediaPrecio();
        return "El precio medio de los Productos es " +media+ "euros";
    }
    @GetMapping ("/tienda/buscar")
    public List<Producto>buscar(@RequestParam String nombre) {
        return tiendaService.buscarPorNombre(nombre);
    }
    @GetMapping("tienda/buscarid")
    public Producto buscarId(@RequestParam long id) {
        return tiendaService.buscarPorId(id);
    }
}