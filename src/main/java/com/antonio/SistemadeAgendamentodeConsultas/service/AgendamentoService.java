package com.antonio.SistemadeAgendamentodeConsultas.service;

import com.antonio.SistemadeAgendamentodeConsultas.model.entidades.Agendamento;
import com.antonio.SistemadeAgendamentodeConsultas.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private EmailService emailService;
    public Agendamento agendar(Agendamento agendamento){ // Recebe os dados do meu agendamento, vindos do AgendamentoController
        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento); // Salva o agendamento no banco

        // Envia o email para confirmar o agendamento com o paciente
        String email = agendamentoSalvo.getPaciente().getEmail();
        String assunto = "Confirmação de Agendamento";
        String conteudo = "Olá " + agendamentoSalvo.getPaciente().getNome() + "\n" +
                "Seu agendamento foi confirmado para o dia " + agendamento.getDataAgendamento() +
                "Detalhes do agendamento:\n" +
                "Médico: " + agendamentoSalvo.getMedico().getNome() + "\n" +
                "Local: " + agendamentoSalvo.getLocalConsulta();
        emailService.enviarEmail(email, assunto, conteudo);

        return agendamentoSalvo;
    }

}
