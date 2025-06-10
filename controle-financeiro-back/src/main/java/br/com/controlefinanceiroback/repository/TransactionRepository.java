package br.com.controlefinanceiroback.repository;

import br.com.controlefinanceiroback.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {



    // Buscar transações por usuário
    List<Transaction> findByUsuarioId(Long usuarioId);

    // Buscar transações por mês e ano
    @Query("SELECT t FROM Transaction t WHERE MONTH(t.data) = :mes AND YEAR(t.data) = :ano")
    List<Transaction> findByMesEAno(@Param("mes") int mes, @Param("ano") int ano);
}

