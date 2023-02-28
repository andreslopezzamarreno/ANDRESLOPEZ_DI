import { Injectable } from '@angular/core';
import { Asignatura } from '../model/asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  //

  private asignaturas: Asignatura[] = [
    {
      nombre: 'base de Datos',
      siglas: 'BD',
      curso: 1,
      ciclo: 'Dam',
      imagen:
        'https://www.tecnologia-informatica.com/wp-content/uploads/2018/08/que-es-un-programa-computacion-1.jpeg',
      conocimientos: ['sql', 'xml'],
      profesor: 'Edu',
    },
    {
      nombre: 'programacion',
      siglas: 'PRO',
      curso: 1,
      ciclo: 'Dam',
      imagen:
        'https://educacion30.b-cdn.net/wp-content/uploads/2019/01/Apertura-978x652.jpg',
      conocimientos: ['java', 'intelliJ'],
      profesor: 'Borja',
    },
    {
      nombre: 'lenguaje de marcas',
      siglas: 'LENG',
      curso: 1,
      ciclo: 'Dam',
      imagen:
        'https://www.tecnologia-informatica.com/wp-content/uploads/2018/07/programas-crear-programas-1-1.jpeg',
      conocimientos: ['CSS', 'HTML', 'bootstrap'],
      profesor: 'Edu',
    },
    {
      nombre: 'Programacion multimedia',
      siglas: 'PMDM',
      curso: 2,
      ciclo: 'Dam',
      imagen:
        'https://ceprud.ugr.es/sites/centros/ceprud/public/imagenes/landing/2020-10/disen%CC%83o%20del%20programa.jpg',
      conocimientos: ['kotlin', 'android estudio'],
      profesor: 'Borja',
    },
    {
      nombre: 'Acceso a datos',
      siglas: 'AD',
      curso: 2,
      ciclo: 'Dam',
      imagen:
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCg_aJboJKjVwfKw6bUZUjVT3uxk16qWfrCw&usqp=CAU',
      conocimientos: ['python', 'grafos', 'sql'],
      profesor: 'Luismi',
    },
    {
      nombre: 'Desarrollo interfaces',
      siglas: 'DI',
      curso: 2,
      ciclo: 'Dam',
      imagen:
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwE25zq5VkNNWXSWwNmOc__YrP2otyWi_Uvg&usqp=CAU',
      conocimientos: ['javaFX'],
      profesor: 'Borja',
    },
    {
      nombre: 'Desarrollo interfaces',
      siglas: 'DI',
      curso: 2,
      ciclo: 'Dam',
      imagen: '',
      conocimientos: ['javaFX'],
      profesor: 'Borja',
    },
  ];

  constructor() {}

  getAsignaturasFiltradas(condicion: Number): Asignatura[] {
    if (condicion == 1 || condicion == 2) {
      return this.asignaturas.filter((item) => (item.curso = condicion));
    } else {
      return this.asignaturas;
    }
  }

  getAllAsignaturas(): Asignatura[] {
    return this.asignaturas;
  }
}
