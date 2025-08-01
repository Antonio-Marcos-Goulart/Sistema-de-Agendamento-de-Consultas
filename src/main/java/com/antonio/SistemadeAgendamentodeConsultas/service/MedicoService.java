package com.antonio.SistemadeAgendamentodeConsultas.service;

import com.antonio.SistemadeAgendamentodeConsultas.exception.FuncionarioNaoEncontradoException;
import com.antonio.SistemadeAgendamentodeConsultas.exception.MedicoNaoEncontradoExeption;
import com.antonio.SistemadeAgendamentodeConsultas.model.Funcionario;
import com.antonio.SistemadeAgendamentodeConsultas.model.Medico;
import com.antonio.SistemadeAgendamentodeConsultas.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico createMedico(Medico medico) {
        if (medico.getNome() == null || medico.getNome().length() < 3) {
            throw new IllegalArgumentException("O nome do médico deve ter pelo menos 3 caracteres");
        }
        return medicoRepository.save(medico);
    }

    public Medico getMedicoById(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNaoEncontradoExeption("Médico não encontrado com id: " + id));
    }

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    // Atualiza: Nome, endereço, email, telefone, função e salário
    public Medico updateMedico(Long id, Funcionario updatedMedico) {
        Medico existingMedico = medicoRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado com id: " + id));

        if (updatedMedico.getNome() != null && !updatedMedico.getNome().isEmpty()) {
            existingMedico.setNome(updatedMedico.getNome());
        }

        if (updatedMedico.getEndereco() != null) {
            existingMedico.setEndereco(updatedMedico.getEndereco());
        }

        if (updatedMedico.getEmail() != null && !updatedMedico.getEmail().isEmpty()) {
            existingMedico.setEmail(updatedMedico.getEmail());
        }

        if (updatedMedico.getTelefone() != null && !updatedMedico.getTelefone().isEmpty()) {
            existingMedico.setTelefone(updatedMedico.getTelefone());
        }

        if (updatedMedico.getFuncao() != null && !updatedMedico.getFuncao().isEmpty()) {
            existingMedico.setFuncao(updatedMedico.getFuncao());
        }

        if (updatedMedico.getSalario() > 0) {
            existingMedico.setSalario(updatedMedico.getSalario());
        }

        return medicoRepository.save(existingMedico);
    }

    public void deleteMedico(Long id) {
        if (! medicoRepository.existsById(id)) {
            throw new MedicoNaoEncontradoExeption("Médico não encontrado com id: " + id);
        }
        medicoRepository.deleteById(id);
    }

    public List<Medico> searchMedico(Long id, String cpf, String nome, String crm){
        List<Medico> dadosSaidaMedico = List.of();
        if (id !=null) {
            Medico medico = medicoRepository.findById(id).orElse(null);
            if (medico != null) {
                dadosSaidaMedico = List.of(medico);
            }
        } else if (cpf != null && !cpf.isBlank()) {
            dadosSaidaMedico = medicoRepository.findByCpfContainingIgnoreCase(cpf);
        } else if (nome != null && !nome.isBlank()) {
            dadosSaidaMedico = medicoRepository.findByNomeContainingIgnoreCase(nome);
        } else {
            dadosSaidaMedico = medicoRepository.findByCrmContainingIgnoreCase(crm);
        }

        if (dadosSaidaMedico.isEmpty()) {// Lista vazia, vai lançar uma exceção
            throw new MedicoNaoEncontradoExeption("Nenhum medico encontrado com os critérios fornecidos.");
        }
        return dadosSaidaMedico;
    }

    /*
    // Busca medicos por id, cpf, nome ou CRM
    @GetMapping("/search")
    public List<Medico> searchFuncionarios(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String crm){
        return medicoService.searchMedico(id, cpf, nome, crm);
    }
     */


}
