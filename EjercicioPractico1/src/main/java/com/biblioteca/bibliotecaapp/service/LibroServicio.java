package com.biblioteca.bibliotecaapp.service;

import com.biblioteca.bibliotecaapp.domain.Libro;
import com.biblioteca.bibliotecaapp.repository.LibroRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServicio {

    private final LibroRepositorio libroRepositorio;

    public LibroServicio(LibroRepositorio libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    public void guardar(Libro libro) {
        libroRepositorio.save(libro);
    }

    public void eliminar(Long id) {
        libroRepositorio.deleteById(id);
    }

    public Libro buscarPorId(Long id) {
        return libroRepositorio.findById(id).orElse(null);
    }
}

