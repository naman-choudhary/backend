package com.sat.webd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sat.webd.models.Contact;
import com.sat.webd.services.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.createContact(contact);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}