package com.billing.stystem.repository;

import com.billing.stystem.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Optional<Client> findByMobile(String mobile);
}
