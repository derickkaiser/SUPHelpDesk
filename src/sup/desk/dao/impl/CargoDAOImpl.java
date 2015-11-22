/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sup.desk.dao.impl;

import java.sql.ResultSet;
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
}
