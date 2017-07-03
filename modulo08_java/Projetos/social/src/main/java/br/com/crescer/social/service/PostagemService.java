/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Postagem;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.PostagemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deordines
 */
@Service
public class PostagemService {
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PostagemRepositorio repositorio;
    
    public Iterable<Postagem> listar() {
        return repositorio.findAll();
    }
    
    public Postagem buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public Postagem criar(Postagem postagem) {
        Usuario u = usuarioService.buscarPorEmail(postagem.getUsuario().getEmail());
        postagem.setUsuario(u);        
        return repositorio.save(postagem);
    }
    
    public void remover(Postagem postagem) {
        repositorio.delete(postagem);
    }
}
