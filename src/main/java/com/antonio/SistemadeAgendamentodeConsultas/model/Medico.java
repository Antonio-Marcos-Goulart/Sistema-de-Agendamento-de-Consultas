package com.antonio.SistemadeAgendamentodeConsultas.model;


import com.antonio.SistemadeAgendamentodeConsultas.enums.SituacaoCadastro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "medico", schema = "agendamento")
public class Medico extends Funcionario{

    @NotBlank(message = "CRM é obrigatório")
    @Pattern(
            regexp = "^\\d{6}-[A-Z]{2}$",
            message =  "CRM deve estar no formato 123456-AA (6 números, hífen e UF em letras maiúsculas)"
    )
    @Column(name = "crm", nullable = false, unique = true) // CRM obrigatório e único
    private String crm;

    public Medico() {
        super();
    }

    public Medico(String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, Endereco endereco, SituacaoCadastro situacaoCadastro, Long id, String funcao, double salario, LocalDate dataContrato, LocalDate dataDemissao, String crm) {
        super(nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, situacaoCadastro, id, funcao, salario, dataContrato, dataDemissao);
        this.crm = crm;
    }
}
