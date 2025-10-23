/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.bibliotecaapp.controller;
import com.biblioteca.bibliotecaapp.service.GeneroServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generos")
public class GeneroControlador {

    private final GeneroServicio generoServicio;

    public GeneroControlador(GeneroServicio generoServicio) {
        this.generoServicio = generoServicio;
    }

    @GetMapping("/lista")
    public String listarGeneros(Model modelo) {
        modelo.addAttribute("generos", generoServicio.listarGeneros());
        return "generos";
    }
}
