package com.sat.webd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sat.webd.models.Contact;
import com.sat.webd.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact contact) {
        // Add any necessary business logic before saving the contact
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
