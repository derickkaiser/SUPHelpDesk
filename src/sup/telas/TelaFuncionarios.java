/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sup.telas;

import java.awt.Component;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import sup.desk.BDConnect;
import sup.desk.dao.impl.CargoDAOImpl;
import sup.desk.dao.impl.FuncionarioDAOImpl;
import sup.desk.to.Cargo;
import sup.desk.to.Funcionario;
import sup.desk.util.NumberLabel;
import sup.desk.util.ValidationUtils;

/**
 *
 * @author Derick
 */
public class TelaFuncionarios extends javax.swing.JFrame {
    
    private BDConnect bd;
    private boolean isInsert = false;
    
    /**
     * Creates new form TelaFuncionarios
     */
    public TelaFuncionarios(BDConnect bd) {
        this.isInsert = true;
        this.bd = bd;
        initComponents();
        enableComponents();
    }
    
    public TelaFuncionarios(NumberLabel func, BDConnect bd) throws Exception{
        this.bd = bd;
        initComponents();
        populateFuncValues(func);
    }

    private TelaFuncionarios() throws Exception{
        this.bd = new BDConnect();
        bd.getConexao();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLogin = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        lbllogin = new javax.swing.JLabel();
        lblRamal = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblDataMatricula = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        lblCargo = new javax.swing.JLabel();
        comboCargo = new javax.swing.JComboBox();
        lblNome = new javax.swing.JLabel();
        lblConsultaFuncionarios = new javax.swing.JLabel();
        txtDataMatricula = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtRamal = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtLogin.setEditable(false);

        btnFechar.setText("Fechar");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
        });

        lbllogin.setText("Login:");

        lblRamal.setText("Ramal:");

        lblTelefone.setText("Telefone:");

        lblDataMatricula.setText("Data Matrícula:");

        lblEmail.setText("Email:");
        lblEmail.setToolTipText("");

        txtSenha.setEditable(false);

        lblSenha.setText("Senha:");

        lblCodigo.setText("Código:");

        txtCodigo.setEditable(false);

        btnEditar.setText("Editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });

        lblCargo.setText("Cargo:");

        comboCargo.setEnabled(false);

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblConsultaFuncionarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblConsultaFuncionarios.setText("Consulta de Funcionários");

        txtDataMatricula.setEditable(false);

        txtEmail.setEditable(false);

        txtRamal.setEditable(false);

        txtTelefone.setEditable(false);

        txtNome.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(btnFechar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAlterar)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnEditar)))
                                .addGap(149, 149, 149))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataMatricula)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblRamal)
                                    .addComponent(lbllogin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtRamal)
                                        .addComponent(txtDataMatricula)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTelefone)
                                .addComponent(lblCargo)
                                .addComponent(lblEmail)
                                .addComponent(lblSenha))
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSenha)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNome)
                                .addGap(47, 47, 47)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(lblConsultaFuncionarios)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblConsultaFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataMatricula)
                            .addComponent(txtDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRamal)
                            .addComponent(txtRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbllogin)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCargo)
                            .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSenha)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnEditar)
                    .addComponent(btnAlterar))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();

    }//GEN-LAST:event_btnFecharMouseClicked

    public void enableComponents(){
        comboCargo.setEnabled(true);
        txtDataMatricula.setEditable(true);
        txtNome.setEditable(true);
        txtEmail.setEditable(true);
        txtRamal.setEditable(true);
        txtTelefone.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);
        btnAlterar.setEnabled(true);
        btnAlterar.setText("Cadastrar");
        btnEditar.setVisible(false);
    }
    
    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        comboCargo.setEnabled(true);
        txtDataMatricula.setEditable(true);
        txtNome.setEditable(true);
        txtEmail.setEditable(true);
        txtRamal.setEditable(true);
        txtTelefone.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);
        btnAlterar.setEnabled(true);
        btnEditar.setEnabled(false);
    }//GEN-LAST:event_btnEditarMouseClicked

    public void populateFuncValues(NumberLabel func) throws Exception{
        FuncionarioDAOImpl funcionarioDao = new FuncionarioDAOImpl(this.bd);
        Funcionario emp = funcionarioDao.findFuncionarioById(func.getNumber());
        CargoDAOImpl cargoDao = new CargoDAOImpl(this.bd);
        ArrayList cargos = cargoDao.findAllCargo();
         DefaultComboBoxModel cargosModel = new DefaultComboBoxModel();
        for(int i=0;i<cargos.size();i++){
            NumberLabel nLabel = (NumberLabel) cargos.get(i);
            cargosModel.addElement(nLabel);
        }
        txtDataMatricula.setText(emp.getDataMatricula());
        txtNome.setText(emp.getNome());
        txtEmail.setText(emp.getEmail());
        txtRamal.setText(emp.getRamal());
        txtTelefone.setText(emp.getTelefone());
        txtLogin.setText(emp.getLogin());
        txtSenha.setText(emp.getSenha());
        comboCargo.setRenderer(new CargoListCellRenderer());
        comboCargo.setModel(cargosModel);
        for(int i=0;i<comboCargo.getItemCount();i++){
            NumberLabel nLabel = (NumberLabel) comboCargo.getItemAt(i);
            if(nLabel.getLabel().equals(emp.getCargoNome())){
                comboCargo.setSelectedIndex(i);
                break;
            }
        }
    }
    
    class CargoListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Cargo) {
            Cargo cargo = (Cargo)value;
            setText(cargo.getDescricao());
            setToolTipText(String.valueOf(cargo.getId()));
        }
        return this;
     }
    }
    
    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        btnAlterar.setEnabled(false);
        if(!ValidationUtils.validateField(txtNome.getText()))
            JOptionPane.showMessageDialog(this, "Campo Nome está vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateField(txtEmail.getText()))
            JOptionPane.showMessageDialog(this, "Campo E-mail está vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateField(txtTelefone.getText()))
            JOptionPane.showMessageDialog(this, "Campo Telefone está vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateField(txtRamal.getText()))
            JOptionPane.showMessageDialog(this, "Campo Ramal está vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateDate(txtDataMatricula.getText()))
            JOptionPane.showMessageDialog(this, "Campo Data de Matrícula está com data inválida(Esperado: yyyy-mm-dd).", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateField(txtLogin.getText()))
            JOptionPane.showMessageDialog(this, "Campo Login está vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!ValidationUtils.validateField(txtSenha.getText()))
            JOptionPane.showMessageDialog(this, "Campo Senha está vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
        if(!isInsert){
            try {
                FuncionarioDAOImpl funcDao = new FuncionarioDAOImpl(this.bd);
                NumberLabel cargo = (NumberLabel) comboCargo.getItemAt(comboCargo.getSelectedIndex());            
                Funcionario func = new Funcionario(Integer.valueOf(txtCodigo.getText()), txtNome.getText(), txtEmail.getText(), txtTelefone.getText(), 
                  txtRamal.getText(), txtDataMatricula.getText(), String.valueOf(cargo.getNumber()), txtLogin.getText(), txtSenha.getText());
                funcDao.updateFuncionario(func);
                JOptionPane.showMessageDialog(this,
    "Atualização do funcionário  " + txtNome.getText() + " feita com sucesso.");
            } catch (Exception ex) {
                Logger.getLogger(TelaChamado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            FuncionarioDAOImpl funcDao;
            try {
                funcDao = new FuncionarioDAOImpl(this.bd);
                NumberLabel cargo = (NumberLabel) comboCargo.getItemAt(comboCargo.getSelectedIndex());  
                Funcionario func = new Funcionario(0, txtNome.getText(), txtEmail.getText(), txtTelefone.getText(), 
                  txtRamal.getText(), txtDataMatricula.getText(), String.valueOf(cargo.getNumber()), txtLogin.getText(), txtSenha.getText());
                funcDao.insertFuncionario(func);
                            JOptionPane.showMessageDialog(this,
    "Inserção do funcionário  " + txtNome.getText() + " feita com sucesso.");
            } catch (Exception ex) {
                Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaFuncionarios().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox comboCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConsultaFuncionarios;
    private javax.swing.JLabel lblDataMatricula;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRamal;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lbllogin;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataMatricula;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRamal;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
