package br.com.controlefinanceiroback.entity;

import br.com.controlefinanceiroback.entity.dto.TransactionDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao; // Breve descrição da transação
    private BigDecimal valor; // Valor da transação
    private LocalDate data; // Data da transação
    private TipoTransacao tipo; // ENUM (RECEITA ou DESPESA)


    @ManyToOne
    private Categoria categoria; // Categoria vinculada à transação

    @ManyToOne
    private Usuario usuario; // Usuário dono da transação


    private boolean pago; // Indica se a despesa foi paga ou não

    public void atualizarComDTO(TransactionDTO dto, Categoria categoria, Usuario usuario) {
        this.descricao = dto.getDescricao();
        this.valor = dto.getValor();
        this.data = dto.getData();
        this.tipo = dto.getTipo();
        this.categoria = categoria;
        this.usuario = usuario;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}

