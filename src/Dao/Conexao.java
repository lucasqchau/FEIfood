/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 * Aqui é feita a conexão com o PostgreSQL usando JDBC.
 * Faz parte da camada DAO (Data Access Object).
 */
public class Conexao {
    // URL de conexão com o banco PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/FEIfood";
    // Usuário do banco de dados
    private static final String USER = "postgres";
    // Senha do usuário do banco de dados
    private static final String PASSWORD = "2729112a";
    
    //Realiza a Conexao com o BD
    public static Connection conectar() {
        try {
            // Tenta criar a conexão usando DriverManager
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // Mensagem de sucesso no console (útil para debug)
            System.out.println("✅ Conectado ao PostgreSQL!");
            // Retorna a conexão aberta
            return conn;
        } catch (SQLException e) {
            // Em caso de erro, exibe a mensagem no console
            System.err.println("❌ Erro ao conectar: " + e.getMessage());
            // Retorna null indicando que a conexão falhou
            return null;
        }
    }
}
