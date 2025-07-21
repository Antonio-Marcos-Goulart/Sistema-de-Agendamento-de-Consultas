package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable // Anotação para indicar que esta classe pode ser usada como um tipo embutido em outra entidade
public class Endereco {

    @NotBlank(message = "Rua não pode ser vazia")
    private String rua;

    @NotBlank(message = "Número não pode ser vazio")
    private String numero;

    @NotBlank(message = "Bairro não pode ser vazio")
    private String bairro;

    @NotBlank(message = "Cidade não pode ser vazia")
    private String cidade;

    @NotBlank(message = "Estado não pode ser vazio")
    private String estado;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
    private String cep;
}
