package BCB.BCB.controller;

import org.springframework.web.bind.annotation.RestController;

import BCB.BCB.dtos.UsuarioDTO;
import BCB.BCB.service.UsuarioFacade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)

public class UsuarioController {
    @Autowired
    private UsuarioFacade usuarioFacade;

    @PostMapping
    @ResponseBody
    public UsuarioDTO criar(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioFacade.criar(usuarioDTO);
    }
    
    @PutMapping("/{usuarioId}")
    @ResponseBody
    public UsuarioDTO atualizar (@PathVariable("usuarioId") Long usuarioId,
                                @RequestBody UsuarioDTO usuarioDTO){
        return usuarioFacade.atualizar(usuarioDTO, usuarioId); 
    }

    @GetMapping
    @ResponseBody    
    public List<UsuarioDTO> getAll() {
        return usuarioFacade.getAll();
    }

    @DeleteMapping("/{usuarioId}")
    @ResponseBody
    public String deletar(@PathVariable("usuarioId") long usuarioId){
        return usuarioFacade.delete(usuarioId);
    }

}
