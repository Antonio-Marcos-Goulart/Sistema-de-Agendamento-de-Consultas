package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "funcionario", schema = "agendamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa{

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

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String cpf, String telefone, String email, LocalDate dataNascimento,
                       LocalDate dataDeCadastro, String endereco, byte statusCadastro, String funcao, double salario,
                       LocalDate dataDemissao, LocalDate dataContrato) {
        super(nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, statusCadastro);
        this.funcao = funcao;
        this.salario = salario;
        this.dataDemissao = dataDemissao;
        this.dataContrato = dataContrato;
    }
}
