package com.coronadoportfolio.coronado.security.Service;

import com.coronadoportfolio.coronado.security.Entity.Usuario;
import com.coronadoportfolio.coronado.security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    //este metodo chequea que un nombre de usuario existe
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    //este metodo chequea que un email existe
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }

    //este metodo guarda un usuario nuevo
    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
