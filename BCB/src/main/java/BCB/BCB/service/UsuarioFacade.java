package BCB.BCB.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.dtos.UsuarioDTO;
import BCB.BCB.model.Usuario;
import BCB.BCB.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioFacade {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioDTO criar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setAtivo(true);
        usuarioRepository.save(usuario);
        return usuarioDTO;
    }

    public UsuarioDTO atualizar (UsuarioDTO usuarioDTO, Long usuarioId) {        
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioDatabase = optionalUsuario.get();
            usuarioDatabase.setUsuario(usuarioDTO.getUsuario());
            usuarioDatabase.setSenha(usuarioDTO.getSenha());
            usuarioRepository.save(usuarioDatabase);
            return usuarioDTO;
        } else {
            throw new EntityNotFoundException("Cliente não encontrado com id: " + usuarioId);
        }
    }

    private UsuarioDTO converter (Usuario usuario){
        UsuarioDTO usuarioResult = new UsuarioDTO();
        usuarioResult.setId_usuario(usuario.getId_usuario());
        usuarioResult.setUsuario(usuario.getUsuario());
        usuarioResult.setSenha(usuario.getSenha());
        usuarioResult.setAtivo(usuario.isAtivo());
        return usuarioResult;
    }

    public List<UsuarioDTO> getAll() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());        
    }

    public String delete (Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
        return "DELETED";
    }

}
