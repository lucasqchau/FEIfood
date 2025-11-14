package Controller;

import Dao.ClienteDAO;
import Dao.Conexao;
import Model.Cliente;
import View.Login;
import View.Pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Controlador responsável pelo fluxo de login do usuário.
 * Recupera os dados da tela de login, consulta o banco via DAO e
 * abre a tela de Pedido caso o login seja bem-sucedido.
 * 
 * @author uniflchau
 */
public class ControleLogin {

    private Login tela1;

    /**
     * Construtor do ControleLogin.
     * 
     * @param tela1 instância da tela de Login usada para acessar os campos
     *              digitados pelo usuário.
     */
    public ControleLogin(Login tela1) {
        this.tela1 = tela1;
    }

    /**
     * Realiza o login do aluno.
     * Obtém o usuário e a senha da tela de login, consulta o banco através
     * do ClienteDAO e abre a tela de Pedido caso o login esteja correto.
     */
    public void loginAluno() {

        Cliente cliente = new Cliente(
            null,                          // ID não usado aqui
            tela1.getTxt1().getText(),     // usuário digitado
            tela1.getTxt2().getText()      // senha digitada
        );

        System.out.println("Usuario: " + cliente.getUsuario());
        System.out.println("Senha: " + cliente.getSenha());

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.conectar();
            ClienteDAO dao = new ClienteDAO(conn);

            ResultSet res = dao.consultar(cliente);

            if (res.next()) {
                JOptionPane.showMessageDialog(
                    tela1,
                    "Login efetuado com sucesso",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
                );

                Pedido tela2 = new Pedido();
                tela2.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(
                    tela1,
                    "Login não efetuado",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                tela1,
                e.getMessage(),
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
