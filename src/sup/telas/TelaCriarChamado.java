/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.telas;

import java.awt.Component;
import java.awt.Dialog;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import sup.desk.BDConnect;
import sup.desk.dao.impl.CategoriaDAOImpl;
import sup.desk.dao.impl.FuncionarioDAOImpl;
import sup.desk.dao.impl.PrioridadeDAOImpl;
import sup.desk.dao.impl.StatusDAOImpl;
import sup.desk.dao.impl.TicketDAOImpl;
import sup.desk.to.Categoria;
import sup.desk.to.Prioridade;
import sup.desk.to.Status;
import sup.desk.to.Ticket;
import sup.desk.util.NumberLabel;

/**
 *
 * @author 13043328
 */
public class TelaCriarChamado extends javax.swing.JFrame {

    private BDConnect bd;
    
    /**
     * Creates new form TelaCriarChamado
     */
    public TelaCriarChamado(BDConnect bd) throws Exception{
        this.bd = bd;
        initComponents();
        populateComponents();
    }
    
    public TelaCriarChamado() throws Exception{
        initComponents();
        populateComponents();
    }

    private void populateComponents() throws Exception{
      
        CategoriaDAOImpl categoriaDao = new CategoriaDAOImpl(this.bd);
        ArrayList categorias = categoriaDao.findAllCategoria();
        PrioridadeDAOImpl prioridadeDao = new PrioridadeDAOImpl(this.bd);
        ArrayList prioridades = prioridadeDao.findAllPrioridade();
        StatusDAOImpl statusDao = new StatusDAOImpl(this.bd);
        ArrayList status = statusDao.findAllStatus();
        FuncionarioDAOImpl funcionarioDao = new FuncionarioDAOImpl(this.bd);
        ArrayList funcionarios = funcionarioDao.findIdNameAllFuncionario();
        DefaultComboBoxModel respModel = new DefaultComboBoxModel();
        DefaultComboBoxModel criadorModel = new DefaultComboBoxModel();
        for(int i=0;i<funcionarios.size();i++){
            NumberLabel nLabel = (NumberLabel) funcionarios.get(i);
            respModel.addElement(nLabel);
        }
        for(int i=0;i<funcionarios.size();i++){
            NumberLabel nLabel = (NumberLabel) funcionarios.get(i);
            criadorModel.addElement(nLabel);
        }
        comboResponsavel.setModel(respModel);
        comboCriador.setModel(criadorModel);
        comboCriador.setRenderer(new FuncionarioListCellRenderer());
        comboResponsavel.setRenderer(new FuncionarioListCellRenderer());
        comboCategoria.setModel(new DefaultComboBoxModel(categorias.toArray()));
        comboCategoria.setRenderer(new CategoriaListCellRenderer());
        comboPrioridade.setModel(new DefaultComboBoxModel(prioridades.toArray()));
        comboPrioridade.setRenderer(new PrioridadeListCellRenderer());
        comboStatus.setModel(new DefaultComboBoxModel(status.toArray()));
        comboStatus.setRenderer(new StatusListCellRenderer());
    }
    
    class FuncionarioListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof NumberLabel) {
            NumberLabel func = (NumberLabel)value;
            setText(func.getLabel());
            setToolTipText(String.valueOf(func.getNumber()));
        }
        return this;
     }
    }
    
    class PrioridadeListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Prioridade) {
            Prioridade prioridade = (Prioridade)value;
            setText(prioridade.getDescricao());
        }
        return this;
     }
    }
    
    class CategoriaListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Categoria) {
            Categoria categoria = (Categoria)value;
            setText(categoria.getDescricao());
        }
        return this;
     }
    }
    
    class StatusListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Status) {
            Status status = (Status)value;
            setText(status.getDescricao());
        }
        return this;
     }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescricao = new javax.swing.JLabel();
        comboResponsavel = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        comboCriador = new javax.swing.JComboBox();
        lblResponsavel = new javax.swing.JLabel();
        lblCriador = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDataAbertura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDataConclusao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDataPrevisao = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox();
        lblCriarChamados = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox();
        lblTitulo = new javax.swing.JLabel();
        comboPrioridade = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDescricao.setText("Descricao:");

        comboResponsavel.setEditable(true);
        comboResponsavel.setEnabled(false);

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        comboCriador.setEditable(true);
        comboCriador.setEnabled(false);

        lblResponsavel.setText("Responsável:");

        lblCriador.setText("Criador:");
        lblCriador.setToolTipText("");

        lblStatus.setText("Status:");

        lblCategoria.setText("Categoria:");

        btnFechar.setText("Fechar");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
        });

        jLabel1.setText("Data Abertura:");

        jLabel2.setText("Data Conclusão:");

        jLabel3.setText("Código:");
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel4.setText("Prioridade:");

        jLabel5.setText("Data Previsão:");

        btnAlterar.setText("Abrir");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });

        comboStatus.setEditable(true);
        comboStatus.setEnabled(false);

        lblCriarChamados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCriarChamados.setText("Abrir Chamado");

        comboCategoria.setEditable(true);
        comboCategoria.setEnabled(false);

        lblTitulo.setText("Titulo:");

        comboPrioridade.setEditable(true);
        comboPrioridade.setEnabled(false);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblResponsavel)
                                    .addComponent(lblStatus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboStatus, 0, 141, Short.MAX_VALUE)
                                    .addComponent(comboResponsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(25, 25, 25)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDataAbertura, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(comboPrioridade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblCategoria)
                            .addComponent(lblCriador)
                            .addComponent(jLabel5))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCriador, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCriarChamados)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnAlterar)
                .addGap(120, 120, 120)
                .addComponent(btnFechar)
                .addGap(0, 178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblCriarChamados)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblResponsavel)
                            .addComponent(lblCriador)
                            .addComponent(comboResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblStatus)
                                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();

    }//GEN-LAST:event_btnFecharMouseClicked

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        btnAlterar.setEnabled(false);
        try {
            TicketDAOImpl ticketDao = new TicketDAOImpl(this.bd);
            NumberLabel responsavel = (NumberLabel) comboResponsavel.getItemAt(comboResponsavel.getSelectedIndex());
            NumberLabel criador = (NumberLabel) comboCriador.getItemAt(comboCriador.getSelectedIndex());
            Status status = (Status) comboStatus.getItemAt(comboStatus.getSelectedIndex());
            Prioridade prioridade = (Prioridade) comboPrioridade.getItemAt(comboPrioridade.getSelectedIndex());
            Categoria categoria = (Categoria) comboCategoria.getItemAt(comboCategoria.getSelectedIndex());
            Ticket ticket = new Ticket(Integer.valueOf(txtCodigo.getText()), lblTitulo.getText(), txtDescricao.getText(), String.valueOf(responsavel.getNumber()), String.valueOf(criador.getNumber()), String.valueOf(prioridade.getId()), String.valueOf(status.getId()), String.valueOf(categoria.getId()), Date.valueOf(txtDataAbertura.getText()), Date.valueOf(txtDataConclusao.getText()), Date.valueOf(txtDataPrevisao.getText()));
            ticketDao.insertTicket(ticket);
            Dialog dialog = new Dialog(this, "Atalizacao do chamado "+ lblTitulo.getText() + "atualizado com sucesso.");
            dialog.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCriarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCriarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCriarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCriarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCriarChamado().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCriarChamado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JComboBox comboCriador;
    private javax.swing.JComboBox comboPrioridade;
    private javax.swing.JComboBox comboResponsavel;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCriador;
    private javax.swing.JLabel lblCriarChamados;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblResponsavel;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataAbertura;
    private javax.swing.JTextField txtDataConclusao;
    private javax.swing.JTextField txtDataPrevisao;
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
}
