package br.com.crescer.social.security;

import br.com.crescer.social.entidades.Usuario;
import br.com.crescer.social.services.UsuarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {
    
    @Autowired
    UsuarioService service;
    Usuario usuario = new Usuario();
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        usuario = service.buscarPorEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Não encontrado um usuário com esse e-mail %s", email));
        }

        return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<GrantedAuthority>());
    }
}
