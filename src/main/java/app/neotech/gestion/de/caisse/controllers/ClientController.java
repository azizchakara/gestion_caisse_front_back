package app.neotech.gestion.de.caisse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.neotech.gestion.de.caisse.services.ClientService;
import app.neotech.gestion.de.caisse.shared.dto.ClientDto;

@RestController
@RequestMapping("/clients")

public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping(path = "/{id}")

	public ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
		ClientDto clientDto = clientService.getClientById(id);
		return new ResponseEntity<ClientDto>(clientDto,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
		ClientDto createClient = clientService.createClient(clientDto);
		return new ResponseEntity<ClientDto>(createClient,HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
		ClientDto updateClient = clientService.updateClient(id, clientDto);
		return new ResponseEntity<ClientDto>(updateClient,HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
