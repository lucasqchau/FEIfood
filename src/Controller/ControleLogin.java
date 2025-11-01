/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author uniflchau
 */
public class ControleLogin {
    private Login tela1;
    
    public ControleLogin(Login tela1) {
        this.tela1 = tela1;

    }
    
    public void loginAluno(){
        Cliente cliente = new Cliente(null,
                                tela1.getTxt1().getText(),
                                tela1.getTxt2().getText());
                    
        System.out.println("Usuario: " + cliente.getUsuario());
            
        System.out.println("Senha: " + cliente.getSenha());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            ClienteDAO dao = new ClienteDAO(conn);
            ResultSet res = dao.consultar(cliente);
            if(res.next()){
                JOptionPane.showMessageDialog(tela1,
                                              "Login efetuado com sucesso",
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                Pedido tela2 = new Pedido();
                tela2.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(tela1,
                                          "Login não efetuado",
                                          "ERRO",
                                          JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
                JOptionPane.showMessageDialog(tela1,
                                              e.getMessage(),
                                              "ERRO",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}