package br.com.controlefinanceiroback.controller;

import br.com.controlefinanceiroback.model.Despesas;
import br.com.controlefinanceiroback.model.Receita;
import br.com.controlefinanceiroback.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    DespesaRepository despesaRepository;


    @GetMapping("/all")
    List<Despesas> findALl() {
        return despesaRepository.findAll();
    }

    @PostMapping("/insert")
    Despesas novaDespesa(@RequestBody Despesas despesas) {
        return despesaRepository.save(despesas);
    }
}
