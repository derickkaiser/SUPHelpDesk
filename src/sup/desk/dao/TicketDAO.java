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
       public ArrayList findTicketBySupportId(int empId) throws Exception;
       public Ticket findTicketByStatus(int statusId) throws Exception;
       public Ticket findTicketByTitle(String title) throws Exception;
       public Ticket findTicketByPriority(int priority) throws Exception;  
       public Ticket findTicketById(int id) throws Exception;
       public ArrayList findIdTitleAllTickets() throws Exception;
       public ArrayList findIdTitleTicketBySupportId(int empId) throws Exception;
       public ArrayList findIdTitleTicketByResponsibleId(int respId) throws Exception;
       public void updateTicket(Ticket ticket) throws Exception;
       public void insertTicket(Ticket ticket) throws Exception;
}
