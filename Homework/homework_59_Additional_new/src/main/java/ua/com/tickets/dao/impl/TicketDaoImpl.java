package ua.com.tickets.dao.impl;

import ua.com.tickets.core.model.Ticket;
import ua.com.tickets.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createTicket(Ticket ticket) { hibernateTemplate.save(ticket); }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> listTickets = hibernateTemplate.loadAll(Ticket.class);
        for (Ticket t : listTickets){
            t.toString();
            //Order order = t.getOrderList();
            //ticketList.toString(); //Ели Fetch - Lazy, Чтобы не получать LazyInitializationException - не обязательно создавать новую сессию и открывать транзакцию. Достаточно сделать sout map или каждого объекта в цикле foreach, который лежит в map. (или FetchType = EGER)
        }
        return listTickets;
    }

    @Override
    public Ticket getTicketById(Long id) {
        Ticket ticket = hibernateTemplate.load(Ticket.class, id);
        ticket.toString();
        return ticket;
    }

    @Override
    public void updateTicket(Ticket ticket) {
        hibernateTemplate.update(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        hibernateTemplate.delete(ticket);
    }
}
