package br.org.edu.ifrn.LojaCarro.services;

import br.org.edu.ifrn.LojaCarro.dto.LogResponseDTO;
import br.org.edu.ifrn.LojaCarro.model.Log;
import br.org.edu.ifrn.LojaCarro.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void registrar(String acao, String detalhe) {
        Log log = new Log(acao, detalhe);
        logRepository.save(log);
    }

    public List<LogResponseDTO> listarTodos() {
        return logRepository.findAll()
                .stream()
                .map(LogResponseDTO::new)
                .collect(Collectors.toList());
    }
}