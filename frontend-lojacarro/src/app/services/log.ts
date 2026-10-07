import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface LogResponse {
  id: number;
  acao: string;
  dataHora: string;
  detalhes: string;
}

@Injectable({
  providedIn: 'root'
})
export class LogService {
  private apiUrl = 'http://localhost:8080/logs';

  constructor(private http: HttpClient) {}

  listar(): Observable<LogResponse[]> {
    return this.http.get<LogResponse[]>(this.apiUrl);
  }
}