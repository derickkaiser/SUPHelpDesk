/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.telas;

import java.awt.Component;
import java.awt.Dialog;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
import sup.desk.util.ValidationUtils;

/**
 *
 * @author derick
 */
public class TelaChamado extends javax.swing.JFrame {

    BDConnect bd;
    
    ArrayList prioridades = null;
    
    FuncionarioListCellRenderer cellRenderer = new FuncionarioListCellRenderer();
    
    /**
     * Creates new form TelaChamado
     */
    public TelaChamado(NumberLabel ticket, BDConnect bd) throws Exception{
        this.bd = bd;
        initComponents();
        populateComponents();
        populateWithTicket(ticket);
    }
    
    public TelaChamado(BDConnect bd) throws Exception{
        this.bd = bd;
        initComponents();
        populateComponents();
    }
    
    public TelaChamado() throws Exception{
        this.bd = new BDConnect();
        this.bd.getConexao();
        initComponents();
        populateComponents();
    }
    
    public void populateComponents() throws Exception{
        CategoriaDAOImpl categoriaDao = new CategoriaDAOImpl(this.bd);
        ArrayList categorias = categoriaDao.findAllCategoria();
        PrioridadeDAOImpl prioridadeDao = new PrioridadeDAOImpl(this.bd);
        prioridades = prioridadeDao.findAllPrioridade();
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
        comboCriador.setRenderer(this.cellRenderer);
        comboResponsavel.setRenderer(this.cellRenderer);
        comboCategoria.setModel(new DefaultComboBoxModel(categorias.toArray()));
        comboCategoria.setRenderer(new CategoriaListCellRenderer());
        comboPrioridade.setModel(new DefaultComboBoxModel(prioridades.toArray()));
        comboPrioridade.setRenderer(new PrioridadeListCellRenderer());
        comboStatus.setModel(new DefaultComboBoxModel(status.toArray()));
        comboStatus.setRenderer(new StatusListCellRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConsultaChamados = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
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
        btnEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDataPrevisao = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox();
        comboCategoria = new javax.swing.JComboBox();
        comboPrioridade = new javax.swing.JComboBox();
        comboResponsavel = new javax.swing.JComboBox();
        comboCriador = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblConsultaChamados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblConsultaChamados.setText("Consulta de Chamados");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setText("Titulo");

        lblDescricao.setLabelFor(txtDescricao);
        lblDescricao.setText("Descricao:");

        txtDescricao.setEditable(false);
        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

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

        txtDataAbertura.setEditable(false);

        jLabel2.setText("Data Conclusão:");

        txtDataConclusao.setEditable(false);

        jLabel3.setText("Código:");

        txtCodigo.setEditable(false);

        btnEditar.setText("Editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        jLabel4.setText("Prioridade:");

        jLabel5.setText("Data Previsão:");

        txtDataPrevisao.setEditable(false);

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });

        comboStatus.setEnabled(false);

        comboCategoria.setEnabled(false);

        comboPrioridade.setEnabled(false);

        comboResponsavel.setEnabled(false);

        comboCriador.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(lblConsultaChamados))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescricao)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnAlterar)
                                        .addGap(13, 13, 13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblResponsavel)
                                            .addComponent(lblStatus))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(btnEditar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCategoria)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5)
                                            .addComponent(lblCriador))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDataConclusao)
                                            .addComponent(txtDataPrevisao)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(comboCriador, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(66, 133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblConsultaChamados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblResponsavel)
                            .addComponent(lblCriador)
                            .addComponent(comboResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(lblCategoria)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDataPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnEditar)
                    .addComponent(btnAlterar))
                .addGap(70, 70, 70))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
        
    }//GEN-LAST:event_btnFecharMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
       txtDescricao.setEditable(true);
       comboResponsavel.setEnabled(true);
       comboStatus.setEnabled(true);
       comboCategoria.setEnabled(true);
       txtDataAbertura.setEditable(true);
       txtDataConclusao.setEditable(true);
       txtDataPrevisao.setEditable(true);
       comboPrioridade.setEnabled(true);
       comboCriador.setEnabled(true);
       btnAlterar.setEnabled(true);
       btnEditar.setEnabled(false);
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        btnAlterar.setEnabled(false);
        if(!ValidationUtils.validateField(txtDescricao.getText()))
            JOptionPane.showMessageDialog(this, "Campo Descricao está vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateDate(txtDataAbertura.getText()))
            JOptionPane.showMessageDialog(this, "Campo Data de Abertura está com data inválida(Esperado: yyyy-mm-dd).", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateField(txtDataConclusao.getText()))
            JOptionPane.showMessageDialog(this, "Campo Data de Conclusão está com data inválida(Esperado: yyyy-mm-dd).", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateField(txtDataPrevisao.getText()))
            JOptionPane.showMessageDialog(this, "Campo Data de Previsão está com data inválida(Esperado: yyyy-mm-dd).", "Erro!",JOptionPane.ERROR_MESSAGE);
        try {
            TicketDAOImpl ticketDao = new TicketDAOImpl(this.bd);
            NumberLabel responsavel = (NumberLabel) comboResponsavel.getItemAt(comboResponsavel.getSelectedIndex());
            NumberLabel criador = (NumberLabel) comboCriador.getItemAt(comboCriador.getSelectedIndex());
            Status status = (Status) comboStatus.getItemAt(comboStatus.getSelectedIndex());
            Prioridade prioridade = (Prioridade) comboPrioridade.getItemAt(comboPrioridade.getSelectedIndex());
            Categoria categoria = (Categoria) comboCategoria.getItemAt(comboCategoria.getSelectedIndex());
            Ticket ticket = new Ticket(Integer.valueOf(txtCodigo.getText()), lblTitulo.getText(), txtDescricao.getText(), 
                    String.valueOf(responsavel.getNumber()), String.valueOf(criador.getNumber()), String.valueOf(prioridade.getId()), 
                    String.valueOf(status.getId()), String.valueOf(categoria.getId()), txtDataAbertura.getText(), 
                    txtDataConclusao.getText(), txtDataPrevisao.getText());
            ticketDao.updateTicket(ticket);
            JOptionPane.showMessageDialog(this,
    "Atualização do ticket " + lblTitulo.getText() + " feita com sucesso.");
            btnAlterar.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarMouseClicked

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
            java.util.logging.Logger.getLogger(TelaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaChamado().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaChamado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnEditar;
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
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblConsultaChamados;
    private javax.swing.JLabel lblCriador;
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
    
    private void populateWithTicket(NumberLabel lblValue) throws Exception{
        TicketDAOImpl ticketDao = new TicketDAOImpl(this.bd);
        Ticket ticket = ticketDao.findTicketById(lblValue.getNumber());
        lblTitulo.setText(ticket.getTitulo());
        txtCodigo.setText(String.valueOf(ticket.getId()));
        txtDescricao.setText(ticket.getDescricao());
        for(int i=0;i<comboResponsavel.getItemCount();i++){
            NumberLabel nLabel = (NumberLabel) comboResponsavel.getItemAt(i);
            if(nLabel.getLabel().equals(ticket.getSuporteNome())){
                comboResponsavel.setSelectedIndex(i);
                break;
            }
        }
        for(int i=0;i<comboCriador.getItemCount();i++){
            NumberLabel nLabel = (NumberLabel) comboCriador.getItemAt(i);
            if(nLabel.getLabel().equals(ticket.getClienteNome())){
                comboCriador.setSelectedIndex(i);
                break;
            }
        }
        for(int i=0; i<comboStatus.getItemCount();i++){
            Status status = (Status) comboStatus.getItemAt(i);
            if(status.getDescricao().equals(ticket.getStatusDesc())){
                comboStatus.setSelectedIndex(i);
                break;
            }

        }
        for(int i=0;i<comboCategoria.getItemCount();i++){
            Categoria categoria = (Categoria) comboCategoria.getItemAt(i);
            if(categoria.getDescricao().equals(ticket.getCategoriaDesc())){
                comboCategoria.setSelectedIndex(i);   
                break;
            }
        }
        for(int i=0;i<comboPrioridade.getItemCount();i++){
            Prioridade prioridade = (Prioridade) comboPrioridade.getItemAt(i);
            if(prioridade.getDescricao().equals(ticket.getPrioridadeDesc())){
                comboPrioridade.setSelectedIndex(i);
                break;
            }
        }
        txtDataAbertura.setText(ticket.getDataAbertura().toString());
        txtDataConclusao.setText(ticket.getDataConclusao().toString());
        txtDataPrevisao.setText(ticket.getDataPrevisao().toString());        
    }
}
