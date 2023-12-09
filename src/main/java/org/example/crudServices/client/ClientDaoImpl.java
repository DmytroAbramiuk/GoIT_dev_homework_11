package org.example.crudServices.client;

import org.example.crudServices.Dao;
import org.example.entity.Client;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientDaoImpl implements Dao<Client, Long> {
    private final SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();


    @Override
    public void save(Client client) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    @Override
    public Client findById(Long id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Client.class, id);
        }
    }

    @Override
    public void update(Client client) {
        if(Objects.isNull(client.getId())){
            return;
        }
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(client);
                transaction.commit();
            } catch (Exception e){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client forDelete = session.get(Client.class, id);
            session.remove(forDelete);
            transaction.commit();
        }
    }

    @Override
    public List<Client> getAll() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}
