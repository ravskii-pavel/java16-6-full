package ua.com.tickets.service;

import ua.com.tickets.core.model.Ticket;

import java.util.List;

public interface TicketService {

    void createTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    void updateTicket(Ticket ticket);
    void deleteTicket(Ticket ticket);
}
