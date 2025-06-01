package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

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

    public Funcionario() {
        super();
    }

    public Funcionario(Long id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, String funcao, double salario) {
        super(id, nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, statusCadastro);
        this.funcao = funcao;
        this.salario = salario;
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
