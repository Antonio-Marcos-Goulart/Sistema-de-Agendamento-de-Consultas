package com.antonio.SistemadeAgendamentodeConsultas.controller;

import com.antonio.SistemadeAgendamentodeConsultas.model.Agendamento;
import com.antonio.SistemadeAgendamentodeConsultas.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Agendar uma consulta
    @PostMapping // Não é necessário especificar o caminho, pois o caminho já está definido na classe com @RequestMapping("/agendamentos")
    public ResponseEntity<String> agendar(@RequestBody @Valid Agendamento agendamento) {
        try {
            Agendamento novoAgendamento = agendamentoService.agendar(agendamento);
            return ResponseEntity.ok("Agendamento criado"); // Retorna 200 e a mensagem de Agendamento criado
        } catch (Exception e) {
            throw new RuntimeException("Erro inesperado ao agendar a consulta\n" + e.getMessage());
        }
    }
}
