package com.example.phonebook.service;

import com.example.phonebook.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact saveContact(Contact contact);

    Contact getContactById(Long id);

    Contact updateContact(Contact contact);

    void deleteContactById(Long id);

}
