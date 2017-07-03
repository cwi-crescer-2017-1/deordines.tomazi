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
    
    public Iterable<Curtida> listar() {
        return repositorio.findAll();
    }
    
    public Curtida buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public Curtida criar(@AuthenticationPrincipal User usuario, Long idPostagem) {
        Curtida curtida = new Curtida();
        Postagem p = postagemService.buscarPorId(idPostagem);
        Usuario u = usuarioService.buscarPorEmail(usuario.getUsername());
        curtida.setUsuario(u);
        p.getCurtidas().add(curtida);
        return repositorio.save(curtida);
    }
    
    public void remover(@AuthenticationPrincipal User usuario, Long idCurtida, Long idPostagem) {
        if (buscarPorId(idCurtida).getUsuario().getEmail().equals(usuario.getUsername())) {
            Curtida c = buscarPorId(idCurtida);
            Postagem p = postagemService.buscarPorId(idPostagem);
            p.getCurtidas().remove(c);
            repositorio.delete(idCurtida);
        }
    }
}
