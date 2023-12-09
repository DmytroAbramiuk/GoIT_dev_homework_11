package org.example.planet;

import org.example.entity.Planet;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetDaoImpl implements PlanetDao{

    private SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();

    @Override
    public void savePlanet(Planet planet) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    @Override
    public Planet findPlanetById(String id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Planet.class, id);
        }
    }

    @Override
    public void updatePlanet(Planet planet) {
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
    public void deletePlanet(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }

    @Override
    public void deletePlanetById(String id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet forDelete = session.get(Planet.class, id);
            session.remove(forDelete);
            transaction.commit();
        }
    }

    @Override
    public List<Planet> getAllPlanets() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}
