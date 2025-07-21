package com.antonio.SistemadeAgendamentodeConsultas.controller;

import com.antonio.SistemadeAgendamentodeConsultas.model.Funcionario;
import com.antonio.SistemadeAgendamentodeConsultas.model.Medico;
import com.antonio.SistemadeAgendamentodeConsultas.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public Medico createMedico(@RequestBody Medico medico){
        return medicoService.createMedico(medico);
    }

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping("/{id}")
    public Medico getMedicoById(@PathVariable Long id) {
        return medicoService.getMedicoById(id);
    }

    @PutMapping("/{id}")
    public Medico updateMedico(@PathVariable Long id, @RequestBody Medico updatedMedico) {
        return medicoService.updateMedico(id, updatedMedico);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Long id){
        medicoService.deleteMedico(id);
    }

    // Busca medicos por id, cpf, nome ou CRM
    @GetMapping("/search")
    public List<Medico> searchFuncionarios(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String crm){
        return medicoService.searchMedico(id, cpf, nome, crm);
    }
}
