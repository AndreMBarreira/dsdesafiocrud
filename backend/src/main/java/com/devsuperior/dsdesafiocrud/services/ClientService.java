package com.devsuperior.dsdesafiocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsdesafiocrud.entities.Client;
import com.devsuperior.dsdesafiocrud.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired()
	private ClientRepository repository;

	public List<Client> findAll() {
		return repository.findAll();
	}

}
