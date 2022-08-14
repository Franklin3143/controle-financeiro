package br.com.controlefinanceiroback.repository;

import br.com.controlefinanceiroback.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository  extends JpaRepository<Receita, Long> {
}
