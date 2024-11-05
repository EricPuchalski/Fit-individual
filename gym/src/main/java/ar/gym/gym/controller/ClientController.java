package ar.gym.gym.controller;

import ar.gym.gym.dto.request.ClientRequestDto;
import ar.gym.gym.dto.response.ClientResponseDto;
import ar.gym.gym.model.Client;
import ar.gym.gym.service.ClientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientResponseDto> create(@Validated @RequestBody ClientRequestDto clientRequestDto) {
        logger.info("Creating a new client: {}", clientRequestDto);
        ClientResponseDto createdClient = clientService.create(clientRequestDto);
        logger.info("Client created successfully: {}", createdClient);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ClientResponseDto>> findAll() {
        logger.info("Fetching all clients");
        List<ClientResponseDto> clients = clientService.findAll();
        logger.info("Retrieved {} clients", clients.size());
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{dni}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientResponseDto> findByDni(@PathVariable String dni) {
        logger.info("Fetching client with DNI: {}", dni);
        ClientResponseDto client = clientService.findByDni(dni);
        logger.info("Client retrieved: {}", client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientResponseDto> update(@Valid @RequestBody ClientRequestDto clientRequestDto, @PathVariable Long id) {
        logger.info("Updating client with ID: {}", id);
        ClientResponseDto updatedClient = clientService.update(clientRequestDto, id);
        logger.info("Client updated successfully: {}", updatedClient);
        return ResponseEntity.ok(updatedClient);
    }

    @PutMapping("/disable/{dni}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> disable(@PathVariable String dni) {
        logger.info("Disabling client with DNI: {}", dni);
        clientService.disableClientByDni(dni);
        logger.info("Client with DNI {} has been disabled", dni);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{dni}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable String dni) {
        logger.info("Deleting client with DNI: {}", dni);
        clientService.delete(dni);
        logger.info("Client with DNI {} has been deleted", dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-trainer/{email}")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    public ResponseEntity<List<ClientResponseDto>> getClientsByTrainerEmail(@PathVariable String email) {
        List<ClientResponseDto> clients = clientService.getClientsByTrainerEmail(email);
        return ResponseEntity.ok(clients);
    }

}
