package View;

import javax.swing.table.DefaultTableModel;

/**
 * Tela de carrinho do sistema. Exibe todos os itens adicionados ao pedido,
 * permitindo remover itens, visualizar o total e avançar para a tela de
 * avaliação do aplicativo.
 *
 * author rchau
 */
public class Carrinho extends javax.swing.JFrame {

    /** Logger para mensagens de depuração. */
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(Carrinho.class.getName());

    /**
     * Construtor da tela de carrinho.
     * Inicializa a interface, posiciona a janela no centro, carrega os itens
     * do pedido e calcula o total.
     */
    public Carrinho() {
        initComponents();
        setLocationRelativeTo(null);
        carregarItens();
        calcularTotal();
    }

    /**
     * Carrega os itens do pedido na tabela jtcarrinho.
     * Obtém os itens da classe PedidoControle e adiciona cada um à tabela.
     */
    private void carregarItens() {
        DefaultTableModel dadosTabela = (DefaultTableModel) jtcarrinho.getModel();
        dadosTabela.setRowCount(0);

        for (Model.Alimento a : Controller.PedidoControle.getItensPedido()) {
            dadosTabela.addRow(new Object[]{
                a.getDescItem(),
                a.getTipoItem(),
                String.format("R$ %.2f", a.getPrecoFinal())
            });
        }
    }

    /**
     * Soma o preço final de todos os itens do pedido e exibe o resultado no
     * campo jtxttotal.
     */
    private void calcularTotal() {
        double total = 0;

        for (Model.Alimento a : Controller.PedidoControle.getItensPedido()) {
            double pf = a.getPrecoFinal();
            logger.fine(() -> a.getDescItem() + " -> precoFinal=" + pf
                    + " (" + a.getClass().getSimpleName() + ")");
            total += pf;
        }

        jtxttotal.setText(String.format("R$ %.2f", total));
    }

    // -------------------------------------------------------------------------
    // Código gerado automaticamente pelo NetBeans
    // -------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtcarrinho = new javax.swing.JTable();
        jltotal = new javax.swing.JLabel();
        jtxttotal = new javax.swing.JTextField();
        jbtfinalizar = new javax.swing.JButton();
        jbtremover = new javax.swing.JButton();
        jbvoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtcarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descrição", "Tipo", "Preço"
            }
        ));
        jScrollPane1.setViewportView(jtcarrinho);

        jltotal.setText("Total:");

        jtxttotal.setEditable(false);
        jtxttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxttotalActionPerformed(evt);
            }
        });

        jbtfinalizar.setText("Finalizar Pedido");
        jbtfinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtfinalizarActionPerformed(evt);
            }
        });

        jbtremover.setText("Remover");
        jbtremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtremoverActionPerformed(evt);
            }
        });

        jbvoltar.setText("Voltar");
        jbvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbvoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbvoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtremover, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jtxttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtfinalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtremover, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtfinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jbvoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttotalActionPerformed

    /**
     * Evento do botão "Finalizar Pedido".
     * Abre a tela de avaliação (Avaliar) e fecha o carrinho.
     */
    private void jbtfinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtfinalizarActionPerformed
        // TODO add your handling code here:
        Avaliar tela4 = new Avaliar();// Cria a tela de avaliação
        tela4.setVisible(true);// Exibe a tela
        this.dispose();// Fecha a tela de carrinho
    }//GEN-LAST:event_jbtfinalizarActionPerformed

    /**
     * Evento do botão "Remover". 
     * Remove o item selecionado da lista do pedido, recarrega a tabela
     * e recalcula o total.
     */
    private void jbtremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtremoverActionPerformed
        // TODO add your handling code here:
        // Pega a linha selecionada na tabela
        int linhaSelecionada = jtcarrinho.getSelectedRow();
            // Se nenhuma linha estiver selecionada, mostra aviso e interrompe o fluxo
            if (linhaSelecionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Selecione um item na tabela para remover.");
            return;
        }

        int linhaModelo = linhaSelecionada;

        // Pede para o controller remover do modelo
        Controller.PedidoControle.removerItem(linhaModelo);

        // Atualiza tabela e total
        carregarItens();
        calcularTotal();

    }//GEN-LAST:event_jbtremoverActionPerformed

    /**
     * Evento do botão "Voltar".
     * Fecha o carrinho e volta para a tela de Pedido.
     */
    private void jbvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbvoltarActionPerformed
        // TODO add your handling code here:
        Pedido tela2 = new Pedido();// Cria a tela de Pedido
        tela2.setVisible(true);// Exibe a tela de Pedido
        this.dispose();// Fecha a tela de Carrinho
    }//GEN-LAST:event_jbvoltarActionPerformed

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
//        java.awt.EventQueue.invokeLater(() -> new Carrinho().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtfinalizar;
    private javax.swing.JButton jbtremover;
    private javax.swing.JButton jbvoltar;
    private javax.swing.JLabel jltotal;
    private javax.swing.JTable jtcarrinho;
    private javax.swing.JTextField jtxttotal;
    // End of variables declaration//GEN-END:variables
}
