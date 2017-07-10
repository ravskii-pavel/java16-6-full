package ua.dp.levelup.dao;

import ua.dp.levelup.core.model.Ticket;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public interface TicketDao {
    void createTicket(Ticket ticket);
}
