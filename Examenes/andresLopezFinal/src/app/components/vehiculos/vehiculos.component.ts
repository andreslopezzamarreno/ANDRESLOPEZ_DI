import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { BuscadorService } from 'src/app/services/buscador.service';
import { Coche } from 'src/app/model/coche';
@Component({
  selector: 'app-vehiculos',
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css'],
})
export class VehiculosComponent {
  tipoPasado: string = '';

  coches: Coche[] = [];

  constructor(
    private servicioCoche: BuscadorService,
    private router: ActivatedRoute
  ) {
    router.params.subscribe((param) => {
      this.tipoPasado = param['tipo'];
      this.coches = this.servicioCoche.filtrarCochesServicio(this.tipoPasado);
    });
  }
}
