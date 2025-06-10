package br.com.controlefinanceiroback.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Nome da categoria (Ex: Alimentação, Transporte, Salário)
    private String descricao; // Breve explicação da categoria

    @OneToMany(mappedBy = "categoria")
    private List<Transaction> transacoes; // Lista de transações vinculadas à categoria

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Transaction> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transaction> transacoes) {
        this.transacoes = transacoes;
    }
}

