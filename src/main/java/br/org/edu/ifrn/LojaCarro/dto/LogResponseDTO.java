package br.org.edu.ifrn.LojaCarro.dto;

import br.org.edu.ifrn.LojaCarro.model.Log;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LogResponseDTO {
    private Long id;
    private String acao;
    private String detalhe;
    private LocalDateTime dataHora;

    public LogResponseDTO(Log log) {
        this.id = log.getId();
        this.acao = log.getAcao();
        this.detalhe = log.getDetalhe();
        this.dataHora = log.getDataHora();
    }
}