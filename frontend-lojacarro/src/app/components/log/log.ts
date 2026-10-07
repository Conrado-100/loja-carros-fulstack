import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogService, LogResponse } from '../../services/log';

@Component({
  selector: 'app-log',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './log.html',
  styleUrl: './log.css'
})
export class LogComponent implements OnInit {
  logs: LogResponse[] = [];

  constructor(private logService: LogService) {}

  ngOnInit(): void {
    this.carregarLogs();
  }

  carregarLogs(): void {
    this.logService.listar().subscribe({
      next: (dados) => this.logs = dados,
      error: (err) => console.error('Erro ao carregar logs:', err)
    });
  }
}