/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.telas;

import java.awt.Component;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import sup.desk.BDConnect;
import sup.desk.to.Funcionario;
import sup.desk.to.Ticket;
import sup.desk.dao.impl.TicketDAOImpl;
import sup.desk.util.NumberLabel;
import sup.telas.telaLogin;
import sup.telas.telaSuporte;

/**
 *
 * @author Marcelo
 */
public class telaGerente extends javax.swing.JFrame {
    
    BDConnect bd;
    
    /**
     * Creates new form telaSuporte
     */
    public telaGerente() throws Exception{
        bd = new BDConnect();
        bd.getConexao();                
        initComponents();
        populateComponents();
        
    }

    private void populateComponents() throws Exception{
       TicketDAOImpl ticketDao = new TicketDAOImpl(bd);
       ArrayList tickets = ticketDao.findIdTitleAllTickets();
       DefaultListModel lModel = new DefaultListModel();
       for(int i=0; i<tickets.size();i++){
           NumberLabel ticket = (NumberLabel) tickets.get(i);
           lModel.addElement(ticket);
       }
       listaTarefas.setModel(lModel);
       TicketListCellRenderer tickRenderer = new TicketListCellRenderer();
       listaTarefas.setCellRenderer(tickRenderer);
    }
    
    class TicketListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof NumberLabel) {
            NumberLabel ticket = (NumberLabel)value;
            setText(ticket.getLabel());
            setToolTipText(String.valueOf(ticket.getNumber()));
        }
        return this;
     }
    }
    
    telaGerente(telaLogin aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setFuncionario(Funcionario func)
    {
        try {
            lbUserName.setText(func.getNome());
            if(func.getCargoNome().equals("Gerente Tecnico"))
            {
                lbCargo.setText("Gerente :");
            }
        } catch (Exception ex) {
            Logger.getLogger(telaSuporte.class.getName()).log(Level.SEVERE, null, ex);
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

        lbUserName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTarefas = new javax.swing.JList<String>();
        jLabel2 = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        jLabel3 = new javax.swing.JLabel();
        btnLida = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        btnLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbUserName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        listaTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaTarefasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaTarefas);

        jLabel2.setText("Chamadas da Equipe:");

        lbCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setText("Mensagens:");

        btnLida.setText("Marcar Como Lidas");

        jMenu1.setText("Chamado");

        jMenuItem1.setText("Abrir");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Todos os Chamados");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Funcionario");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu3.setText("Relatórios");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLida)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 71, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnLida)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        telaLogin tl = new telaLogin();
        tl.setVisible(true);
        this.setVisible(false);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        
    }//GEN-LAST:event_jMenu3MouseClicked

    private void listaTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTarefasMouseClicked
        ListModel lModel = listaTarefas.getModel();
        NumberLabel ticket = (NumberLabel) lModel.getElementAt(listaTarefas.getSelectedIndex());
        TelaChamado tChamado = null; 
        try {
            tChamado = new TelaChamado(ticket);
        } catch (Exception ex) {
            Logger.getLogger(telaGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        tChamado.setVisible(true);
    }//GEN-LAST:event_listaTarefasMouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        TelaListaFuncionarios tFuncionarios = null;
        try {
            tFuncionarios = new TelaListaFuncionarios(this.bd);
        } catch (Exception ex) {
            Logger.getLogger(telaGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        tFuncionarios.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

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
            java.util.logging.Logger.getLogger(telaSuporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaSuporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaSuporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaSuporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new telaGerente().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(telaGerente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLida;
    private javax.swing.JMenu btnLogout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JList<String> listaTarefas;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
