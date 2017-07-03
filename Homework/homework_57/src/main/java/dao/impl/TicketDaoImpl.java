package dao.impl;

import core.model.Order;
import core.model.Ticket;
import dao.TicketDao;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TicketDaoImpl implements TicketDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

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
