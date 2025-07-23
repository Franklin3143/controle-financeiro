package br.com.controlefinanceiroback.controller;

import br.com.controlefinanceiroback.entity.Usuario;
import br.com.controlefinanceiroback.entity.dto.TransactionResponseDTO;
import br.com.controlefinanceiroback.entity.dto.UsuarioDTO;
import br.com.controlefinanceiroback.entity.dto.UsuarioResumoDTO;
import br.com.controlefinanceiroback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResumoDTO>> listarTransacoes() {
        List<UsuarioResumoDTO> lista = usuarioService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioService.criarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}

