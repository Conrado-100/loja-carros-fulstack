package br.org.edu.ifrn.LojaCarro.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String acao; // Ex: "CRIAR_USUARIO", "DELETAR_CARRO"

    @Column(length = 1000)
    private String detalhe;

    private LocalDateTime dataHora = LocalDateTime.now();

    public Log(String acao, String detalhe) {
        this.acao = acao;
        this.detalhe = detalhe;
        this.dataHora = LocalDateTime.now();
    }
}