package br.org.edu.ifrn.LojaCarro.controllers;

import br.org.edu.ifrn.LojaCarro.dto.LogResponseDTO;
import br.org.edu.ifrn.LojaCarro.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "*")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public List<LogResponseDTO> listar() {
        return logService.listarTodos();
    }
}