/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Postagem;
import br.com.crescer.social.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Deordines
 */
@RestController
@RequestMapping("/postagem")
public class PostagemController {
    
    @Autowired
    PostagemService service;
    
    @GetMapping
    public Iterable<Postagem> listar(@AuthenticationPrincipal User usuario) {
        return service.listar(usuario);
    }
    
    @PostMapping(consumes = "application/json")
    public Postagem criar(@AuthenticationPrincipal User usuario, @RequestBody Postagem postagem) {
        return service.criar(usuario, postagem);
    }
}
