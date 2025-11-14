package View;

import Controller.ControleLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Tela de login do sistema. Permite que o usuário informe nome de usuário e senha,
 * além de acessar a tela de cadastro. Os dados informados são enviados para o
 * {@link ControleLogin} realizar a validação.
 *
 * author uniflchau
 */
public class Login extends javax.swing.JFrame {

    /**
     * Construtor da tela de login.
     * Inicializa os componentes gráficos, cria o controller responsável
     * pelo login e centraliza a janela.
     */
    public Login() {
        initComponents();
        c = new ControleLogin(this);
        setLocationRelativeTo(null);
    }

    // ----------------------------------------------------------------------
    // Getters e Setters públicos — DEVEM TER JAVADOC
    // ----------------------------------------------------------------------

    /**
     * Retorna o botão "Cadastrar".
     * 
     * @return botão btcadastrar
     */
    public JButton getBtcadastrar() {
        return btcadastrar;
    }

    /**
     * Define o botão "Cadastrar".
     * 
     * @param btcadastrar novo botão
     */
    public void setBtcadastrar(JButton btcadastrar) {
        this.btcadastrar = btcadastrar;
    }

    /**
     * Retorna o botão "Entrar".
     * 
     * @return botão btentrar
     */
    public JButton getBtentrar() {
        return btentrar;
    }

    /**
     * Define o botão "Entrar".
     * 
     * @param btentrar novo botão
     */
    public void setBtentrar(JButton btentrar) {
        this.btentrar = btentrar;
    }

    /**
     * Retorna o label "Senha:".
     * 
     * @return JLabel lblsenha
     */
    public JLabel getLblsenha() {
        return lblsenha;
    }

    /**
     * Define o label de senha.
     * 
     * @param lblsenha novo label
     */
    public void setLblsenha(JLabel lblsenha) {
        this.lblsenha = lblsenha;
    }

    /**
     * Retorna o label "Usuário:".
     * 
     * @return JLabel lblusuario
     */
    public JLabel getLblusuario() {
        return lblusuario;
    }

    /**
     * Define o label de usuário.
     * 
     * @param lblusuario novo label
     */
    public void setLblusuario(JLabel lblusuario) {
        this.lblusuario = lblusuario;
    }

    /**
     * Retorna o campo de texto do usuário.
     * 
     * @return txt1 campo de texto de usuário
     */
    public JTextField getTxt1() {
        return txt1;
    }

    /**
     * Define o campo de texto do usuário.
     * 
     * @param txt1 novo campo de texto
     */
    public void setTxt1(JTextField txt1) {
        this.txt1 = txt1;
    }

    /**
     * Retorna o campo de texto da senha.
     * 
     * @return txt2 campo de texto da senha
     */
    public JTextField getTxt2() {
        return txt2;
    }

    /**
     * Define o campo de texto da senha.
     * 
     * @param txt2 novo campo de texto
     */
    public void setTxt2(JTextField txt2) {
        this.txt2 = txt2;
    }

    // ----------------------------------------------------------------------
    // Código gerado automaticamente pelo NetBeans (não precisa Javadoc)
    // ----------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblusuario = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        lblsenha = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        btcadastrar = new javax.swing.JButton();
        btentrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(635, 685));

        lblusuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblusuario.setText("Usuário:");

        lblsenha.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblsenha.setText("Senha:");

        txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2ActionPerformed(evt);
            }
        });

        btcadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btcadastrar.setText("Cadastrar");
        btcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcadastrarActionPerformed(evt);
            }
        });

        btentrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btentrar.setText("Entrar");
        btentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btentrarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Captura de tela 2025-11-10 161123.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblusuario)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt2)))
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btcadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusuario)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsenha))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btcadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Evento disparado quando o usuário clica no botão "Cadastrar". 
     * Abre a tela de cadastro (Cadastro) e fecha a tela de login atual.
     */
    private void btcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcadastrarActionPerformed
        // TODO add your handling code here:
        // Cria uma nova instância da tela de Cadastro
        Cadastro tela3 = new Cadastro();
        tela3.setVisible(true);// Exibe a tela de cadastro
        this.dispose();// Fecha a tela de login para não ficar acumulando janelas
    }//GEN-LAST:event_btcadastrarActionPerformed
    
    /**
     * Evento disparado quando o usuário clica no botão "Entrar".
     * Chama o método de login no controlador, que irá verificar se o usuário
     * e a senha informados são válidos. Em seguida, fecha a tela de login.
     */
    private void btentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btentrarActionPerformed
        // TODO add your handling code here:
        c.loginAluno();// Chama o método responsável por validar o login no ControleLogin
        this.dispose();// Fecha a tela de login
    }//GEN-LAST:event_btentrarActionPerformed

    private void txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
//    }
    // ----------------------------------------------------------------------
    // Atributos e controller da tela
    // ----------------------------------------------------------------------

    /** Controller que executa a lógica de login do usuário. */
    private ControleLogin c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcadastrar;
    private javax.swing.JButton btentrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    // End of variables declaration//GEN-END:variables
}
