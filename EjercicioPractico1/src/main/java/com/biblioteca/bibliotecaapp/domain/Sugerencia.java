/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.bibliotecaapp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sugerencia")
public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sugerencia;

    @Column(length = 150)
    private String nombre_visitante;

    @Column(length = 200)
    private String correo_contacto;

    @Column(length = 30)
    private String telefono_contacto;

    @Column(nullable = false, length = 20)
    private String tipo_comunicacion; // QUEJA, SUGERENCIA o CONSULTA

    @Column(length = 200)
    private String asunto;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

    private boolean atendido = false;

    @Column(nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp fecha_envio;
}

