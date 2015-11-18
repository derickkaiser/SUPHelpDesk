/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sup.desk.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import sup.desk.BDConnect;
import sup.desk.dao.CategoriaDAO;
import sup.desk.to.Categoria;

/**
 *
 * @author Derick
 */
public class CategoriaDAOImpl implements CategoriaDAO{

    private BDConnect bd = null;
    
    public CategoriaDAOImpl(BDConnect bd) throws Exception{
        this.bd=bd;
    }
    
    @Override
    public ArrayList findAllCategoria() throws Exception{
        ResultSet rs = null;
        int i=0;
        try {
            rs = bd.query("SELECT * FROM BDIM26.CATEGORIA");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.last();
        int qtty = rs.getRow();
        rs.first();
        ArrayList categorias = new ArrayList();
        do{
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("ID_CATEGORIA"));
        categoria.setDescricao(rs.getString("DESCRICAO"));
            categorias.add(categoria);
        }while(rs.next());
        return categorias;
    }

    @Override
    public Categoria findCategoriaById(int id) throws Exception{
        
        ResultSet rs = null;
        int i=0;
        try {
            rs = bd.query("SELECT * FROM BDIM26.CATEGORIA WHERE ID_CATEGORIA="+id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rs.first();
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("ID_CATEGORIA"));
        categoria.setDescricao(rs.getString("DESCRICAO"));
        return categoria;
    }
    
}
