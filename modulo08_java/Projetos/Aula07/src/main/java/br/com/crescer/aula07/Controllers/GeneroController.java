/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Controllers;

import br.com.crescer.aula07.Services.GeneroService;
import br.com.crescer.aula07.Entidades.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deordines.tomazi
 */
@RestController
@RequestMapping(value = "/genero")
public class GeneroController {
    
    @Autowired
    private GeneroService service;
    
    @GetMapping
    public Iterable<Genero> listar() {
        return service.listar();
    }
}
