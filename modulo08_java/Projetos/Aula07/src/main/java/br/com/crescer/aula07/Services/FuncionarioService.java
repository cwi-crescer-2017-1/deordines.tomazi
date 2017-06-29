/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Services;

import br.com.crescer.aula07.Entidades.Funcionario;
import br.com.crescer.aula07.Repositories.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deordines
 */
@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepositorio repositorio;
    
    public Iterable<Funcionario> listar () {
        return repositorio.findAll();
    }
    
    public Funcionario criar(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }
    
    public Funcionario buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public void remover(Long id) {
        repositorio.delete(id);
    }
}
