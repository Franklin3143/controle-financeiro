package br.com.controlefinanceiroback.repository;

import br.com.controlefinanceiroback.model.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesas, Long> {
}
