package com.antonio.SistemadeAgendamentodeConsultas.service;

import com.antonio.SistemadeAgendamentodeConsultas.exception.PacienteNaoEncontadoException;
import com.antonio.SistemadeAgendamentodeConsultas.model.entidades.Paciente;
import com.antonio.SistemadeAgendamentodeConsultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(Paciente paciente) {
        if (paciente.getNome() == null || paciente.getNome().length() < 3) {
            throw new IllegalArgumentException("O nome do paciente deve ter pelo menos 3 caracteres");
        }
        return pacienteRepository.save(paciente);
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontadoException("Paciente não encontrado com id: " + id));
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente updatePaciente(Long id, Paciente updatedPaciente) {
        Paciente existingPaciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontadoException("Paciente não encontrado com id: " + id));

        if (updatedPaciente.getNome() != null && !updatedPaciente.getNome().isEmpty()) {
            existingPaciente.setNome(updatedPaciente.getNome());
        }

        if (updatedPaciente.getProntuario() != null && !updatedPaciente.getProntuario().isEmpty()) {
            existingPaciente.setProntuario(updatedPaciente.getProntuario());
        }

        if (updatedPaciente.getEndereco() != null) {
            existingPaciente.setEndereco(updatedPaciente.getEndereco());
        }

        if (updatedPaciente.getTelefone() != null && !updatedPaciente.getTelefone().isEmpty()) {
            existingPaciente.setTelefone(updatedPaciente.getTelefone());
        }

        if (updatedPaciente.getEmail() != null && !updatedPaciente.getEmail().isEmpty()) {
            existingPaciente.setEmail(updatedPaciente.getEmail());
        }

        if (updatedPaciente.getDataConsulta() != null) {
            existingPaciente.setDataConsulta(updatedPaciente.getDataConsulta());
        }
        return pacienteRepository.save(existingPaciente);
    }

    public void deletePaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontadoException("Paciente não encontrado com id: " + id));
        pacienteRepository.delete(paciente);
    }

    // Busca paciente por id, cpf ou nome
    public List<Paciente> searchPaciente(Long id, String cpf, String nome) {
        List<Paciente> dadosSaidaPaciente = List.of();
        if (id != null) {
            Paciente paciente = pacienteRepository.findById(id).orElse(null);
            if (paciente != null) {
                dadosSaidaPaciente = List.of(paciente);
            }
        } else if (cpf != null && !cpf.isBlank()) {
            dadosSaidaPaciente = pacienteRepository.findByCpfContainingIgnoreCase(cpf);
        } else if (nome != null && !nome.isBlank()) {
            dadosSaidaPaciente = pacienteRepository.findByNomeContainingIgnoreCase(nome);
        } else {
            dadosSaidaPaciente = pacienteRepository.findAll(); // Retorna todos os pacientes se não houver um filtro
        }

        if (dadosSaidaPaciente.isEmpty()) {
            throw new PacienteNaoEncontadoException("Nenhum paciente encontrado com os critérios fornecidos.");
        }
        return dadosSaidaPaciente;
    }

}
