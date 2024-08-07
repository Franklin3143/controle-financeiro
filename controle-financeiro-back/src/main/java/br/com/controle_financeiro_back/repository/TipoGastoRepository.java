package br.com.controle_financeiro_back.repository;

import br.com.controle_financeiro_back.model.TipoGasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoGastoRepository extends JpaRepository<TipoGasto, Long> {
}
