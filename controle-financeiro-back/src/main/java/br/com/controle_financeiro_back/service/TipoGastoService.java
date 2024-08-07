package br.com.controle_financeiro_back.service;

import br.com.controle_financeiro_back.model.TipoGasto;
import br.com.controle_financeiro_back.repository.TipoGastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoGastoService {

    @Autowired
    private TipoGastoRepository tipoGastoRepository;


    public List<TipoGasto> listartipoGasto() {
        return tipoGastoRepository.findAll();
    }

    public Optional<TipoGasto> obtertipoGastoPorId(Long id) {
        return tipoGastoRepository.findById(id);
    }

    public TipoGasto salvartipoGasto(TipoGasto tipoGasto) {
        return tipoGastoRepository.save(tipoGasto);
    }

    public void deletartipoGasto(Long id) {
        tipoGastoRepository.deleteById(id);
    }
}
