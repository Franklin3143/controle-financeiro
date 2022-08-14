package br.com.controlefinanceiroback.controller;

import br.com.controlefinanceiroback.model.Receita;
import br.com.controlefinanceiroback.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

    @Autowired
    ReceitaRepository receitaRepository;


    @GetMapping("/all")
    List<Receita> findALl() {
        return receitaRepository.findAll();
    }

    @PostMapping("/insert")
    Receita novaReceita(@RequestBody Receita receita) {
        return receitaRepository.save(receita);
    }

}
