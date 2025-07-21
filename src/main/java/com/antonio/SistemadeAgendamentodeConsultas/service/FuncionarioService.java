package com.antonio.SistemadeAgendamentodeConsultas.service;

import com.antonio.SistemadeAgendamentodeConsultas.exception.FuncionarioNaoEncontradoException;
import com.antonio.SistemadeAgendamentodeConsultas.model.Funcionario;
import com.antonio.SistemadeAgendamentodeConsultas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario createFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().length() < 3) {
            throw new IllegalArgumentException("O nome do funcionário deve ter pelo menos 3 caracteres");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado com id: " + id));
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // Atualiza: Nome, endereço, email, telefone, função e salário
    public Funcionario updateFuncionario(Long id, Funcionario updatedFuncionario) {
        Funcionario existingFuncionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado com id: " + id));

        if (updatedFuncionario.getNome() != null && !updatedFuncionario.getNome().isEmpty()) {
            existingFuncionario.setNome(updatedFuncionario.getNome());
        }

        if (updatedFuncionario.getEndereco() != null) {
            existingFuncionario.setEndereco(updatedFuncionario.getEndereco());
        }

        if (updatedFuncionario.getEmail() != null && !updatedFuncionario.getEmail().isEmpty()) {
            existingFuncionario.setEmail(updatedFuncionario.getEmail());
        }

        if (updatedFuncionario.getTelefone() != null && !updatedFuncionario.getTelefone().isEmpty()) {
            existingFuncionario.setTelefone(updatedFuncionario.getTelefone());
        }

        if (updatedFuncionario.getFuncao() != null && !updatedFuncionario.getFuncao().isEmpty()) {
            existingFuncionario.setFuncao(updatedFuncionario.getFuncao());
        }

        if (updatedFuncionario.getSalario() > 0) {
            existingFuncionario.setSalario(updatedFuncionario.getSalario());
        }

        return funcionarioRepository.save(existingFuncionario);
    }

    public void deleteFuncionario(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new FuncionarioNaoEncontradoException("Funcionário não encontrado com o id: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    // Busca funcionarios por id, cpf ou nome
    public List<Funcionario> searchFuncionario(Long id, String cpf, String nome) {
        List<Funcionario> dadosSaidaFuncionario = List.of();
        if (id != null) {
            Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
            if (funcionario != null) {
                dadosSaidaFuncionario = List.of(funcionario);
            }
        } else if (cpf != null && !cpf.isBlank()) {
            dadosSaidaFuncionario = funcionarioRepository.findByCpfContainingIgnoreCase(cpf);
        } else if (nome != null && !nome.isBlank()) {
            dadosSaidaFuncionario = funcionarioRepository.findByNomeContainingIgnoreCase(nome);
        } else {
            dadosSaidaFuncionario = funcionarioRepository.findAll(); // Retorna todos -- se não houver filtro
        }

        if (dadosSaidaFuncionario.isEmpty()) { // Lista vazia, lança uma exceção
            throw new FuncionarioNaoEncontradoException("Nenhum funcionário encontrado com os critérios fornecidos.");
        }
        return dadosSaidaFuncionario;

    }

}