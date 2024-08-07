package br.com.controle_financeiro_back.controller;

import br.com.controle_financeiro_back.model.TipoGasto;
import br.com.controle_financeiro_back.service.TipoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoGasto")
public class TipoGastoController {

    @Autowired
    private TipoGastoService tipoGastoService;

    @GetMapping
    public List<TipoGasto> listartiposDeGastos() {
        return tipoGastoService.listartipoGasto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoGasto> obtertipoDeGastoPorId(@PathVariable Long id) {
        Optional<TipoGasto> tipoGasto = tipoGastoService.obtertipoGastoPorId(id);
        return tipoGasto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoGasto> salvartipoDeGasto(@RequestBody TipoGasto gasto) {
        TipoGasto novoTipoGasto = tipoGastoService.salvartipoGasto(gasto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoGasto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoGasto> atualizartipoDeGasto(@PathVariable Long id, @RequestBody TipoGasto tipoGasto) {
        if (tipoGastoService.obtertipoGastoPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoGasto.setIdTipoGasto(id);
        TipoGasto tipoGastoAtualizado = tipoGastoService.salvartipoGasto(tipoGasto);
        return ResponseEntity.ok(tipoGastoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletartipoDeGasto(@PathVariable Long id) {
        if (tipoGastoService.obtertipoGastoPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoGastoService.deletartipoGasto(id);
        return ResponseEntity.noContent().build();
    }
}
