package com.antonio.SistemadeAgendamentodeConsultas.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "medico", schema = "agendamento")
public class Medico extends Funcionario{

    @NotBlank(message = "CRM é obrigatório")
    @Pattern(
            regexp = "^\\d{6}-[A-Z]{2}$",
            message =  "CRM deve estar no formato 123456-SP (6 números, hífen e UF em letras maiúsculas)"
    )
    @Column(name = "crm", nullable = false, unique = true)
    private String crm;


    public Medico() {
        super();
    }

    public Medico(Long id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, String funcao, double salario, LocalDate dataDemissao, LocalDate dataContrato, String crm) {
        super(id, nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, statusCadastro, funcao, salario, dataDemissao, dataContrato);
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        if (!crm.matches("^\\d{6}-[A-Z]{2}$")) {
            throw new IllegalArgumentException("CRM inválido: deve estar no formato 123456-SP");
        }
        this.crm = crm;
    }

}
