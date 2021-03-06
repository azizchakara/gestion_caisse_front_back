package app.neotech.gestion.de.caisse.services;

import app.neotech.gestion.de.caisse.shared.dto.ClientDto;

public interface ClientService {
	
	ClientDto createClient(ClientDto clientDto);
	ClientDto getClientById(Long id);
	ClientDto updateClient(Long id,ClientDto clientDto);
	void deleteClient(Long id);
}
