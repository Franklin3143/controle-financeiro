package br.com.controle_financeiro_back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo-gastos")
@Getter
@Setter
public class TipoGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoGasto;
    private String descricaoTipoGasto;
}
