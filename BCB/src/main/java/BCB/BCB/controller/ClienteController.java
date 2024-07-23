package BCB.BCB.controller;

import org.springframework.web.bind.annotation.RestController;

import BCB.BCB.dtos.ClienteDTO;
import BCB.BCB.service.ClienteFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;



@RestController
@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)

public class ClienteController {
    @Autowired
    private ClienteFacade clienteFacade;

    @PostMapping
    @ResponseBody
    public ClienteDTO criar(@RequestBody ClienteDTO clienteDTO) {
        return clienteFacade.criar(clienteDTO);
    }

    @PutMapping("/{clienteId}")
    @ResponseBody
    public ClienteDTO atualizar (@PathVariable("clienteId") Long clienteId,
                                @RequestBody ClienteDTO clienteDTO){
        return clienteFacade.atualizar(clienteDTO, clienteId); 
    }

    @GetMapping
    @ResponseBody    
    public List<ClienteDTO> getAll() {
        return clienteFacade.getAll();
    }

    @DeleteMapping("/{clienteId}")
    @ResponseBody
    public String deletar(@PathVariable("clienteId") long clienteId){
        return clienteFacade.delete(clienteId);
    }
}
