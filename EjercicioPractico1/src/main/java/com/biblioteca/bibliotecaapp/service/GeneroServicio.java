package com.biblioteca.bibliotecaapp.service;

import com.biblioteca.bibliotecaapp.domain.GeneroLiterario;
import com.biblioteca.bibliotecaapp.repository.GeneroRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeneroServicio {

    private final GeneroRepositorio generoRepositorio;

    public GeneroServicio(GeneroRepositorio generoRepositorio) {
        this.generoRepositorio = generoRepositorio;
    }

    public List<GeneroLiterario> listarGeneros() {
        return generoRepositorio.findAll();
    }
}

