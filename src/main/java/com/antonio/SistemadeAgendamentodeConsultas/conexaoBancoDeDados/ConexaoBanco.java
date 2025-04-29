package com.antonio.SistemadeAgendamentodeConsultas.conexaoBancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistemaDeAgendamento";
    private static final String USUARIO = "postgres"; // ou seu usuário
    private static final String SENHA = "2005";

    public static Connection conectar() throws SQLException {
        Connection connection =  DriverManager.getConnection(URL, USUARIO, SENHA);
        System.out.println("Conexão realizada com sucesso!");
        return connection;
    }
}
