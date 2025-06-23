package com.martins.estoque_api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoCreateDTO {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;
    private Long categoriaId;
}
