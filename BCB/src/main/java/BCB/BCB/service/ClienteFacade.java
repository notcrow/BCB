package BCB.BCB.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.dtos.ClienteDTO;
import BCB.BCB.model.Cliente;
import BCB.BCB.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class ClienteFacade {
    @Autowired
    private ClienteRepository repository;

    public ClienteDTO criar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setCPF_pessoa(clienteDTO.getCPF_pessoa());
        cliente.setCNPJ(clienteDTO.getCNPJ());
        cliente.setEmpresa(clienteDTO.getEmpresa());
        cliente.setTipo_plano(clienteDTO.getTipo_plano());
        repository.save(cliente);
        clienteDTO.setId(cliente.getId());
        return clienteDTO;
    }
    
    public ClienteDTO atualizar (ClienteDTO clienteDTO, Long clienteId) {        
        Optional<Cliente> optionalCliente = repository.findById(clienteId);
        if (optionalCliente.isPresent()) {
            Cliente clienteDatabase = optionalCliente.get();
            clienteDatabase.setNome(clienteDTO.getNome());
            clienteDatabase.setEmail(clienteDTO.getEmail());
            clienteDatabase.setTelefone(clienteDTO.getTelefone());
            clienteDatabase.setCPF_pessoa(clienteDTO.getCPF_pessoa());
            clienteDatabase.setCNPJ(clienteDTO.getCNPJ());
            clienteDatabase.setEmpresa(clienteDTO.getEmpresa());
            clienteDatabase.setTipo_plano(clienteDTO.getTipo_plano());
            repository.save(clienteDatabase);
            return clienteDTO;
        } else {
            throw new EntityNotFoundException("Cliente não encontrado com id: " + clienteId);
        }
    }

    private ClienteDTO converter (Cliente cliente) {
        ClienteDTO result = new ClienteDTO();
        result.setId(cliente.getId());
        result.setNome(cliente.getNome());
        result.setEmail(cliente.getEmail());
        result.setTelefone(cliente.getTelefone());
        result.setCPF_pessoa(cliente.getCPF_pessoa());
        result.setCNPJ(cliente.getCNPJ());
        result.setEmpresa(cliente.getEmpresa());
        result.setTipo_plano(cliente.getTipo_plano());
        return result;
    }

    public List<ClienteDTO> getAll() {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());        
    }

    public String delete (Long Id) {
        repository.deleteById(Id);
        return "DELETED";
    }
}
