package br.com.polvere.controle.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ItemDto {
    private String nome;
    private Integer quantidade;
    private Double precoUnitario;
}
