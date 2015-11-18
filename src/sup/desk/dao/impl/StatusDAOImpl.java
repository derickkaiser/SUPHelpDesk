/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import sup.desk.BDConnect;
import sup.desk.dao.StatusDAO;
import sup.desk.to.Status;

/**
 *
 * @author derick
 */
public class StatusDAOImpl implements StatusDAO{
    
    BDConnect bd = null;
    
    public StatusDAOImpl(BDConnect bd) throws Exception{
        this.bd = bd;
    }
    
    @Override
    public Status findStatusById(int id) throws Exception {
        ResultSet rs = null;
        try {
            rs = bd.query("SELECT * FROM BDIM26.STATUS WHERE ID_STATUS="+id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        Status status = new Status();
        if(!rs.isBeforeFirst()){
            throw new Exception("Status não existe.");
        }
        rs.first();
        do{
            status.setId(rs.getInt("ID_STATUS"));
            status.setDescricao(rs.getString("DESCRICAO")); 
        }while(rs.next());
        return status;
    }

    @Override
    public ArrayList findAllStatus() throws Exception {
        ResultSet rs = null;
        int i=0;
        try {
            rs = bd.query("SELECT * FROM BDIM26.STATUS");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.last();
        int qtty = rs.getRow();
        rs.first();
        ArrayList lStatus = new ArrayList();
        do{
        Status status = new Status();
        status.setId(rs.getInt("ID_STATUS"));
        status.setDescricao(rs.getString("DESCRICAO"));
            lStatus.add(status);
        }while(rs.next());
        return lStatus;
    }
    
}
