package br.com.controlefinanceiroback.controller;

import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.entity.dto.TransactionDTO;
import br.com.controlefinanceiroback.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransactionController {

    @Autowired
    private TransactionService transacaoService;

    @Operation(summary = "Criar uma nova transação", description = "Adiciona uma nova despesa ou receita ao sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })

    @PostMapping
    public ResponseEntity<Transaction> criarTransacao(@RequestBody TransactionDTO dto) {
        Transaction transacao = transacaoService.criarTransacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
    }


    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Transaction>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<Transaction> transacoes = transacaoService.listarTransacoesPorUsuario(usuarioId);
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<Transaction>> listarPorPeriodo(@RequestParam int mes, @RequestParam int ano) {
        List<Transaction> transacoes = transacaoService.listarTransacoesPorPeriodo(mes, ano);
        return ResponseEntity.ok(transacoes);
    }
}

