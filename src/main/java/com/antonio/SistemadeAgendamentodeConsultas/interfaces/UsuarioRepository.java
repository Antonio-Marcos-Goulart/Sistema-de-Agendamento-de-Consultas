package com.antonio.SistemadeAgendamentodeConsultas.interfaces;


import com.antonio.SistemadeAgendamentodeConsultas.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // você pode criar métodos como:
    Usuario findByEmail(String email);
}
