/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sup.desk.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import sup.desk.BDConnect;
import sup.desk.dao.CargoDAO;
import sup.desk.to.Cargo;

/**
 *
 * @author Derick
 */
public class CargoDAOImpl implements CargoDAO{
    
    BDConnect bd;
    
    public CargoDAOImpl(BDConnect bd){
        this.bd = bd;
    }    
    
    @Override
    public Cargo findCargoById(int id) throws Exception {
       ResultSet rs = bd.query("SELECT * FROM BDIM26.CARGO WHERE ID_CARGO="+id);
       Cargo cargo = new Cargo();
       rs.first();
       cargo.setId(rs.getInt("ID_CARGO"));
       cargo.setDescricao(rs.getString("NOME"));
     return cargo;
    }
    
    @Override
    public ArrayList findAllCargo() throws Exception{
      ResultSet rs = null;
        int i=0;
        try {
            rs = bd.query("SELECT * FROM BDIM26.CARGO");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.last();
        int qtty = rs.getRow();
        rs.first();
        ArrayList cargos = new ArrayList();
        do{
        Cargo cargo = new Cargo();
        cargo.setId(rs.getInt("ID_CARGO"));
        cargo.setDescricao(rs.getString("DESCRICAO"));
            cargos.add(cargo);
        }while(rs.next());
        return cargos;
    }
}
