package org.example.service;

import org.example.dao.client.ClientDao;
import org.example.dao.client.ClientDaoImpl;
import org.example.entity.Client;

import java.util.List;

public class ClientService {
    private final ClientDao clientDao = new ClientDaoImpl();

    public void saveClient(Client client){
        clientDao.saveClient(client);
    }

    public Client findClientById(Long id){
        return clientDao.findClientById(id);
    }

    public void updateClient(Client client){
        clientDao.updateClient(client);
    }

    public void deleteClient(Client client){
        clientDao.deleteClient(client);
    }

    public void deleteClientById(Long id){
        clientDao.deleteClientById(id);
    }

    public List<Client> getAllClients(){
        return clientDao.getAllClients();
    }
}
