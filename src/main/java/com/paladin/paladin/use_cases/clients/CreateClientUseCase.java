package com.paladin.paladin.use_cases.clients;

import com.paladin.paladin.adapters.Encryptor;
import com.paladin.paladin.dtos.clients.CreateClientDTO;
import com.paladin.paladin.entities.Client;
import com.paladin.paladin.exceptions.ClientAlreadyExists;
import com.paladin.paladin.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase {
    final ClientRepository clientRepository;
    final Encryptor encryptor;

    public CreateClientUseCase(ClientRepository clientRepository, Encryptor encryptor) {
        this.clientRepository = clientRepository;
        this.encryptor = encryptor;
    }

    public Client execute(CreateClientDTO dto) throws ClientAlreadyExists {
        String username = dto.getUsername();
        String password = dto.getPassword();

        this.alreadyExistsValidation(username);

        String encryptedPassword = this.encryptor.encrypt(password);
        dto.setPassword(encryptedPassword);

        Client client = this.createClient(dto);
        clientRepository.save(client);

        return client;
    }

    private Client createClient(CreateClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    private void alreadyExistsValidation(String username) throws ClientAlreadyExists {
        boolean alreadyExists = clientRepository.existsByUsername(username);
        if (alreadyExists) {throw new ClientAlreadyExists(null, null,null);}
    }
}
