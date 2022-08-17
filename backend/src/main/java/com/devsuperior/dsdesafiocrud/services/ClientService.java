package com.devsuperior.dsdesafiocrud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdesafiocrud.dto.ClientDTO;
import com.devsuperior.dsdesafiocrud.entities.Client;
import com.devsuperior.dsdesafiocrud.repositories.ClientRepository;
import com.devsuperior.dsdesafiocrud.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired()
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();

		// List<ClientDTO> listDto = new ArrayList<>();
		// for (Client client : list) {
		// listDto.add(new ClientDTO (client));
		// }
		// return listDto;
		// expressao lambda que resume todo comentado...
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
		return new ClientDTO(entity);
	}

}