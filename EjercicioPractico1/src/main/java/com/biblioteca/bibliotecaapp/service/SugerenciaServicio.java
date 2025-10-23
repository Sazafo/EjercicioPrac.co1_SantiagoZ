package com.biblioteca.bibliotecaapp.service;

import com.biblioteca.bibliotecaapp.domain.Sugerencia;
import com.biblioteca.bibliotecaapp.repository.SugerenciaRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SugerenciaServicio {

    private final SugerenciaRepositorio sugerenciaRepositorio;

    public SugerenciaServicio(SugerenciaRepositorio sugerenciaRepositorio) {
        this.sugerenciaRepositorio = sugerenciaRepositorio;
    }

    public List<Sugerencia> listarSugerencias() {
        return sugerenciaRepositorio.findAll();
    }

    public void guardar(Sugerencia sugerencia) {
        sugerenciaRepositorio.save(sugerencia);
    }
}
