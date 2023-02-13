import { Component } from '@angular/core';

@Component({
  selector: 'directivas-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent {
  alumno = {
    nombre: "",
    apellido:"",
    estudios: "",
    ciclo: "",
    experiencia: false,
  }

  urlImagen = "https://cas-training.com/wp-content/uploads/2020/09/angular-todo-lo-que-necesitas-saber.png"

  pulsacionBotonInicial(nombre:string,apellido:string,estudios:string,ciclo:any,experiencia:any) {
   // console.log(`Nombre pasado: ${nombre}, Nombre pasado: ${edad}`);
    //this.alumno.nombre = nombre
    this.alumno.nombre = nombre
    this.alumno.apellido = apellido
    this.alumno.estudios = estudios
    this.alumno.ciclo= ciclo
    this.alumno.experiencia = experiencia

    ;

  }
}
