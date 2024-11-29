package com.billing.stystem.service;

import com.billing.stystem.entity.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(Client client);
    
    public List<Client> getAllClients();
    
    public Client getClientById(Integer clientId);
    
    public String deleteClientById(Integer clientId);
    
    public Client updateClientById(Client client);
    
    public Client getClientByMobile(String mob);
}
