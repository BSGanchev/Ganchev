package com.example.phonebook.repository;

import com.example.phonebook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {
}
