package com.example.phonebook.controller;

import com.example.phonebook.entity.Contact;
import com.example.phonebook.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public String listContacts(Model model){
        model.addAttribute("contacts", contactService.getAllContacts());
        return "contacts";
    }

    @GetMapping("/contacts/new")
    public String createContact(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "create_contact";
    }
    @PostMapping("/contacts")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/edit/{id}")
    public String editContacts(@PathVariable Long id, Model model){
        model.addAttribute("contact", contactService.getContactById(id));
        return "edit_student";

    }

    @PostMapping("/contacts/{id}")
    public String updateContact(@PathVariable Long id, @ModelAttribute("contact")
                                Contact contact, Model model) {
        Contact existingContact = contactService.getContactById(id);
        existingContact.setId(id);
        existingContact.setName(contact.getName());
        existingContact.setNumber(contact.getNumber());

        contactService.updateContact(existingContact);

        return "redirect:/contacts";
    }
    @GetMapping("/contacts/{id}")
    public String deleteContact(@PathVariable Long id){
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }
}
