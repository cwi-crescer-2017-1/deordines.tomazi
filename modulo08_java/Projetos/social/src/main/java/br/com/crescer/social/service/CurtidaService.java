/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Curtida;
import br.com.crescer.social.entidade.Postagem;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.CurtidaRepositorio;
import br.com.crescer.social.repositorio.PostagemRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deordines
 */
@Service
public class CurtidaService {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PostagemService postagemService;
    
    @Autowired
    CurtidaRepositorio repositorio;
    
    @Autowired
    PostagemRepositorio postagemRepositorio;
    
    public Iterable<Curtida> listar() {
        return repositorio.findAll();
    }
    
    public Curtida buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public Curtida criar(@AuthenticationPrincipal User usuario, Postagem postagem) {
        Usuario u = usuarioService.buscarPorEmail(usuario.getUsername());
        
        List<Curtida> curtidas = postagem.getCurtidas();
        for (Curtida c : curtidas) {
            if (c.getUsuario().getEmail().equals(u.getEmail())) {
                return remover(u, c, postagem);
            }
        }
        
        Curtida curtida = new Curtida();
        curtida.setUsuario(u);
        postagem.getCurtidas().add(curtida);
        postagemRepositorio.save(postagem);
        return repositorio.save(curtida);
    }
    
    public Curtida remover(Usuario usuario, Curtida curtida, Postagem postagem) {
        postagem.getCurtidas().remove(curtida);
        postagemRepositorio.save(postagem);
        repositorio.delete(curtida);
        return null;
    }
}
