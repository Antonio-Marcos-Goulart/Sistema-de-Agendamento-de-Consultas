package com.antonio.SistemadeAgendamentodeConsultas.DTOs;

import com.antonio.SistemadeAgendamentodeConsultas.model.entidades.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PacienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String prontuario;

    private List<AgendamentoDTO> agendamentos;

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.dataNascimento = paciente.getDataNascimento();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();
        this.prontuario = paciente.getProntuario();

        // Converte lista de agendamentos evitando LazyInitializationException
        if (paciente.getAgendamentoList() != null) {
            this.agendamentos = paciente.getAgendamentoList()
                    .stream()
                    .map(AgendamentoDTO::new)
                    .toList();
        } else {
            this.agendamentos = new ArrayList<>();
        }
    }
}

