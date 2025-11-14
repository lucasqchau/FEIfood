/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author uniflchau
 */
public class ClienteDAO {
    // Conexão com o banco de dados, recebida de fora (injeção de dependência)
    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    /**
     * Consulta se os dados digitados (usuário e senha) estão corretos,
     * baseado nas informações armazenadas no banco de dados.
     */
    public ResultSet consultar(Cliente cliente) throws SQLException{
        // Comando SQL com parâmetros (placeholders '?')
        String sql = 
       "select * from tb_clientes where user_cliente = ? and senha_cliente = ?";
        // Prepara o comando SQL para execução
        PreparedStatement statement = conexao.prepareStatement(sql);
        // Substitui o primeiro '?' pelo usuário informado
        statement.setString(1, cliente.getUsuario());
        // Substitui o segundo '?' pela senha informada
        statement.setString(2, cliente.getSenha());
        // Executa a consulta no banco
        statement.execute();
        // Recupera o resultado da consulta
        ResultSet resultado = statement.getResultSet();
        // Retorna o ResultSet para ser tratado pelo Controller
        return resultado;
    }
    
    //Cadastra um novo cliente no BD
    public void cadastrar(Cliente cliente) throws SQLException {
        // Comando SQL de inserção de um novo cliente
        String sql = 
        "INSERT INTO tb_clientes (user_cliente, nome_cliente, senha_cliente) "
                + "VALUES (?,?,?)";
        
        // Prepara o comando SQL para execução
        PreparedStatement statement = conexao.prepareStatement(sql);
        // Define os valores para cada placeholder do SQL, na ordem:
        // 1º parâmetro -> user_cliente
        // 2º parâmetro -> nome_cliente
        // 3º parâmetro -> senha_cliente
        statement.setString(1, cliente.getNome());// valor para user_cliente
        statement.setString(2, cliente.getUsuario());// valor para nome_cliente
        statement.setString(3, cliente.getSenha());// valor para senha_cliente 
        // Executa o comando de INSERT (não é consulta, então é executeUpdate)
        statement.executeUpdate();
        // Executa o comando de INSERT (não é consulta, então é executeUpdate)
        statement.close();
    }
}