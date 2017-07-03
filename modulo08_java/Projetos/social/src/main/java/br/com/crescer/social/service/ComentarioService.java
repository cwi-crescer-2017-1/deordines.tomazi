/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Comentario;
import br.com.crescer.social.entidade.Curtida;
import br.com.crescer.social.entidade.Postagem;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.ComentarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deordines
 */
@Service
public class ComentarioService {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PostagemService postagemService;
    
    @Autowired
    ComentarioRepositorio repositorio;
    
    public Iterable<Comentario> listar() {
        return repositorio.findAll();
    }
    
    public Comentario buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public Comentario criar(Comentario comentario, @AuthenticationPrincipal User usuario, Long idPostagem) {
        Postagem p = postagemService.buscarPorId(idPostagem);
        Usuario u = usuarioService.buscarPorEmail(usuario.getUsername());
        comentario.setUsuario(u);
        p.getComentarios().add(comentario);
        return repositorio.save(comentario);
    }
    
    public void remover(@AuthenticationPrincipal User usuario, Long idComentario, Long idPostagem) {
        if (buscarPorId(idComentario).getUsuario().getEmail().equals(usuario.getUsername())) {
            Comentario c = buscarPorId(idComentario);
            Postagem p = postagemService.buscarPorId(idPostagem);
            p.getComentarios().remove(c);
            repositorio.delete(idComentario);
        }
    }
}
