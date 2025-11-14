package View;

/**
 * Tela de avaliação do aplicativo. Exibe cinco estrelas que o usuário pode
 * selecionar para atribuir uma nota de 0 a 5. A nota é exibida visualmente
 * preenchendo ou esvaziando as estrelas.
 *
 * A classe utiliza botões do Swing configurados para simular estrelas e
 * registra interações do usuário por meio de ActionListeners.
 * 
 * author rchau
 */
public class Avaliar extends javax.swing.JFrame {

    /** Vetor contendo os botões representando as estrelas. */
    private javax.swing.JButton[] estrelas;

    /** Nota selecionada pelo usuário (0 a 5). */
    private int notaAtual = 0;

    /** Logger para registrar mensagens de depuração. */
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(Avaliar.class.getName());

    /**
     * Construtor da tela de avaliação.
     * Inicializa os componentes, centraliza a janela e configura o comportamento
     * dos botões de estrela.
     */
    public Avaliar() {
        initComponents();
        setLocationRelativeTo(null);
        configurarEstrelas();
    }

    /**
     * Configura os botões que representam as estrelas.
     * Define fonte, aparência visual e adiciona ActionListeners para permitir
     * que o usuário selecione uma nota de 0 a 5.
     */
    private void configurarEstrelas() {
        estrelas = new javax.swing.JButton[]{
            jbestrela1, jbestrela2, jbestrela3, jbestrela4, jbestrela5
        };

        java.awt.Font fonteEstrela =
                new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 32);

        for (int i = 0; i < estrelas.length; i++) {
            javax.swing.JButton b = estrelas[i];
            b.setFont(fonteEstrela);
            b.setText("\u2606"); // estrela vazia
            b.setFocusPainted(false);
            b.setBorderPainted(false);
            b.setContentAreaFilled(false);

            final int valorEstrela = i + 1;

            b.addActionListener(e -> {
                if (notaAtual == valorEstrela) {
                    notaAtual = 0;
                } else {
                    notaAtual = valorEstrela;
                }
                atualizarEstrelas();
            });
        }
    }

    /**
     * Atualiza o estado visual das estrelas de acordo com a nota selecionada.
     * Estrelas com índice menor que a nota exibem o símbolo ★; caso contrário, ☆.
     */
    private void atualizarEstrelas() {
        for (int i = 0; i < estrelas.length; i++) {
            if (i < notaAtual) {
                estrelas[i].setText("\u2605"); // ★ cheia
            } else {
                estrelas[i].setText("\u2606"); // ☆ vazia
            }
        }
    }

    // -------------------------------------------------------------------------
    // A partir daqui é código gerado automaticamente pelo NetBeans.
    // Não é necessário adicionar Javadoc, pois initComponents() é private.
    // -------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbestrela1 = new javax.swing.JButton();
        jbestrela2 = new javax.swing.JButton();
        jbestrela3 = new javax.swing.JButton();
        jbestrela4 = new javax.swing.JButton();
        jbestrela5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Avalie nosso Aplicativo!");

        jbestrela1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jbestrela1.setText("☆");
        jbestrela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbestrela1ActionPerformed(evt);
            }
        });

        jbestrela2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jbestrela2.setText("☆");
        jbestrela2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbestrela2ActionPerformed(evt);
            }
        });

        jbestrela3.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jbestrela3.setText("☆");
        jbestrela3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbestrela3ActionPerformed(evt);
            }
        });

        jbestrela4.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jbestrela4.setText("☆");
        jbestrela4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbestrela4ActionPerformed(evt);
            }
        });

        jbestrela5.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jbestrela5.setText("☆");
        jbestrela5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbestrela5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jbestrela1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbestrela2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbestrela3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbestrela4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbestrela5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbestrela1)
                    .addComponent(jbestrela2)
                    .addComponent(jbestrela3)
                    .addComponent(jbestrela4)
                    .addComponent(jbestrela5))
                .addContainerGap(322, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbestrela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbestrela1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbestrela1ActionPerformed

    private void jbestrela2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbestrela2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbestrela2ActionPerformed

    private void jbestrela3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbestrela3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbestrela3ActionPerformed

    private void jbestrela4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbestrela4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbestrela4ActionPerformed

    private void jbestrela5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbestrela5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbestrela5ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new Avaliar().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbestrela1;
    private javax.swing.JButton jbestrela2;
    private javax.swing.JButton jbestrela3;
    private javax.swing.JButton jbestrela4;
    private javax.swing.JButton jbestrela5;
    // End of variables declaration//GEN-END:variables
}
