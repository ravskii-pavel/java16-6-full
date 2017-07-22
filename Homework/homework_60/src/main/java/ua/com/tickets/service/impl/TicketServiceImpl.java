package ua.com.tickets.service.impl;

import ua.com.tickets.core.model.Ticket;
import ua.com.tickets.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.tickets.service.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;

    @Autowired
    public void setTicketDao(final TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketDao.createTicket(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketDao.getTicketById(id);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketDao.updateTicket(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketDao.deleteTicket(ticket);
    }
}
