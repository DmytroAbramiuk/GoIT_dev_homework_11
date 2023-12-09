package org.example.service;

import org.example.crudServices.client.ClientDaoImpl;
import org.example.entity.Client;

import java.util.List;

public class ClientService {
    private final ClientDaoImpl clientDao = new ClientDaoImpl();

    public void saveClient(Client client){
        clientDao.save(client);
    }

    public Client findClientById(Long id){
        return clientDao.findById(id);
    }

    public void updateClient(Client client){
        clientDao.update(client);
    }

    public void deleteClient(Client client){
        clientDao.delete(client);
    }

    public void deleteClientById(Long id){
        clientDao.deleteById(id);
    }

    public List<Client> getAllClients(){
        return clientDao.getAll();
    }
}
