package org.example.client;

import org.example.entity.Client;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientDaoImpl implements ClientDao{
    private SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();


    @Override
    public void saveClient(Client client) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    @Override
    public Client findClientById(Long id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Client.class, id);
        }
    }

    @Override
    public void updateClient(Client client) {
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
    public void deleteClient(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }

    @Override
    public void deleteClientById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client forDelete = session.get(Client.class, id);
            session.remove(forDelete);
            transaction.commit();
        }
    }

    @Override
    public List<Client> getAllClients() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}
