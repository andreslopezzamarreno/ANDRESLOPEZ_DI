import { Component } from '@angular/core';
import { AsignaturasService } from 'src/app/services/asignaturas.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'Practica-aniadir',
  templateUrl: './aniadir.component.html',
  styleUrls: ['./aniadir.component.css'],
})
export class AniadirComponent {
  asignaturas: any[] = [];
  datoComunicado = '';

  constructor(
    private servicioAsignatura: AsignaturasService,
    private gestorRutas: ActivatedRoute
  ) {
    this.asignaturas = servicioAsignatura.getAllAsignaturas();
    gestorRutas.params.subscribe((param) => {
      this.datoComunicado = param['ciclo'];
      this.asignaturas = this.servicioAsignatura.getAsignaturasFiltradas(
        this.datoComunicado
      );
    });
  }
}
