package br.com.controlefinanceiroback.service;

import br.com.controlefinanceiroback.entity.Categoria;
import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.entity.Usuario;
import br.com.controlefinanceiroback.entity.dto.TransactionDTO;
import br.com.controlefinanceiroback.repository.CategoriaRepository;
import br.com.controlefinanceiroback.repository.TransactionRepository;
import br.com.controlefinanceiroback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Transaction criarTransacao(TransactionDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Transaction transacao = new Transaction();
        transacao.setDescricao(dto.getDescricao());
        transacao.setValor(dto.getValor());
        transacao.setData(dto.getData());
        transacao.setTipo(dto.getTipo());
        transacao.setCategoria(categoria);
        transacao.setUsuario(usuario);

        return transactionRepository.save(transacao);
    }


    public List<Transaction> listarTransacoesPorUsuario(Long usuarioId) {
        return transactionRepository.findByUsuarioId(usuarioId);
    }

    public List<Transaction> listarTransacoesPorPeriodo(int mes, int ano) {
        return transactionRepository.findByMesEAno(mes, ano);
    }
}

