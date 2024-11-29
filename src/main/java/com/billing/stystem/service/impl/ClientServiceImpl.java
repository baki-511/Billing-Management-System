package com.billing.stystem.service.impl;

import com.billing.stystem.entity.Client;
import com.billing.stystem.exception.CategoryNotFoundException;
import com.billing.stystem.exception.ClientNotFoundException;
import com.billing.stystem.repository.ClientRepository;
import com.billing.stystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
    
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    @Override
    public Client getClientById(Integer clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new CategoryNotFoundException(clientId));
    }
    
    @Override
    public String deleteClientById(Integer clientId) {
        Client clientById = getClientById(clientId);
        clientRepository.delete(clientById);
        return "Client Deleted Successfully!";
    }
    
    @Override
    public Client updateClientById(Client client) {
        Client clientById = getClientById(client.getClientId());
        return clientRepository.save(client);
    }
    
    @Override
    public Client getClientByMobile(String mob) {
        return clientRepository.findByMobile(mob)
                .orElseThrow(ClientNotFoundException::new);
    }
}
