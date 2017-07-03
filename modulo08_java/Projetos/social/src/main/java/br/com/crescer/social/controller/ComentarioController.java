/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Comentario;
import br.com.crescer.social.service.ComentarioService;
import br.com.crescer.social.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Deordines
 */
@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    ComentarioService service;
    
    @GetMapping
    public Iterable<Comentario> listar() {
        return service.listar();
    }
    
    @PostMapping(value = "/{idPostagem}")
    public Comentario criar(@RequestBody Comentario comentario, @AuthenticationPrincipal User usuario, @PathVariable Long idPostagem) {
        return service.criar(comentario, usuario, idPostagem);
    }
    
    @PostMapping(value = "remover/{idComentario}/{idPostagem}")
    public void remover(@AuthenticationPrincipal User usuario, @PathVariable Long idComentario, @PathVariable Long idPostagem) {
        service.remover(usuario, idComentario, idPostagem);
    }
}
