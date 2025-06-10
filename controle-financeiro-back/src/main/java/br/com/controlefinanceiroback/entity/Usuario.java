package br.com.controlefinanceiroback.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Nome do usuário
    private String email; // Email único para login
    private String senha; // Senha armazenada com hash para segurança

    @OneToMany(mappedBy = "usuario")
    private List<Transaction> transacoes; // Lista de transações vinculadas ao usuário

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Transaction> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transaction> transacoes) {
        this.transacoes = transacoes;
    }
}

