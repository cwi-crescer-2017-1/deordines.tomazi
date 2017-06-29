/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Controllers;

import br.com.crescer.aula07.Entidades.Locacao;
import br.com.crescer.aula07.Services.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Deordines
 */
@RestController
public class LocacaoController {
    
    @Autowired
    private LocacaoService service;
    
    @GetMapping("/locacao")
    public Iterable<Locacao> listar() {
        return service.listar();
    }
    
    @PostMapping("/locacao")
    public void criar (@RequestBody Locacao locacao) {
        service.criar(locacao);
    }
    
    @GetMapping("/locacao/{id}")
    public Locacao getById(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    
    @DeleteMapping("/locacao/{id}")
    public void remove(@PathVariable Long id) {
        service.remover(id);
    }
}