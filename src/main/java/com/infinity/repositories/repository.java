package com.infinity.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.entity.Contact;

@Repository
public interface repository extends JpaRepository<Contact, Serializable>{

}
