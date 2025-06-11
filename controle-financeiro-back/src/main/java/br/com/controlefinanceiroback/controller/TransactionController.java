package br.com.controlefinanceiroback.controller;

import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.entity.dto.TransactionDTO;
import br.com.controlefinanceiroback.entity.dto.TransactionResponseDTO;
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

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> listarTransacoes() {
        List<TransactionResponseDTO> lista = transacaoService.listarTodas();
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> buscarPorId(@PathVariable Long id) {
        Transaction transacao = transacaoService.buscarTransacaoPorId(id);
        TransactionResponseDTO responseDTO = transacaoService.toDTO(transacao);
        return ResponseEntity.ok(responseDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> atualizar(@PathVariable Long id, @RequestBody TransactionDTO dto) {
        Transaction transacao = transacaoService.atualizar(id, dto);
        TransactionResponseDTO responseDTO = transacaoService.toDTO(transacao);
        return ResponseEntity.ok(responseDTO);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        transacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Criar uma nova transação", description = "Adiciona uma nova despesa ou receita ao sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> criarTransacao(@RequestBody TransactionDTO dto) {
        Transaction transacao = transacaoService.criarTransacao(dto);
        TransactionResponseDTO responseDTO = transacaoService.toDTO(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }



    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<TransactionResponseDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<TransactionResponseDTO> responseDTOs = transacaoService.listarTransacoesPorUsuario(usuarioId);
        return ResponseEntity.ok(responseDTOs);
    }


    @GetMapping("/periodo")
    public ResponseEntity<List<TransactionResponseDTO>> listarPorPeriodo(@RequestParam int mes, @RequestParam int ano) {
        List<TransactionResponseDTO> responseDTOs = transacaoService.listarTransacoesPorPeriodo(mes, ano);
        return ResponseEntity.ok(responseDTOs);
    }

}

