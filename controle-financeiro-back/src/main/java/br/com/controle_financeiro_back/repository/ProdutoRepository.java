package br.com.controle_financeiro_back.repository;

import br.com.controle_financeiro_back.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
