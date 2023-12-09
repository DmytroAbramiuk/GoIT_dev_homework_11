package org.example.crudServices.planet;

import org.example.crudServices.Dao;
import org.example.entity.Planet;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetDaoImpl implements Dao<Planet, String> {

    private final SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();

    @Override
    public void save(Planet planet) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    @Override
    public Planet findById(String id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Planet.class, id);
        }
    }

    @Override
    public void update(Planet planet) {
        if(Objects.isNull(planet.getId())){
            return;
        }
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(planet);
                transaction.commit();
            } catch (Exception e){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(String id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet forDelete = session.get(Planet.class, id);
            session.remove(forDelete);
            transaction.commit();
        }
    }

    @Override
    public List<Planet> getAll() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}
