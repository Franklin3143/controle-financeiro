package br.com.controlefinanceiroback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceita;
    private String ogiremReceita;
    private Date dataReceita;
    private BigDecimal valorReceita;

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public String getOgiremReceita() {
        return ogiremReceita;
    }

    public void setOgiremReceita(String ogiremReceita) {
        this.ogiremReceita = ogiremReceita;
    }

    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    public BigDecimal getValorReceita() {
        return valorReceita;
    }

    public void setValorReceita(BigDecimal valorReceita) {
        this.valorReceita = valorReceita;
    }
}
