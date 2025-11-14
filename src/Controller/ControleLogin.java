/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// Importa as classes necessárias para acessar o banco e o modelo Cliente
import Dao.ClienteDAO;
import Dao.Conexao;
import Model.Cliente;
// Importa as telas (views) usadas após o login
import View.Login;
import View.Pedido;
// Importa classes de conexão SQL
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
// Importa classe para exibir mensagens na tela
import javax.swing.JOptionPane;

/**
 *
 * @author uniflchau
 */
public class ControleLogin {
    private Login tela1;
    
    // Referência para a tela de Login (View)
    // Isso permite pegar os valores digitados pelo usuário na interface gráfica
    public ControleLogin(Login tela1) {
        this.tela1 = tela1;

    }
    
    /**
     * Construtor do ControleLogin.
     * Recebe a tela de login para que o controlador consiga acessar
     * os campos de texto (usuário e senha) e mostrar mensagens na própria tela.
     */
    public void loginAluno(){
        // Pega as informações dos JTextFields da tela de login
        // O primeiro parâmetro (null) provavelmente é o ID, que ainda não é usado neste momento
        Cliente cliente = new Cliente(null,// ID do cliente (ainda não necessário aqui)
            tela1.getTxt1().getText(),// Usuário digitado no campo txt1
            tela1.getTxt2().getText());// Senha digitada no campo txt2

         // Exibe no console (útil para debug) o usuário e a senha digitados           
        System.out.println("Usuario: " + cliente.getUsuario());
        System.out.println("Senha: " + cliente.getSenha());
        
        // Cria um objeto de conexão (classe responsável por conectar ao banco)
        Conexao conexao = new Conexao(); 
        try{
            // Abre a conexão com o banco de dados
            Connection conn = conexao.conectar();
            // Cria o DAO para Cliente, passando a conexão aberta
            ClienteDAO dao = new ClienteDAO(conn);
            // Chama o método consultar, que verifica no banco se existe um cliente com
            // o usuário e senha informados. O resultado vem em um ResultSet.
            ResultSet res = dao.consultar(cliente);
            // Se o ResultSet tiver pelo menos um registro, significa que o login está correto
            if(res.next()){
                JOptionPane.showMessageDialog(tela1,
                                              "Login efetuado com sucesso",
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                // Abre a tela de Pedido após login bem-sucedido
                Pedido tela2 = new Pedido();
                tela2.setVisible(true);
            }else{
                // Caso não encontre nenhum registro, o login falhou
                JOptionPane.showMessageDialog(tela1,
                                          "Login não efetuado",
                                          "ERRO",
                                          JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
                // Caso ocorra algum erro de SQL (conexão, consulta, etc),
                // uma mensagem de erro é exibida para o usuário.
                JOptionPane.showMessageDialog(tela1,
                                              e.getMessage(), // Mostra a mensagem de erro vinda da exceção
                                              "ERRO",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}