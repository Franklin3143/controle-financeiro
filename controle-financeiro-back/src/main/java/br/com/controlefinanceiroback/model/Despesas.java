package br.com.controlefinanceiroback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDespesas;
    private String categoria;
    private Boolean situacao;
    private Date dataVencimentoDespesa;
    private Date dataOrigemDespesa;
    private BigDecimal valorDespesa;

    public Long getIdDespesas() {
        return idDespesas;
    }

    public void setIdDespesas(Long idDespesas) {
        this.idDespesas = idDespesas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public Date getDataVencimentoDespesa() {
        return dataVencimentoDespesa;
    }

    public void setDataVencimentoDespesa(Date dataVencimentoDespesa) {
        this.dataVencimentoDespesa = dataVencimentoDespesa;
    }

    public Date getDataOrigemDespesa() {
        return dataOrigemDespesa;
    }

    public void setDataOrigemDespesa(Date dataOrigemDespesa) {
        this.dataOrigemDespesa = dataOrigemDespesa;
    }

    public BigDecimal getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(BigDecimal valorDespesa) {
        this.valorDespesa = valorDespesa;
    }
}
