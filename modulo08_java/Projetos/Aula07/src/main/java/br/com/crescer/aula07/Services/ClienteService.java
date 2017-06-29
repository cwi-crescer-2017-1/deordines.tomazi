/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Services;

import br.com.crescer.aula07.Entidades.Cliente;
import br.com.crescer.aula07.Repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deordines
 */
@Service
public class ClienteService {
    
    @Autowired
    ClienteRepositorio repositorio;
    
    public Iterable<Cliente> listar () {
        return repositorio.findAll();
    }
    
    public Cliente criar(Cliente cliente) {
        return repositorio.save(cliente);
    }
    
    public Cliente buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public void remover(Long id) {
        repositorio.delete(id);
    }
}
