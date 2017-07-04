/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Curtida;
import br.com.crescer.social.entidade.Postagem;
import br.com.crescer.social.service.CurtidaService;
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
@RequestMapping("/curtida")
public class CurtidaController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    CurtidaService service;
    
    @GetMapping
    public Iterable<Curtida> listar() {
        return service.listar();
    }
    
    @PostMapping(value = "/postagem", consumes = "application/json")
    public Curtida criar(@AuthenticationPrincipal User usuario, @RequestBody Postagem postagem) {
        return service.criar(usuario, postagem);
    }
    
//    @PostMapping(value = "remover/{idCurtida}/{idPostagem}")
//    public void remover(@AuthenticationPrincipal User usuario, @PathVariable Long idCurtida, @PathVariable Long idPostagem) {
//        service.remover(usuario, idCurtida, idPostagem);
//    }
}
