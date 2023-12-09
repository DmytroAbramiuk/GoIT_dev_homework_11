package org.example.crudServices.ticket;

import org.example.crudServices.Dao;
import org.example.entity.Ticket;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class TicketDaoImpl implements Dao<Ticket, Long> {

    private final SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();

    @Override
    public void save(Ticket ticket) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    @Override
    public Ticket findById(Long id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public void update(Ticket ticket) {
        if(Objects.isNull(ticket.getId())){
            return;
        }
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(ticket);
                transaction.commit();
            } catch (Exception e){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Ticket ticket) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket forDelete = session.get(Ticket.class, id);
            session.remove(forDelete);
            transaction.commit();
        }
    }

    @Override
    public List<Ticket> getAll() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }
}
