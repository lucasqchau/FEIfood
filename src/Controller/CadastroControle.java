/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.ClienteDAO;
import Dao.Conexao;
import Model.Cliente;
import View.Cadastro;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author rchau
 */
public class CadastroControle {
    // Referência para a tela de cadastro (View)
    private Cadastro tela2;
    
    //Construtor do controller de cadastro.
    public CadastroControle(Cadastro tela2) {
        this.tela2 = tela2;

    }
    
    public void CadastroCliente(){
        // Monta o objeto Cliente com os dados vindos dos campos de texto da tela
        Cliente cliente = new Cliente(
            tela2.getTxt1().getText(),// Nome digitado
            tela2.getTxt2().getText(),// Usuário digitado
            tela2.getTxt3().getText());// Senha digitada
        
        // Exibe no console (para debug) os valores informados
        System.out.println("Nome: " + cliente.getNome());    
        System.out.println("Usuario: " + cliente.getUsuario());
        System.out.println("Senha: " + cliente.getSenha());
        // Cria um objeto de conexão (classe responsável por conectar ao BD)
        Conexao conexao = new Conexao();
        try{
            // Abre conexão com o banco
            Connection conn = conexao.conectar();
            // Cria o DAO de Cliente, passando a conexão
            ClienteDAO dao = new ClienteDAO(conn);
            // Chama o método cadastrar para inserir o novo cliente no banco
            dao.cadastrar(cliente);
        }catch(SQLException e){
                // Em caso de erro de banco, exibe mensagem para o usuário
                JOptionPane.showMessageDialog(tela2,
                                              e.getMessage(),
                                              "ERRO",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}