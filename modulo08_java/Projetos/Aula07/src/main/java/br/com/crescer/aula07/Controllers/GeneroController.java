/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Controllers;

import br.com.crescer.aula07.Services.GeneroService;
import br.com.crescer.aula07.Entidades.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deordines.tomazi
 */
@RestController
public class GeneroController {
    
    @Autowired
    private GeneroService service;
    
    @GetMapping("/genero")
    public Iterable<Genero> listar() {
        return service.listar();
    }
    
    @PostMapping("/genero")
    public void criar (@RequestBody Genero genero) {
        service.criar(genero);
    }
    
    @GetMapping("/genero/{id}")
    public Genero getById(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    
    @DeleteMapping("/genero/{id}")
    public void remove(@PathVariable Long id) {
        service.remover(id);
    }
}
