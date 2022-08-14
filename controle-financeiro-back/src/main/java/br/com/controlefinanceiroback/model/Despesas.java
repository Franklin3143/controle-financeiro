package br.com.controlefinanceiroback.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Despesas {

    @Id
    private Long idDespesas;
    private String origemDespesa;
    private Date dataDespesa;
    private BigDecimal valorDespesa;

    public Long getIdDespesas() {
        return idDespesas;
    }

    public void setIdDespesas(Long idDespesas) {
        this.idDespesas = idDespesas;
    }

    public String getOrigemDespesa() {
        return origemDespesa;
    }

    public void setOrigemDespesa(String origemDespesa) {
        this.origemDespesa = origemDespesa;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public BigDecimal getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(BigDecimal valorDespesa) {
        this.valorDespesa = valorDespesa;
    }
}
