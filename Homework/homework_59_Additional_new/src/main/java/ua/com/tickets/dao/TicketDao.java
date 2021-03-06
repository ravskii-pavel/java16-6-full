package ua.com.tickets.dao;

import ua.com.tickets.core.model.Ticket;

import java.util.List;

public interface TicketDao {

    void createTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    void updateTicket(Ticket ticket);
    void deleteTicket(Ticket ticket);
}
