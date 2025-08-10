package com.antonio.SistemadeAgendamentodeConsultas.controller;

import com.antonio.SistemadeAgendamentodeConsultas.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String>enviar( // Recebe os dados do email
            @RequestParam String para,
            @RequestParam String assunto,
            @RequestParam String conteudo) {
        try {
            emailService.enviarEmail(para, assunto, conteudo);
            return ResponseEntity.ok("E-mail enviado"); // Retorna 200 e a mensagem de Email enviado
        } catch (Exception e ) {
            throw new RuntimeException("Erro inesperado ao enviar o e-mail\n" + e.getMessage());
        }
    }
}
