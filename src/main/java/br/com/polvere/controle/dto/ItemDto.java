package br.com.polvere.controle.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ItemDto {
    @NotNull(message = "Nome não pode ser vazio")
    @NotBlank
    private String nome;

    @Min(message = "quantidade precisa maior que zero", value = 1L)
    private Integer quantidade;

    @DecimalMin(message = "precoUnitario precisa ser maior que zero", value = "0.01")
    private Double precoUnitario;
}
