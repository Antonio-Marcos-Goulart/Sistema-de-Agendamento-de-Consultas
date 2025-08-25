package com.antonio.SistemadeAgendamentodeConsultas.model;

import com.antonio.SistemadeAgendamentodeConsultas.enums.SituacaoCadastro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "funcionario", schema = "agendamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Função é obrigatória")
    @Column(name = "funcao", nullable = false, unique = false)
    private String funcao;

    @Positive(message = "Salário deve ser positivo")
    @Column(name = "salario", nullable = false, unique = false)
    private double salario;

    @NotNull(message = "Data da contrato é obrigatório")
    @Column(name = "data_contrato", nullable = false)
    private LocalDate dataContrato;

    @Column(name = "data_demissao", nullable = true) // opcional na hora do cadastro
    private LocalDate dataDemissao;

}
