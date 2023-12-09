package org.example.service;

import org.example.crudServices.ticket.TicketDaoImpl;
import org.example.entity.Ticket;

import java.util.List;

public class TicketService {
    private final TicketDaoImpl ticketDao = new TicketDaoImpl();

    public void saveTicket(Ticket ticket){
        ticketDao.save(ticket);
    }

    public Ticket findTicketById(Long id){
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket){
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket){
        ticketDao.delete(ticket);
    }

    public void deleteTicketById(Long id){
        ticketDao.deleteById(id);
    }

    public List<Ticket> getAllTickets(){
        return ticketDao.getAll();
    }
}
