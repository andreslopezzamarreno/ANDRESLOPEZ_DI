import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'Practica-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'practicaExamen';

  constructor(private gestorRutas: Router) {}

  navegarComponente(dato: string) {
    this.gestorRutas.navigate(['cursos', dato]);
  }
}
