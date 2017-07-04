/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    
    public Iterable<Usuario> listarAmigos(@AuthenticationPrincipal User user) {
        Usuario usuario = repositorio.findOneByEmail(user.getUsername());
        return usuario.getAmigos();
    }
    
    public Iterable<Usuario> listarAmigosPerfilVisitado(Long id) {
        Usuario usuario = buscarPorId(id);
        return usuario.getAmigos();
    }
    
    public Iterable<Usuario> listarAmigosPendentes(@AuthenticationPrincipal User user) {
        Usuario usuario = repositorio.findOneByEmail(user.getUsername());
        return usuario.getAmigosPendentes();
    }
    
    public Usuario criar(Usuario usuario) {

        if (buscarPorEmail(usuario.getEmail()) != null) {
            return null;
        }
        
        if (usuario.getImagemPerfil() == null) {
            usuario.setImagemPerfil("https://yle.fi/betayle/esi/a2islamilta/eroiltagalleria/images/henkilo_x.jpg");
        }
        
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return repositorio.save(usuario);
    }
    
    public Usuario buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public Usuario buscarPorEmail(String email) {
        return repositorio.findOneByEmail(email);
    }
    
    public Iterable<Usuario> buscarPorNome(String nome) {
        return repositorio.findByNomeIgnoreCase(nome);
    }
        
    public void remover(Long id) {
        repositorio.delete(id);
    }
    
    public void adicionar(@AuthenticationPrincipal User user, Usuario solicitado) {
        Usuario solicitante = buscarPorEmail(user.getUsername());
        solicitado = buscarPorEmail(solicitado.getEmail());
        solicitado.getAmigosPendentes().add(solicitante);
        repositorio.save(solicitado);
    }
    
    public void aceitar(@AuthenticationPrincipal User user, Usuario solicitante) {
        Usuario solicitado = buscarPorEmail(user.getUsername());
        solicitante = buscarPorEmail(solicitante.getEmail());
        solicitado.getAmigos().add(solicitante);
        solicitante.getAmigos().add(solicitado);
        solicitado.getAmigosPendentes().remove(solicitante);
        repositorio.save(solicitado);
        repositorio.save(solicitante);
    }
    
    public void recusar(@AuthenticationPrincipal User user, Usuario solicitante) {
        Usuario solicitado = buscarPorEmail(user.getUsername());
        solicitante = buscarPorEmail(solicitante.getEmail());
        solicitado.getAmigosPendentes().remove(solicitante);
        repositorio.save(solicitado);
    }
}
