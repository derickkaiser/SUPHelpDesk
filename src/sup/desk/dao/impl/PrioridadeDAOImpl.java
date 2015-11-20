/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import sup.desk.BDConnect;
import sup.desk.dao.PrioridadeDAO;
import sup.desk.to.Prioridade;

/**
 *
 * @author derick
 */
public class PrioridadeDAOImpl implements PrioridadeDAO{
    
    private BDConnect bd = null;
    
    public PrioridadeDAOImpl(BDConnect bd) throws Exception{
        this.bd = bd;
    }
    
    @Override
    public Prioridade findPrioridadeById(int id) throws Exception {
        ResultSet rs = null;
        try {
            rs = bd.query("SELECT * FROM BDIM26.PRIORIDADE WHERE ID_PRIORIDADE="+id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.first();
        Prioridade prioridade = new Prioridade();
        prioridade.setId(rs.getInt("ID_PRIORIDADE"));
        prioridade.setDescricao(rs.getString("DESCRICAO"));
        prioridade.setDiasParaConclusao(rs.getString("NUM_DIAS_TICKET"));
        return prioridade;
    }

    @Override
    public ArrayList findAllPrioridade() throws Exception {
           ResultSet rs = null;
        int i=0;
        try {
            rs = bd.query("SELECT * FROM BDIM26.PRIORIDADE");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.last();
        int qtty = rs.getRow();
        rs.first();
        ArrayList prioridades = new ArrayList();
        do{
        Prioridade prioridade = new Prioridade();
        prioridade.setId(rs.getInt("ID_PRIORIDADE"));
        prioridade.setDescricao(rs.getString("DESCRICAO"));
        prioridade.setDiasParaConclusao(rs.getString("NUM_DIAS_TICKET"));
            prioridades.add(prioridade);
        }while(rs.next());
        return prioridades;
    }
    
}
