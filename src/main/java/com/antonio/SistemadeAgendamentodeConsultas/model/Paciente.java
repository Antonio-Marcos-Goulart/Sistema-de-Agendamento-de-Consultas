package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class Paciente extends Pessoa{

    @Column(name = "prontuario")
    private String prontuario;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;


}
