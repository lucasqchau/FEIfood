package Dao;

import Model.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * DAO responsável por acessar e manipular os dados da tabela tb_clientes.
 * Permite consultar (login) e cadastrar novos clientes no banco de dados.
 * 
 * Utiliza uma conexão fornecida externamente via injeção de dependência.
 * 
 * author uniflchau
 */
public class ClienteDAO {

    /** Conexão ativa com o banco de dados. */
    private Connection conexao;

    /**
     * Construtor do ClienteDAO.
     *
     * @param conexao conexão já aberta que será utilizada para executar
     *                comandos SQL.
     */
    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Consulta se existe um cliente com o usuário e senha informados.
     *
     * @param cliente objeto Cliente contendo usuário e senha digitados
     * @return ResultSet contendo o resultado da consulta (pode estar vazio)
     * @throws SQLException caso ocorra erro ao executar o comando SQL
     */
    public ResultSet consultar(Cliente cliente) throws SQLException {

        String sql =
            "SELECT * FROM tb_clientes WHERE user_cliente = ? AND senha_cliente = ?";

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1, cliente.getUsuario());
        statement.setString(2, cliente.getSenha());

        statement.execute();
        return statement.getResultSet();
    }

    /**
     * Cadastra um novo cliente no banco de dados.
     *
     * @param cliente objeto Cliente contendo nome, usuário e senha a serem gravados
     * @throws SQLException caso ocorra erro ao executar o comando SQL
     */
    public void cadastrar(Cliente cliente) throws SQLException {
        
        String sql =
            "INSERT INTO tb_clientes (user_cliente, nome_cliente, senha_cliente) "
          + "VALUES (?, ?, ?)";

        PreparedStatement statement = conexao.prepareStatement(sql);

        // Correção dos parâmetros:
        statement.setString(1, cliente.getUsuario()); // user_cliente
        statement.setString(2, cliente.getNome());    // nome_cliente
        statement.setString(3, cliente.getSenha());   // senha_cliente

        statement.executeUpdate();
        statement.close();
    }
}
