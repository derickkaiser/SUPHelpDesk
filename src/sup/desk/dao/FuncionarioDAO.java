/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao;

import sup.desk.to.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author 14309751
 */
public interface FuncionarioDAO {
    public Funcionario findFuncionarioById(int id) throws Exception;
    public ArrayList findAllFuncionario() throws Exception;
    public Funcionario findFuncionarioByName(String nome) throws Exception;    
    public ArrayList findIdNameAllFuncionario() throws Exception;
}
