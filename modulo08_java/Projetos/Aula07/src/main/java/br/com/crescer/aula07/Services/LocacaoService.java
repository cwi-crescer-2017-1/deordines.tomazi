/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Services;

import br.com.crescer.aula07.Entidades.Locacao;
import br.com.crescer.aula07.Repositories.LocacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deordines
 */
@Service
public class LocacaoService {
    
    @Autowired
    LocacaoRepositorio repositorio;
    
    public Iterable<Locacao> listar () {
        return repositorio.findAll();
    }
    
    public Locacao criar(Locacao locacao) {
        return repositorio.save(locacao);
    }
    
    public Locacao buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public void remover(Long id) {
        repositorio.delete(id);
    }
}