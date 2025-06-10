package br.com.controlefinanceiroback.service;

import br.com.controlefinanceiroback.entity.Categoria;
import br.com.controlefinanceiroback.entity.dto.CategoriaDTO;
import br.com.controlefinanceiroback.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());

        return categoriaRepository.save(categoria);
    }
}

