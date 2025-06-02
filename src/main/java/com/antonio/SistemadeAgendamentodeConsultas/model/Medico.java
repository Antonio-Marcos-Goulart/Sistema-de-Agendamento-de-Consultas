package com.antonio.SistemadeAgendamentodeConsultas.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "medico", schema = "agendamento")
public class Medico extends Funcionario{

    @NotBlank(message = "CRM é obrigatório")
    @Column(name = "crm", nullable = false, unique = true)
    private String crm;




}
