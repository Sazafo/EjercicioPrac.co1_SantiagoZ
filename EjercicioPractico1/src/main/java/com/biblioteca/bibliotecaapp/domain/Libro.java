/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.biblioteca.bibliotecaapp.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_libro;

    @Column(nullable = false, length = 255)
    private String titulo_libro;

    @Column(nullable = false, length = 200)
    private String autor_libro;

    @Column(length = 20)
    private String codigo_isbn;

    @Column(columnDefinition = "TEXT")
    private String resumen;

    @Temporal(TemporalType.DATE)
    private Date fecha_lanzamiento;

    private boolean disponible = true;

    @Column(precision = 10, scale = 2)
    private Double costo_aprox;

    // Relación con el género literario
    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private GeneroLiterario genero;

    @Column(nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp creado_en;

    @Column(nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private java.sql.Timestamp actualizado_en;
}

