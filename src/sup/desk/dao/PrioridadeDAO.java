/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao;

import java.util.ArrayList;
import sup.desk.to.Prioridade;

/**
 *
 * @author derick
 */
public interface PrioridadeDAO {
    public Prioridade findPrioridadeById(int id) throws Exception;
    public ArrayList findAllPrioridade() throws Exception;
}
