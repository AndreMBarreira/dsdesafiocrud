package com.devsuperior.dsdesafiocrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsdesafiocrud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
