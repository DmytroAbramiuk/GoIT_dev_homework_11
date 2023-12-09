package org.example.service;

import org.example.dao.planet.PlanetDao;
import org.example.dao.planet.PlanetDaoImpl;
import org.example.entity.Planet;

import java.util.List;

public class PlanetService {
    private final PlanetDao planetDao = new PlanetDaoImpl();

    public void savePlanet(Planet planet){
        planetDao.savePlanet(planet);
    }

    public Planet findPlanetById(String id){
        return planetDao.findPlanetById(id);
    }

    public void updatePlanet(Planet planet){
        planetDao.updatePlanet(planet);
    }

    public void deletePlanet(Planet planet){
        planetDao.deletePlanet(planet);
    }

    public void deletePlanetById(String id){
        planetDao.deletePlanetById(id);
    }

    public List<Planet> getAllPlanets(){
        return planetDao.getAllPlanets();
    }
}
