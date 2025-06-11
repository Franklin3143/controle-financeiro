package br.com.controlefinanceiroback.entity.dto;

import java.math.BigDecimal;
import java.util.Map;

public class EvolucaoFinanceiraDTO {
    private Map<Integer, BigDecimal> saldoPorMes;

    public Map<Integer, BigDecimal> getSaldoPorMes() {
        return saldoPorMes;
    }

    public void setSaldoPorMes(Map<Integer, BigDecimal> saldoPorMes) {
        this.saldoPorMes = saldoPorMes;
    }

    // Ex: {1: 500, 2: 700, 3: 450}


    public EvolucaoFinanceiraDTO(Map<Integer, BigDecimal> saldoPorMes) {
        this.saldoPorMes = saldoPorMes;
    }
}

