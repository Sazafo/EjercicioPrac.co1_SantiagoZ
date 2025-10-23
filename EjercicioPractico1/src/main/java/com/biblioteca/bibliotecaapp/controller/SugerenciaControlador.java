/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.bibliotecaapp.controller;
import com.biblioteca.bibliotecaapp.domain.Sugerencia;
import com.biblioteca.bibliotecaapp.service.SugerenciaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quejas")
public class SugerenciaControlador {

    private final SugerenciaServicio sugerenciaServicio;

    public SugerenciaControlador(SugerenciaServicio sugerenciaServicio) {
        this.sugerenciaServicio = sugerenciaServicio;
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("sugerencia", new Sugerencia());
        return "quejas/formulario"; 
    }

    // 💾 Guardar sugerencia (opcional)
    @PostMapping("/guardar")
    public String guardarSugerencia(@ModelAttribute Sugerencia sugerencia) {
        sugerenciaServicio.guardar(sugerencia);
        return "redirect:/quejas/listado"; 
    }

    // 📃 Listar sugerencias (si decides mostrarlas)
    @GetMapping("/listado")
    public String listarSugerencias(Model modelo) {
        modelo.addAttribute("sugerencias", sugerenciaServicio.listarSugerencias());
        return "quejas/listado"; 
    }
}
