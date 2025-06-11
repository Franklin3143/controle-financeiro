package br.com.controlefinanceiroback.repository;

import br.com.controlefinanceiroback.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuário por email (útil para autenticação)
    Optional<Usuario> findByEmail(String email);
}

