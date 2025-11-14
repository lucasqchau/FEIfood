package View;

import Controller.AlimentoControle;
import Model.Alimento;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de pedido do aplicativo. Permite pesquisar alimentos por descrição
 * e filtrar por tipo, exibindo os resultados em uma tabela. Também possibilita
 * adicionar itens ao carrinho e navegar para a tela de carrinho.
 *
 * A lista de alimentos é carregada por meio do {@link AlimentoControle}.
 * 
 * author uniflchau
 */
public class Pedido extends javax.swing.JFrame {

    /** Modelo utilizado para preencher a tabela jtbtabela. */
    private DefaultTableModel modelo;

    /** Controller responsável por executar buscas de alimentos. */
    private AlimentoControle controller = new AlimentoControle();

    /**
     * Construtor da tela de pedidos.
     * Inicializa os componentes gráficos, configura tabela, listeners e
     * carrega os itens inicialmentes exibidos.
     */
    public Pedido() {
        initComponents();
        modelo = (DefaultTableModel) jtbtabela.getModel();
        configurarTabela();
        carregarTipos();
        carregarDados("", "Todos");
        configurarListeners();
        setLocationRelativeTo(null);
    }

    /**
     * Configura as colunas exibidas na tabela de alimentos.
     */
    private void configurarTabela() {
        modelo.setColumnIdentifiers(new String[]{"Descrição", "Tipo", "Preço"});
    }

    /**
     * Carrega os alimentos no JTable de acordo com filtros fornecidos.
     *
     * @param descricao texto parcial ou completo da descrição
     * @param tipo tipo selecionado ("Todos", "Comida", etc.)
     */
    private void carregarDados(String descricao, String tipo) {
        modelo.setRowCount(0);
        List<Alimento> alimento = controller.buscar(descricao, tipo);

        for (Alimento i : alimento) {
            modelo.addRow(new Object[]{
                i.getDescItem(),
                i.getTipoItem(),
                i.getPrecoItem()
            });
        }
    }

    /**
     * Carrega os tipos no ComboBox de filtro.
     */
    private void carregarTipos() {
        jcb1.removeAllItems();
        jcb1.addItem("Todos");
        jcb1.addItem("Comida");
        jcb1.addItem("Bebida");
        jcb1.addItem("Bebida Alcoólica");
    }

    /**
     * Adiciona ouvintes para atualizar a tabela quando o texto ou tipo muda.
     */
    private void configurarListeners() {
        txt1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { atualizarTabela(); }
            @Override
            public void removeUpdate(DocumentEvent e) { atualizarTabela(); }
            @Override
            public void changedUpdate(DocumentEvent e) { atualizarTabela(); }
        });

        jcb1.addActionListener(e -> atualizarTabela());
    }

    /**
     * Atualiza a tabela com base nos filtros atuais de descrição e tipo.
     */
    private void atualizarTabela() {
        String descricao = txt1.getText();
        String tipo = (String) jcb1.getSelectedItem();
        carregarDados(descricao, tipo);
    }

    /**
     * Método gerado automaticamente pelo NetBeans para montagem da interface.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbtabela = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        jcb1 = new javax.swing.JComboBox<>();
        Jbtadicionar = new javax.swing.JButton();
        jbtcarrinho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtbtabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtbtabela);

        txt1.setColumns(20);
        txt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt1.setRows(5);
        jScrollPane4.setViewportView(txt1);

        jcb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Jbtadicionar.setText("Adicionar");
        Jbtadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtadicionarActionPerformed(evt);
            }
        });

        jbtcarrinho.setText("Carrinho");
        jbtcarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jbtadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtcarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jcb1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jbtadicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jbtcarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtadicionarActionPerformed
        // TODO add your handling code here:
        // Pega a linha selecionada na tabela
        int row = jtbtabela.getSelectedRow();
            // Se nenhuma linha foi selecionada, mostra mensagem e sai do método
            if (row == -1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
                return;
            }

            // Pega os valores da tabela
            String desc  = modelo.getValueAt(row, 0).toString();// Coluna Descrição
            String tipo  = modelo.getValueAt(row, 1).toString();// Coluna Tipo
            double preco = Double.parseDouble(modelo.getValueAt(row, 2).toString());// Coluna Preço

            boolean alcoolica = false;
            int idxColAlcoolica = 3; // índice da coluna de "alcoólica"
            if (modelo.getColumnCount() > idxColAlcoolica) {
                alcoolica = Boolean.parseBoolean(modelo.getValueAt(row, idxColAlcoolica).toString());
            }

            // Cria o item conforme o tipo
            Model.Alimento item;
            if ("Bebida".equalsIgnoreCase(tipo)) {
                // Se for bebida, cria um objeto específico de Bebida,
                // que pode ter o atributo "alcoólica" além do preço
                item = new Model.Bebida(desc, preco, alcoolica);
            } else {
                // Para outros tipos, usa o Alimento genérico
                Model.Alimento a = new Model.Alimento();
                a.setDescItem(desc);
                a.setTipoItem(tipo);
                a.setPrecoItem(preco);
                item = a;
            }

            // Adiciona ao pedido através do controller responsável
            Controller.PedidoControle.adicionarItem(item);
            
            // Exibe mensagem de confirmação
            javax.swing.JOptionPane.showMessageDialog(this, desc + " adicionado ao pedido!");
    }//GEN-LAST:event_JbtadicionarActionPerformed
    /**
     * Evento disparado ao clicar no botão "Carrinho".
     * Abre a tela de carrinho e fecha a tela atual.
     *
     * @param evt evento de clique
     */
    private void jbtcarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcarrinhoActionPerformed
        // TODO add your handling code here:
        new View.Carrinho().setVisible(true);// Abre a tela de carrinho
        this.dispose();// Fecha a tela atual de pedido
    }//GEN-LAST:event_jbtcarrinhoActionPerformed
  
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
//            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Pedido().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbtadicionar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtcarrinho;
    private javax.swing.JComboBox<String> jcb1;
    private javax.swing.JTable jtbtabela;
    private javax.swing.JTextArea txt1;
    // End of variables declaration//GEN-END:variables
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Pedido().setVisible(true);
        });
    }
}
