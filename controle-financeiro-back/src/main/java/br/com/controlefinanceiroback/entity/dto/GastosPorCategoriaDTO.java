package br.com.controlefinanceiroback.entity.dto;

import java.math.BigDecimal;

public class GastosPorCategoriaDTO {
    private String categoria;
    private BigDecimal totalGasto;

    public GastosPorCategoriaDTO(String categoria, BigDecimal totalGasto) {
        this.categoria = categoria;
        this.totalGasto = totalGasto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(BigDecimal totalGasto) {
        this.totalGasto = totalGasto;
    }
}


