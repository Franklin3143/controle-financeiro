package br.com.controlefinanceiroback.controller;

import br.com.controlefinanceiroback.entity.Categoria;
import br.com.controlefinanceiroback.entity.dto.CategoriaDTO;
import br.com.controlefinanceiroback.entity.dto.CategoriaResumoDTO;
import br.com.controlefinanceiroback.entity.dto.TransactionResponseDTO;
import br.com.controlefinanceiroback.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResumoDTO>> listarTransacoes() {
        List<CategoriaResumoDTO> lista = categoriaService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody CategoriaDTO dto) {
        Categoria categoria = categoriaService.criarCategoria(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }
}

