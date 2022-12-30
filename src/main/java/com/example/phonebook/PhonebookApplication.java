package com.example.phonebook;

import com.example.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhonebookApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PhonebookApplication.class, args);
    }

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public void run(String... args) throws Exception {
    }
}
