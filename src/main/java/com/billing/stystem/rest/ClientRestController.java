package com.billing.stystem.rest;

import com.billing.stystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/client")
public class ClientRestController {
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer id) {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }
    
    @GetMapping("/mob/{mob}")
    public ResponseEntity<?> getClientByMobile(@PathVariable String mob) {
        return new ResponseEntity<>(clientService.getClientByMobile(mob), HttpStatus.OK);
    }
}

