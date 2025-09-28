package com.antonio.SistemadeAgendamentodeConsultas.controller;

import com.antonio.SistemadeAgendamentodeConsultas.model.entidades.Paciente;
import com.antonio.SistemadeAgendamentodeConsultas.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public Paciente getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
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
    public List<Paciente> searchPaciente(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String nome) {
        return pacienteService.searchPaciente(id, cpf, nome);
    }

}
