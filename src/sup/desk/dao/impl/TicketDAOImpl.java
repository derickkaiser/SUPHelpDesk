/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.dao.impl;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sup.desk.BDConnect;
import sup.desk.dao.TicketDAO;
import sup.desk.dao.impl.FuncionarioDAOImpl;
import sup.desk.to.Categoria;
import sup.desk.to.Funcionario;
import sup.desk.to.Prioridade;
import sup.desk.to.Status;
import sup.desk.to.Ticket;
import sup.desk.util.NumberLabel;

/**
 *
 * @author derick
 */
public class TicketDAOImpl implements TicketDAO{

    BDConnect bd;
    
    public TicketDAOImpl(BDConnect bd) throws Exception{
        this.bd = bd;
    }
    
    
    @Override
    public ArrayList findAllTickets() throws Exception{
        ResultSet rs = null;
        int i=0;
        ArrayList tickets = new ArrayList();
        rs = bd.query("SELECT * FROM BDIM26.TICKET");
        rs.last();
        int qtty = rs.getRow();
        rs.first();        
        do{
          Ticket ticket = new Ticket();
          ticket.setId(rs.getInt("ID_TICKET"));
          ticket.setTitulo(rs.getString("TITULO"));
          ticket.setDescricao(rs.getString("DESCRICAO"));
          FuncionarioDAOImpl funcDao = new FuncionarioDAOImpl(this.bd);
          Funcionario resp = funcDao.findFuncionarioById(rs.getInt("ID_RESPONSAVEL"));
          Funcionario cliente = funcDao.findFuncionarioById(rs.getInt("ID_CLIENTE"));
          StatusDAOImpl statusDao = new StatusDAOImpl(this.bd);
          Status status = statusDao.findStatusById(rs.getInt("ID_STATUS"));
          PrioridadeDAOImpl prioridadeDao = new PrioridadeDAOImpl(this.bd);
          Prioridade prioridade = prioridadeDao.findPrioridadeById(rs.getInt("ID_PRIORIDADE"));
          CategoriaDAOImpl categoriaDao = new CategoriaDAOImpl(this.bd);
          Categoria categoria = categoriaDao.findCategoriaById(rs.getInt("ID_CATEGORIA"));
          ticket.setPrioridadeDesc(prioridade.getDescricao());
          ticket.setStatusDesc(status.getDescricao());
          ticket.setCategoriaDesc(categoria.getDescricao());
          ticket.setSuporteNome(resp.getNome());
          ticket.setClienteNome(cliente.getNome());
          ticket.setDataAbertura(rs.getDate("DATA_ABERTURA"));
          ticket.setDataConclusao(rs.getDate("DATA_CONCLUSAO"));
          ticket.setDataPrevisao(rs.getDate("DATA_PREVISAO"));
          tickets.add(ticket);
        }while(rs.next());
        return tickets;
    }

    @Override
    public Ticket findTicketByEmployeeId(int empId) throws Exception{
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Ticket findTicketByStatus(int statusId) throws Exception{
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Ticket findTicketByTitle(String title) throws Exception{
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Ticket findTicketByPriority(int priority) throws Exception{
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList findIdTitleAllTickets() throws Exception {
        ResultSet rs;
        int i=0;
        ArrayList tickets = new ArrayList();
        rs = bd.query("SELECT ID_TICKET, TITULO FROM BDIM26.TICKET");
        rs.last();
        int qtty = rs.getRow();
        rs.first();        
        do{
          tickets.add(new NumberLabel(rs.getInt("ID_TICKET"), rs.getString("TITULO")));
        }while(rs.next());
        return tickets;
    }

    @Override
    public Ticket findTicketById(int id) throws Exception {
        ResultSet rs = null;
        int i=0;
        rs = bd.query("SELECT * FROM BDIM26.TICKET WHERE ID_TICKET="+id);
        rs.first();        
          Ticket ticket = new Ticket();
          ticket.setId(rs.getInt("ID_TICKET"));
          ticket.setTitulo(rs.getString("TITULO"));
          ticket.setDescricao(rs.getString("DESCRICAO"));
          FuncionarioDAOImpl funcDao = new FuncionarioDAOImpl(this.bd);
          Funcionario resp = funcDao.findFuncionarioById(rs.getInt("ID_RESPONSAVEL"));
          Funcionario cliente = funcDao.findFuncionarioById(rs.getInt("ID_CLIENTE"));
          StatusDAOImpl statusDao = new StatusDAOImpl(this.bd);
          Status status = statusDao.findStatusById(rs.getInt("ID_STATUS"));
          PrioridadeDAOImpl prioridadeDao = new PrioridadeDAOImpl(this.bd);
          Prioridade prioridade = prioridadeDao.findPrioridadeById(rs.getInt("ID_PRIORIDADE"));
          CategoriaDAOImpl categoriaDao = new CategoriaDAOImpl(this.bd);
          Categoria categoria = categoriaDao.findCategoriaById(rs.getInt("ID_CATEGORIA"));
          ticket.setPrioridadeDesc(prioridade.getDescricao());
          ticket.setStatusDesc(status.getDescricao());
          ticket.setCategoriaDesc(categoria.getDescricao());
          ticket.setSuporteNome(resp.getNome());
          ticket.setClienteNome(cliente.getNome());
          ticket.setDataAbertura(rs.getDate("DATA_ABERTURA"));
          ticket.setDataConclusao(rs.getDate("DATA_CONCLUSAO"));
          ticket.setDataPrevisao(rs.getDate("DATA_PREVISAO"));
        return ticket;
    }
    
    
}
