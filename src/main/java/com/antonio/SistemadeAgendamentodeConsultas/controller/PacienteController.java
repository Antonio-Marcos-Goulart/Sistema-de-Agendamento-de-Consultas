package com.antonio.SistemadeAgendamentodeConsultas.controller;

import com.antonio.SistemadeAgendamentodeConsultas.DTOs.PacienteDTO;
import com.antonio.SistemadeAgendamentodeConsultas.model.entidades.Paciente;
import com.antonio.SistemadeAgendamentodeConsultas.repository.PacienteRepository;
import com.antonio.SistemadeAgendamentodeConsultas.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    private final PacienteRepository pacienteRepository;
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService, PacienteRepository pacienteRepository) {
        this.pacienteService = pacienteService;
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping(consumes = {"application/json"}) // VERIFICAR ISSO
    public ResponseEntity<Paciente> createPaciente(@RequestBody @Valid Paciente paciente) {
        Paciente saved = pacienteService.createPaciente(paciente);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO getPacienteByIdDTO(@PathVariable Long id) {
        Paciente paciente = pacienteService.getPacienteById(id);
        return new PacienteDTO(paciente);
    }

    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente updatedPaciente) {
        return pacienteService.updatePaciente(id, updatedPaciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }

    @GetMapping("/search")
    public List<PacienteDTO> searchPacienteDTO(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String nome) {
        return pacienteService.searchPaciente(id, cpf, nome)
                .stream()
                .map(PacienteDTO::new)
                .collect(Collectors.toList());
    }

}
