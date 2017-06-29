/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Controllers;

import br.com.crescer.aula07.Entidades.Cliente;
import br.com.crescer.aula07.Services.ClienteService;
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
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    
    @GetMapping("/cliente")
    public Iterable<Cliente> listar() {
        return service.listar();
    }
    
    @PostMapping("/cliente")
    public void criar (@RequestBody Cliente cliente) {
        service.criar(cliente);
    }
    
    @GetMapping("/cliente/{id}")
    public Cliente getById(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    
    @DeleteMapping("/cliente/{id}")
    public void remove(@PathVariable Long id) {
        service.remover(id);
    }
}
