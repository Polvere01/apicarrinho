package br.com.polvere.nucleo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Item {

    private String nome;
    private Integer quantidade;
    private Double precoUnitario;
}
