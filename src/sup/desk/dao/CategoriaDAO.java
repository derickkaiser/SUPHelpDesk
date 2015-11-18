/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sup.desk.dao;

import java.util.ArrayList;
import sup.desk.to.Categoria;

/**
 *
 * @author Derick
 */
public interface CategoriaDAO {
    public ArrayList findAllCategoria() throws Exception;
    public Categoria findCategoriaById(int id) throws Exception;
}
