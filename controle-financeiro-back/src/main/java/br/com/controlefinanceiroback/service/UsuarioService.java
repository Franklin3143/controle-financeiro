package br.com.controlefinanceiroback.service;

import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.entity.Usuario;
import br.com.controlefinanceiroback.entity.dto.CategoriaResumoDTO;
import br.com.controlefinanceiroback.entity.dto.TransactionResponseDTO;
import br.com.controlefinanceiroback.entity.dto.UsuarioDTO;
import br.com.controlefinanceiroback.entity.dto.UsuarioResumoDTO;
import br.com.controlefinanceiroback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResumoDTO> listarTodas() {
        List<Usuario> transacoes = usuarioRepository.findAll();

        return transacoes.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Usuario criarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Idealmente, a senha deve ser criptografada antes de salvar
//        usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));

        return usuarioRepository.save(usuario);
    }

    public UsuarioResumoDTO toDTO(Usuario u) {


        UsuarioResumoDTO usuarioDTO = new UsuarioResumoDTO();
        usuarioDTO.setId(u.getId());
        usuarioDTO.setNome(u.getNome());
        usuarioDTO.setEmail(u.getEmail());

        return usuarioDTO;
    }
}

