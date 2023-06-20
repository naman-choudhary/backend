package com.sat.webd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sat.webd.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // You can add custom query methods or override existing ones if needed
}
