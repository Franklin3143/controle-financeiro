package br.com.controlefinanceiroback.service;

import br.com.controlefinanceiroback.entity.Usuario;
import br.com.controlefinanceiroback.entity.dto.UsuarioDTO;
import br.com.controlefinanceiroback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Idealmente, a senha deve ser criptografada antes de salvar
//        usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));

        return usuarioRepository.save(usuario);
    }
}

