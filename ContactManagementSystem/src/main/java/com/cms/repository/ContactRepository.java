package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.entiry.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
