package br.com.controlefinanceiroback.repository;

import br.com.controlefinanceiroback.entity.TipoTransacao;
import br.com.controlefinanceiroback.entity.Transaction;
import br.com.controlefinanceiroback.entity.dto.GastosPorCategoriaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {



    // Buscar transações por usuário
    List<Transaction> findByUsuarioId(Long usuarioId);

    // Buscar transações por mês e ano
    @Query("SELECT t FROM Transaction t WHERE MONTH(t.data) = :mes AND YEAR(t.data) = :ano")
    List<Transaction> findByMesEAno(@Param("mes") int mes, @Param("ano") int ano);

    @Query("SELECT SUM(t.valor) FROM Transaction t WHERE t.tipo = :tipo AND MONTH(t.data) = :mes AND YEAR(t.data) = :ano")
    BigDecimal somarPorTipoPeriodo(@Param("tipo") TipoTransacao tipo, @Param("mes") int mes, @Param("ano") int ano);

    @Query("SELECT new br.com.controlefinanceiroback.entity.dto.GastosPorCategoriaDTO(c.nome, SUM(t.valor)) " +
            "FROM Transaction t JOIN t.categoria c " +
            "WHERE MONTH(t.data) = :mes AND YEAR(t.data) = :ano AND t.tipo = br.com.controlefinanceiroback.entity.TipoTransacao.DESPESA " +
            "GROUP BY c.nome")
    List<GastosPorCategoriaDTO> somarGastosPorCategoria(@Param("mes") int mes, @Param("ano") int ano);
}

