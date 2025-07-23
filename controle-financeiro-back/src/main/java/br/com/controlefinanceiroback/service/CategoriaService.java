package br.com.controlefinanceiroback.service;

import br.com.controlefinanceiroback.entity.Categoria;
import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.entity.dto.CategoriaDTO;
import br.com.controlefinanceiroback.entity.dto.CategoriaResumoDTO;
import br.com.controlefinanceiroback.entity.dto.TransactionResponseDTO;
import br.com.controlefinanceiroback.entity.dto.UsuarioResumoDTO;
import br.com.controlefinanceiroback.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaResumoDTO> listarTodas() {
        List<Categoria> transacoes = categoriaRepository.findAll();

        return transacoes.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Categoria criarCategoria(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());

        return categoriaRepository.save(categoria);
    }

    public CategoriaResumoDTO toDTO(Categoria c) {

        CategoriaResumoDTO categoriaDTO = new CategoriaResumoDTO();
        categoriaDTO.setId(c.getId());
        categoriaDTO.setNome(c.getNome());
        categoriaDTO.setDescricao(c.getDescricao());

        return categoriaDTO;
    }
}

