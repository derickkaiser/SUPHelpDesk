/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao;

import sup.desk.to.Ticket;
import java.util.ArrayList;

/**
 *
 * @author derick
 */
public interface TicketDAO {
       public ArrayList findAllTickets() throws Exception;
       public Ticket findTicketByEmployeeId(int empId) throws Exception;
       public Ticket findTicketByStatus(int statusId) throws Exception;
       public Ticket findTicketByTitle(String title) throws Exception;
       public Ticket findTicketByPriority(int priority) throws Exception;    
}