package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "funcionario", schema = "agendamento")
public class Funcionario extends Pessoa{

    @NotBlank(message = "Função é obrigatória")
    @Column(name = "funcao", nullable = false, unique = false)
    private String funcao;

    @NotBlank(message = "Salário é obrigatória")
    @Column(name = "salario", nullable = false, unique = false)
    private double salario;

    @FutureOrPresent(message = "A data da demissão deve ser hoje ou futura")
    @NotNull(message = "Data da demissão é obrigatório")
    @Column(name = "data_demissao", nullable = true)
    private LocalDate dataDemissao;

    @FutureOrPresent(message = "A data da contrato deve ser hoje ou futura")
    @NotNull(message = "Data da contrato é obrigatório")
    @Column(name = "data_contrato", nullable = true)
    private LocalDate dataContrato;


    public Funcionario() {
        super();
    }

    public Funcionario(Long id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, String funcao, double salario, LocalDate dataDemissao, LocalDate dataContrato) {
        super(id, nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, statusCadastro);
        this.funcao = funcao;
        this.salario = salario;
        this.dataDemissao = dataDemissao;
        this.dataContrato = dataContrato;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao (LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
