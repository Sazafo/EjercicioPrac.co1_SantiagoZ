/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.bibliotecaapp.controller;
import com.biblioteca.bibliotecaapp.domain.Libro;
import com.biblioteca.bibliotecaapp.service.GeneroServicio;
import com.biblioteca.bibliotecaapp.service.LibroServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroControlador {

    private final LibroServicio libroServicio;
    private final GeneroServicio generoServicio;

    public LibroControlador(LibroServicio libroServicio, GeneroServicio generoServicio) {
        this.libroServicio = libroServicio;
        this.generoServicio = generoServicio;
    }

  
    @GetMapping("/lista")
    public String listarLibros(Model modelo) {
        modelo.addAttribute("libros", libroServicio.listarLibros());
        return "libros/listado";
    }


    @GetMapping("/nuevo")
    public String nuevoLibro(Model modelo) {
        modelo.addAttribute("libro", new Libro());
        modelo.addAttribute("generos", generoServicio.listarGeneros());
        return "libros/formulario"; 
    }
    
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroServicio.guardar(libro);
        return "redirect:/libros/lista";
    }

 
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable("id") Long id) {
        libroServicio.eliminar(id);
        return "redirect:/libros/lista";
    }
}

