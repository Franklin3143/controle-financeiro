package br.com.controlefinanceiroback.controller;

import br.com.controlefinanceiroback.entity.Categoria;
import br.com.controlefinanceiroback.entity.dto.CategoriaDTO;
import br.com.controlefinanceiroback.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody CategoriaDTO dto) {
        Categoria categoria = categoriaService.criarCategoria(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }
}

