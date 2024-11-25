package com.billing.stystem;

import com.billing.stystem.entity.AdminUser;
import com.billing.stystem.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BillingManagementSystemApplication implements CommandLineRunner {
    @Autowired
    AdminUserRepository adminRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public static void main(String[] args) {
        SpringApplication.run(BillingManagementSystemApplication.class, args);
        System.out.println("Application is Running...");
    }
    
    @Override
    public void run(String... args) throws Exception {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("navin@gmail.com");
        adminUser.setFullName("Navin Sharma");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.setRole("ADMIN");
//        adminRepository.save(adminUser);
    }
}
