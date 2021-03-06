/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sup.desk.BDConnect;
import sup.desk.dao.FuncionarioDAO;
import sup.desk.to.Cargo;
import sup.desk.to.Funcionario;
import sup.desk.util.NumberLabel;

/**
 *
 * @author 14309751
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    BDConnect bd;
    
    public FuncionarioDAOImpl(BDConnect bd) throws Exception{
        this.bd = bd;
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
        funcionario.setDataMatricula(String.valueOf(rs.getDate("DATA_MATRICULA")));
        CargoDAOImpl cargoDao = new CargoDAOImpl(this.bd);
        Cargo cargo = cargoDao.findCargoById(rs.getInt("ID_CARGO"));
        funcionario.setCargoNome(cargo.getDescricao());
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
            funcionario.setDataMatricula(String.valueOf(rs.getDate("DATA_MATRICULA")));
            funcionario.setCargoNome(rs.getString(""));
            funcionario.setLogin(rs.getString("USERNAME"));
            funcionario.setSenha(rs.getString("SENHA"));
            funcionarios.add(funcionario);
        }while(rs.next());
        return funcionarios;
    }
    
    @Override
    public Funcionario findFuncionarioByLogin (String login, String senha) throws Exception{	
	    ResultSet rs = null;
            rs = bd.query("SELECT * FROM BDIM26.FUNCIONARIO WHERE USERNAME='" + login + "'");
            Funcionario func = new Funcionario();
            rs.first();
            func.setId(rs.getInt("ID_FUNCIONARIO"));
            func.setNome(rs.getString("NOME_FUNCIONARIO"));
            func.setEmail(rs.getString("ID_CARGO"));
            func.setTelefone(rs.getString("E_MAIL"));
            func.setRamal(rs.getString("TELEFONE"));
            CargoDAOImpl cargoDao = new CargoDAOImpl(this.bd);
            Cargo cargo = cargoDao.findCargoById(rs.getInt("ID_CARGO"));
            func.setCargoNome(cargo.getDescricao());
            func.setDataMatricula(String.valueOf(rs.getDate("DATA_MATRICULA")));
            func.setRamal(rs.getString("RAMAL"));
            func.setLogin(rs.getString("USERNAME"));
            func.setSenha(rs.getString("SENHA"));
        return func;
    }
    
    @Override
    public Funcionario findFuncionarioByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList findIdNameAllFuncionario() throws Exception {
        ResultSet rs;
        int i=0;
        ArrayList funcionarios = new ArrayList();
        rs = bd.query("SELECT ID_FUNCIONARIO, NOME_FUNCIONARIO FROM BDIM26.FUNCIONARIO");
        rs.last();
        int qtty = rs.getRow();
        rs.first();        
        do{
          funcionarios.add(new NumberLabel(rs.getInt("ID_FUNCIONARIO"), rs.getString("NOME_FUNCIONARIO")));
        }while(rs.next());
        return funcionarios;
    }

    @Override
    public void updateFuncionario(Funcionario func) throws Exception{
       String updateQuery = "UPDATE BDIM26.FUNCIONARIO SET NOME='"+func.getNome()+"', ID_CARGO="+Integer.valueOf(func.getCargoNome())+", EMAIL='"+func.getEmail() + 
       "', DATA_MATRICULA=TO_DATE('" + func.getDataMatricula() + "','yyyy-mm-dd'), RAMAL='" + func.getRamal() + "', TELEFONE='" + func.getTelefone() +
       "', LOGIN='" + func.getLogin() + "', SENHA='" + func.getSenha() + "' WHERE ID_FUNCIONARIO=" + func.getId();
       System.out.println(updateQuery);
       bd.update(updateQuery);
    }

    @Override
    public void insertFuncionario(Funcionario funcionario) throws Exception {
        String insertSql = "INSERT INTO FUNCIONARIO(ID_FUNCIONARIO, EMAIL, ID_CARGO," +
        " DATA_MATRICULA, RAMAL, TELEFONE, LOGIN, SENHA) "
        +"VALUES(SEQ_FUNCIONARIO.NEXTVAL, '" + funcionario.getEmail() + 
        "', '" + Integer.valueOf(funcionario.getCargoNome()) +"', TO_DATE('"+ funcionario.getDataMatricula() + "','yyyy-mm-dd'), "
        + funcionario.getRamal() + ", " + funcionario.getTelefone() + ", " + funcionario.getLogin() +  ", " + funcionario.getSenha() + ")";
        System.out.println(insertSql);
        bd.update(insertSql);
    }
    
}
