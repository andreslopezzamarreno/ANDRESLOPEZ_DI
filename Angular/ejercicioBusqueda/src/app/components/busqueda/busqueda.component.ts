import { Component } from '@angular/core';

@Component({
  selector: 'busqueda-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css'],
})
export class BusquedaComponent {
  alumno = {
    nombre: '',
    apellido: '',
    edad: '',
    ciclo: '',
    estudios: '',
  };

  alumnos: any[] = [];

  estudioPasado = '';

  filtrando = false;
  filtro = 0;

  numAlumnosEncontrados = -1;

  aniadirAlumno(
    nombrePasado: string,
    apellidoPasado: string,
    edadPasado: string,
    cicloPasado: string
  ) {
    this.alumno = {
      nombre: nombrePasado,
      apellido: apellidoPasado,
      edad: edadPasado,
      ciclo: cicloPasado,
      estudios: this.estudioPasado,
    };

    this.alumnos.push(this.alumno);
  }

  pasarEstudio(estudio: any) {
    this.estudioPasado = estudio.target.value;
  }

  verfiltro(evento: any) {
    evento.target.value == 1 ? (this.filtro = 1) : (this.filtro = 2);
  }

  cambiarnumero(ciclo: string, estudios: string) {
    this.filtrando = true;
    if (this.filtro == 1) {
      this.numAlumnosEncontrados = this.alumnos.filter(
        (item) => item.ciclo === ciclo
      ).length;
    } else {
      this.numAlumnosEncontrados = this.alumnos.filter(
        (item) => item.estudios === estudios
      ).length;
    }
  }
}
