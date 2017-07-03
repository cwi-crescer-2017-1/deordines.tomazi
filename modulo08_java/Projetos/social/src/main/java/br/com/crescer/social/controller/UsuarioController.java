/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.service.UsuarioService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deordines.tomazi
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User usuario = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", usuario);
        return hashMap;
    }
    
    @GetMapping(value = "/buscarPorEmail")
    public Usuario buscarPorEmail(@AuthenticationPrincipal User usuario) {
        return service.buscarPorEmail(usuario.getUsername());
    }
    
    @GetMapping(value = "/amigos")
    public Iterable<Usuario> listarAmigos(@AuthenticationPrincipal User usuario) {
        return service.listarAmigos(usuario);
    }
    
    @GetMapping(value = "/amigosPendentes")
    public Iterable<Usuario> listarAmigosPendentes(@AuthenticationPrincipal User usuario) {
        return service.listarAmigosPendentes(usuario);
    }
                
    @PostMapping(consumes = "application/json")
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.criar(usuario);
    }
    
    @PostMapping(value = "/adicionar")
    public void adicionar(@AuthenticationPrincipal User usuario, @RequestBody Usuario solicitado) {
        service.adicionar(usuario, solicitado);
    }
    
    @PostMapping(value = "/aceitar")
    public void aceitar(@AuthenticationPrincipal User usuario, @RequestBody Usuario solicitante) {
        service.aceitar(usuario, solicitante);
    }
    
    @PostMapping(value = "/recusar")
    public void recusar(@AuthenticationPrincipal User usuario, @RequestBody Usuario solicitante) {
        service.recusar(usuario, solicitante);
    }
}