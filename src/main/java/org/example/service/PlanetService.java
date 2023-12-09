package org.example.service;

import org.example.crudServices.planet.PlanetDaoImpl;
import org.example.entity.Planet;

import java.util.List;

public class PlanetService {
    private final PlanetDaoImpl planetDao = new PlanetDaoImpl();

    public void savePlanet(Planet planet){
        planetDao.save(planet);
    }

    public Planet findPlanetById(String id){
        return planetDao.findById(id);
    }

    public void updatePlanet(Planet planet){
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet){
        planetDao.delete(planet);
    }

    public void deletePlanetById(String id){
        planetDao.deleteById(id);
    }

    public List<Planet> getAllPlanets(){
        return planetDao.getAll();
    }
}
