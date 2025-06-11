package br.com.controlefinanceiroback.service;

import br.com.controlefinanceiroback.entity.Categoria;
import br.com.controlefinanceiroback.entity.TipoTransacao;
import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.entity.Usuario;
import br.com.controlefinanceiroback.entity.dto.*;
import br.com.controlefinanceiroback.repository.CategoriaRepository;
import br.com.controlefinanceiroback.repository.TransactionRepository;
import br.com.controlefinanceiroback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<TransactionResponseDTO> listarTodas() {
        List<Transaction> transacoes = transactionRepository.findAll();

        return transacoes.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ResumoMensalDTO obterResumoMensal(int mes, int ano) {
        BigDecimal receitas = transactionRepository.somarPorTipoPeriodo(TipoTransacao.RECEITA, mes, ano);
        BigDecimal despesas = transactionRepository.somarPorTipoPeriodo(TipoTransacao.DESPESA, mes, ano);
        BigDecimal saldo = receitas.subtract(despesas);

        return new ResumoMensalDTO(receitas, despesas, saldo);
    }

    public EvolucaoFinanceiraDTO obterEvolucaoFinanceira(int ano) {
        Map<Integer, BigDecimal> saldoPorMes = new HashMap<>();

        for (int mes = 1; mes <= 12; mes++) {
            BigDecimal receitas = transactionRepository.somarPorTipoPeriodo(TipoTransacao.RECEITA, mes, ano);
            BigDecimal despesas = transactionRepository.somarPorTipoPeriodo(TipoTransacao.DESPESA, mes, ano);

            // Garantir que não sejam nulos
            receitas = (receitas != null) ? receitas : BigDecimal.ZERO;
            despesas = (despesas != null) ? despesas : BigDecimal.ZERO;

            saldoPorMes.put(mes, receitas.subtract(despesas));
        }

        return new EvolucaoFinanceiraDTO(saldoPorMes);
    }


    public List<GastosPorCategoriaDTO> obterGastosPorCategoria(int mes, int ano) {
        return transactionRepository.somarGastosPorCategoria(mes, ano);
    }




    public TransactionResponseDTO toDTO(Transaction t) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setId(t.getId());
        dto.setDescricao(t.getDescricao());
        dto.setValor(t.getValor());
        dto.setData(t.getData());
        dto.setTipo(t.getTipo());

        CategoriaResumoDTO categoriaDTO = new CategoriaResumoDTO();
        categoriaDTO.setId(t.getCategoria().getId());
        categoriaDTO.setNome(t.getCategoria().getNome());
        categoriaDTO.setDescricao(t.getCategoria().getDescricao());
        dto.setCategoria(categoriaDTO);

        UsuarioResumoDTO usuarioDTO = new UsuarioResumoDTO();
        usuarioDTO.setId(t.getUsuario().getId());
        usuarioDTO.setNome(t.getUsuario().getNome());
        usuarioDTO.setEmail(t.getUsuario().getEmail());
        dto.setUsuario(usuarioDTO);

        return dto;
    }

    public Transaction buscarTransacaoPorId(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public Transaction atualizar(Long id, TransactionDTO dto) {
        Transaction transacao = buscarTransacaoPorId(id);

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        transacao.atualizarComDTO(dto, categoria, usuario);
        return transactionRepository.save(transacao);
    }


    public void deletar(Long id) {
        Transaction transacao = buscarTransacaoPorId(id);
        transactionRepository.delete(transacao);
    }

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


    public List<TransactionResponseDTO> listarTransacoesPorUsuario(Long usuarioId) {
        List<Transaction> transacoes = transactionRepository.findByUsuarioId(usuarioId);
        return transacoes.stream().map(this::toDTO).collect(Collectors.toList());
    }


    public List<TransactionResponseDTO> listarTransacoesPorPeriodo(int mes, int ano) {
        List<Transaction> transacoes = transactionRepository.findByMesEAno(mes, ano);
        return transacoes.stream().map(this::toDTO).collect(Collectors.toList());
    }

}

