/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tendencias.ExamenPracticoM5B.controller;

import com.Tendencias.ExamenPracticoM5B.model.Producto;
import com.Tendencias.ExamenPracticoM5B.service.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonny
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoService;

    @Operation(summary = "Se obtiene la lista de Productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaProductos() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Productos")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProductos(@RequestBody Producto p) {

        return new ResponseEntity<>(productoService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProductos(@PathVariable Integer id, @RequestBody Producto p) {
        Producto pro = productoService.findById(id);
        if (pro != null) {
            try {

                pro.setDescripcion(p.getDescripcion());
                pro.setPrecio(p.getPrecio());
                pro.setCantidad(p.getCantidad());
                pro.setSubtotal(p.getSubtotal());
                pro.setDescuento(p.getDescuento());
                pro.setIva(p.getIva());
                pro.setPvp(p.getPvp());

                return new ResponseEntity<>(productoService.save(pro), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminarProductos(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
