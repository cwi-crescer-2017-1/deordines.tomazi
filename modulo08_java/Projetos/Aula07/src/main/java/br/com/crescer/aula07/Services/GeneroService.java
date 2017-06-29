/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Services;

import br.com.crescer.aula07.Entidades.Genero;
import br.com.crescer.aula07.Repositories.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deordines.tomazi
 */
@Service
public class GeneroService {
    
    @Autowired
    GeneroRepositorio repositorio;
    
    public Iterable<Genero> listar () {
        return repositorio.findAll();
    }
    
    public Genero criar(Genero genero) {
        return repositorio.save(genero);
    }
    
    public Genero buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public void remover(Long id) {
        repositorio.delete(id);
    }
}
