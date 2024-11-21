package com.billing.stystem.controller;

import com.billing.stystem.entity.Category;
import com.billing.stystem.entity.Client;
import com.billing.stystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/add-client")
    public String addClient(Model model) {
        return "pages/add-client";
    }
    
    @PostMapping("/client/add")
    public String addClient(@ModelAttribute Client client) {
        clientService.addClient(client);
        return "redirect:/add-client";
    }
    
    @GetMapping("/client/all")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "pages/all-client";
    }
    
    @GetMapping("/client/edit/{clientId}")
    public String editCategory(@PathVariable Integer clientId, Model model) {
        model.addAttribute("client", clientService.getClientById(clientId));
        return "/pages/edit-client";
    }
    
    @PostMapping("/client/edit")
    public String editCategory(@ModelAttribute Client client) {
        clientService.updateClientById(client);
        return "redirect:/client/all";
    }
    
    @GetMapping("/client/delete/{clientId}")
    public String deleteCategory(@PathVariable Integer clientId) {
        clientService.deleteClientById(clientId);
        return "redirect:/client/all";
    }
    
}
