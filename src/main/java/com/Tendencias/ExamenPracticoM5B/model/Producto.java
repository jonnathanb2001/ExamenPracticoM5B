/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tendencias.ExamenPracticoM5B.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author jonny
 */
@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Size(max = 100, message = "La descripcion debe tener maximo 100 caracteres")// validacion de 100 caracteres
    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion")
    private String descripcion;

    //@NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "precio")
    private double precio;

    //@NotBlank(message = "La cedula no puede estar en blanco")
    @Column(name = "cantidad")
    private int cantidad;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "subtotal")
    private double subtotal;

    //@NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "descuento")
    private double descuento;

    //@NotBlank(message = "La cedula no puede estar en blanco")
    @Column(name = "iva")
    private int iva;

    //@NotBlank(message = "La cedula no puede estar en blanco")
    @Column(name = "pvp")
    private int pvp;

}
