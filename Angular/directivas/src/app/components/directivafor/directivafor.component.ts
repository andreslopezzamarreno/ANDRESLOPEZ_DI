import { Component } from '@angular/core';
import { AsignaturasService } from 'src/app/services/asignaturas.service';

@Component({
  selector: 'directivas-directivafor',
  templateUrl: './directivafor.component.html',
  styleUrls: ['./directivafor.component.css'],
})
export class DirectivaforComponent {
  elementos: string[] = ['Elemento 1'];

  aniadirElemento(dato: string) {
    this.elementos.push(dato);
  }

  asignaturas: any[] = [];

  constructor(private servicioAsignatura: AsignaturasService) {
    this.asignaturas = servicioAsignatura.getAllAsignaturas();
  }

  filtro(evento: any) {
    let curso = evento.target.velue;
    console.log(curso);

    this.asignaturas = this.servicioAsignatura.getAsignaturasFiltradas(curso);
  }
}
