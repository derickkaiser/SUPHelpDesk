/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao.impl;

import sup.desk.dao.FuncionarioDAO;
import sup.desk.to.Funcionario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sup.desk.BDConnect;

/**
 *
 * @author 14309751
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    BDConnect bd = null;
    
    public FuncionarioDAOImpl(BDConnect bd) throws Exception{
        this.bd = bd;
        bd.getConexao();
    }
    
    @Override
    public Funcionario findFuncionarioById(int id) throws Exception {
       ResultSet rs = null;
        int i=0;
        ArrayList tickets = new ArrayList();
        try {
            rs = bd.query("SELECT * FROM BDIM26.FUNCIONARIO WHERE ID_FUNCIONARIO="+id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.first();        
        Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getInt("ID_FUNCIONARIO"));
        funcionario.setNome(rs.getString("NOME_FUNCIONARIO"));
        funcionario.setEmail(rs.getString("ID_CARGO"));
        funcionario.setTelefone(rs.getString("E_MAIL"));
        funcionario.setRamal(rs.getString("TELEFONE"));
        funcionario.setDataMatricula(rs.getDate("DATA_MATRICULA"));
        funcionario.setCargoNome(rs.getString("ID_CARGO"));
        funcionario.setLogin(rs.getString("USERNAME"));
        funcionario.setSenha(rs.getString("SENHA"));
        return funcionario;
    }

    @Override
    public ArrayList findAllFuncionario() throws Exception{
        ResultSet rs = null;
        int i=0;
        ArrayList tickets = new ArrayList();
        try {
            rs = bd.query("SELECT * FROM BDIM26.FUNCIONARIO");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.last();
        int qtty = rs.getRow();
        rs.first();
        ArrayList funcionarios = new ArrayList();
        do{
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("ID_FUNCIONARIO"));
            funcionario.setNome(rs.getString("NOME_FUNCIONARIO"));
            funcionario.setEmail(rs.getString("ID_CARGO"));
            funcionario.setTelefone(rs.getString("E_MAIL"));
            funcionario.setRamal(rs.getString("TELEFONE"));
            funcionario.setDataMatricula(rs.getDate("DATA_MATRICULA"));
            funcionario.setCargoNome(rs.getString(""));
            funcionario.setLogin(rs.getString("USERNAME"));
            funcionario.setSenha(rs.getString("SENHA"));
            funcionarios.add(funcionario);
        }while(rs.next());
        return funcionarios;
    }

    /*public boolean logarFuncionario (Funcionario login) throws Exception
	{
            BancoConnect banco = new BancoConnect();
	    banco.getConexao();
		
	    ResultSet rs = banco.Query("SELECT * FROM FUNCIONARIO WHERE USERNAME='" + login.getNome() + "'");
            if (rs.first()){	
		if((login.getSenha()).equals(rs.getString(9))){
                    this.setCargoNome(rs.getString(3));
                    this.setNome(rs.getString(2));
		     return true;
                                }
				throw new Exception("Senha Invalida!");	
			}
			else
				throw new Exception("Usuario Invalido!");
			
        }*/
    
    @Override
    public Funcionario findFuncionarioByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
