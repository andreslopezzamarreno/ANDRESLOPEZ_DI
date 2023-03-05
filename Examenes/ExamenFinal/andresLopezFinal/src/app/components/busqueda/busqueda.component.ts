import { Component } from '@angular/core';
import { Coche } from 'src/app/model/coche';
import { BuscadorService } from 'src/app/services/buscador.service';
@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css'],
})
export class BusquedaComponent {
  coches: Coche[] = [];

  filtrado = false;
  constructor(private servicioCoche: BuscadorService) {}

  filtarBusqueda(marca: string, cv: string) {
    if (marca == '' || cv == '') {
      this.coches = [];
      this.filtrado = false;
    } else {
      this.coches = this.servicioCoche.filtrarCochesBusqueda(marca, Number(cv));
      if (this.coches.length != 0) {
        this.filtrado = true;
      } else {
        this.filtrado = false;
      }
    }
  }
}
