import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioService, UsuarioRequest, UsuarioResponse } from '../../services/usuario';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './usuario.html',
  styleUrl: './usuario.css'
})
export class UsuarioComponent implements OnInit {
 

  usuarios: UsuarioResponse[] = [];
  novoUsuario: UsuarioRequest = { nome: '', email: '', senha: '', perfil: 'USER' };

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.carregarUsuarios();
  }

  carregarUsuarios(): void {
    this.usuarioService.listar().subscribe({
      next: (dados) => this.usuarios = dados,
      error: (err) => console.error('Erro ao carregar usuários:', err)
    });
  }

  salvar(): void {
    if (!this.novoUsuario.nome || !this.novoUsuario.email) return;

    this.usuarioService.salvar(this.novoUsuario).subscribe({
      next: () => {
        this.novoUsuario = { nome: '', email: '', senha: '', perfil: 'USER' };
        this.carregarUsuarios();
      },
      error: (err) => console.error('Erro ao salvar usuário:', err)
    });
  }

  deletar(id: number): void {
    if (confirm('Deseja excluir este usuário?')) {
      this.usuarioService.deletar(id).subscribe({
        next: () => this.carregarUsuarios(),
        error: (err) => console.error('Erro ao excluir usuário:', err)
      });
    }
  }
}