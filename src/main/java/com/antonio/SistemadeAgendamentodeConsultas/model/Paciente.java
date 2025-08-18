package com.antonio.SistemadeAgendamentodeConsultas.model;

import com.antonio.SistemadeAgendamentodeConsultas.enums.SituacaoCadastro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "paciente", schema = "agendamento")
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prontuario", unique = true)
    private String prontuario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_consulta")
    private LocalDate dataConsulta;


    public Paciente() {
        super();
    }

    public Paciente(Long id, String prontuario, LocalDate dataConsulta) {
        this.id = id;
        this.prontuario = prontuario;
        this.dataConsulta = dataConsulta;
    }

    public Paciente(String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, Endereco endereco, SituacaoCadastro situacaoCadastro, Long id, String prontuario, LocalDate dataConsulta) {
        super(nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, situacaoCadastro);
        this.id = id;
        this.prontuario = prontuario;
        this.dataConsulta = dataConsulta;
    }
}
