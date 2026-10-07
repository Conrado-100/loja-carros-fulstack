package br.org.edu.ifrn.LojaCarro.services;

import br.org.edu.ifrn.LojaCarro.dto.UsuarioRequestDTO;
import br.org.edu.ifrn.LojaCarro.dto.UsuarioResponseDTO;
import br.org.edu.ifrn.LojaCarro.model.Usuario;
import br.org.edu.ifrn.LojaCarro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LogService logService;

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));
        return new UsuarioResponseDTO(usuario);
    }

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setPerfil(dto.getPerfil());

        Usuario novo = usuarioRepository.save(usuario);
        logService.registrar("CRIAR_USUARIO", "Usuário criado: " + novo.getEmail());
        return new UsuarioResponseDTO(novo);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        if (dto.getSenha() != null && !dto.getSenha().isEmpty()) {
            usuario.setSenha(dto.getSenha());
        }
        usuario.setPerfil(dto.getPerfil());

        Usuario atualizado = usuarioRepository.save(usuario);
        logService.registrar("ATUALIZAR_USUARIO", "Usuário ID " + id + " atualizado.");
        return new UsuarioResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));
        usuarioRepository.deleteById(id);
        logService.registrar("DELETAR_USUARIO", "Usuário deletado: " + usuario.getEmail());
    }
}