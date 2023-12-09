package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.migration.DbMigration;
import org.example.service.ClientService;
import org.example.service.PlanetService;
import org.example.service.TicketService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbMigration.flywayMigration();
        TicketService ticketService = new TicketService();

        /*-----------------------------------------CLIENT DAO ------------------------------------------*/
        ClientService clientService = new ClientService();
        //TODO save
        clientService.saveClient(createClient("Created Client"));
        //TODO delete
        clientService.deleteClient(createClient("Tokio"));
        //TODO delete by id
        clientService.deleteClientById(1L);
        //TODO get by id
        System.out.println("clientService.findClientById(2L).getName() = " + clientService.findClientById(2L).getName());
        //TODO get all
        clientService.getAllClients().forEach(client -> System.out.println(client.getName()));
        //TODO update
        clientService.updateClient(createClient(2L, "lala"));


        /*-----------------------------------------PLANET DAO ------------------------------------------*/
        PlanetService planetService = new PlanetService();
        //TODO save
        planetService.savePlanet(createPlanet("OFKA1", "lala"));
        //TODO delete
        planetService.deletePlanet(createPlanet("1OP13", "Jupiter"));
        //TODO delete by id
        planetService.deletePlanetById("13AKR");
        //TODO get by id
        System.out.println("clientService.findClientById(2L).getName() = " + planetService.findPlanetById("ABC13").getName());
        //TODO get all
        planetService.getAllPlanets().forEach(planet -> System.out.println(planet.getName()));
        //TODO update
        planetService.updatePlanet(createPlanet("ABC13", "lalala"));


        /*-----------------------------------------TICKET DAO ------------------------------------------*/
        //TODO save
        ticketService.saveTicket(
                createTicket(
                        LocalDateTime.now(),
                        createClient(1L, "Arturo"),
                        createPlanet("ABC13", "Earth"),
                        createPlanet("EFG46", "Mars")
                )
        );
        //TODO delete
        ticketService.deleteTicket(ticketService.findTicketById(2L));
        //TODO delete by id
        ticketService.deleteTicketById(1L);
        //TODO get by id
        System.out.println("ticketService.findTicketById(7L) = " + ticketService.findTicketById(7L).getClient().getId());
        //TODO get all
        List<Ticket> ticketList = ticketService.getAllTickets();
        ticketList.forEach(ticket -> System.out.println(ticket.getId()));
        //TODO update
        Ticket ticket = ticketService.findTicketById(3L);
        ticket.setToPlanet(createPlanet("EFG46", "Mars"));
        ticket.setCreatedAt(LocalDateTime.now());
        ticketService.updateTicket(ticket);
    }


    public static Client createClient(String name) {
        Client client = new Client();
        client.setName(name);
        return client;
    }

    public static Client createClient(Long id, String name) {
        Client client = createClient(name);
        client.setId(id);
        return client;
    }

    public static Planet createPlanet(String name) {
        Planet planet = new Planet();
        planet.setName(name);
        return planet;
    }

    public static Planet createPlanet(String id, String name) {
        Planet planet = createPlanet(name);
        planet.setId(id);
        return planet;
    }

    public static Ticket createTicket(LocalDateTime dateTime, Client client, Planet fromPlanet, Planet toPlanet) {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(dateTime);
        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);
        return ticket;
    }

    public static Ticket createTicket(Long id, LocalDateTime dateTime, Client client, Planet fromPlanet, Planet toPlanet) {
        Ticket ticket = createTicket(dateTime, client, fromPlanet, toPlanet);
        ticket.setId(id);

        return ticket;
    }
}