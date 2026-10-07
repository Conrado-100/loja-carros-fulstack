package br.org.edu.ifrn.LojaCarro.dto;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private String perfil;
}