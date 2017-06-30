/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidades.Usuario;
import br.com.crescer.social.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public List<Usuario> listar() {
        return (List) service.listar();
    }
    
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        String senha = usuario.getSenha();
        String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
        usuario.setSenha(senhaCriptografada);
        return service.criar(usuario);
    }
}
