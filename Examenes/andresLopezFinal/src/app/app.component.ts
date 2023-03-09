import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'andresLopezFinal';

  constructor(private gestorRuta: Router) {}

  navegar(tipo: string) {
    this.gestorRuta.navigate(['vehiculo', tipo]);
  }
}
