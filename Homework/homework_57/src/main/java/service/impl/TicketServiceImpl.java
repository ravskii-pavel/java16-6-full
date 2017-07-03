package service.impl;

import core.model.Ticket;
import dao.TicketDao;
import service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;
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
