/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.services;

import br.com.crescer.social.entidades.Usuario;
import br.com.crescer.social.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deordines.tomazi
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepositorio repositorio;
    
    public Iterable<Usuario> listar() {
        return repositorio.findAll();
    }
    
    public Usuario criar(Usuario usuario) {
        return repositorio.save(usuario);
    }
    
    public Usuario buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public Usuario buscarPorEmail(String email) {
        return repositorio.findOneByEmail(email);
    }
        
    public void remover(Long id) {
        repositorio.delete(id);
    }
}
