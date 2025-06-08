package com.antonio.SistemadeAgendamentodeConsultas.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

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




}
