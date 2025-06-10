package br.com.controlefinanceiroback.repository;

import br.com.controlefinanceiroback.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Buscar categorias pelo nome
    Optional<Categoria> findByNome(String nome);
}

