import { Component } from '@angular/core';
import { UsuarioComponent } from './components/usuario/usuario';
import { LogComponent } from './components/log/log';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [UsuarioComponent, LogComponent],
  templateUrl: './app.html'
})
export class App {}