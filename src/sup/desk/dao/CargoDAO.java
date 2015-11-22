/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sup.desk.dao;

import sup.desk.to.Cargo;

/**
 *
 * @author Derick
 */
public interface CargoDAO {
    public Cargo findCargoById(int id) throws Exception;
}
