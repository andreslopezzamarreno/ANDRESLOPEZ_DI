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

  estudios2 = ""
  experienciaCapturada = false


  urlImagen = "https://cas-training.com/wp-content/uploads/2020/09/angular-todo-lo-que-necesitas-saber.png"

  pulsacionBotonInicial(nombre:string,apellido:string,estudios:string) {
   // console.log(`Nombre pasado: ${nombre}, Nombre pasado: ${edad}`);
    //this.alumno.nombre = nombre
    this.alumno.nombre = nombre
    this.alumno.apellido = apellido
    this.alumno.estudios = this.estudios2
    this.alumno.ciclo = estudios
    this.alumno.experiencia = this.experienciaCapturada;

  }

  capturaCambioRadio(formacion:string){
    this.estudios2 = formacion

  }

  capturarExperiencia(experiencia:boolean){
    this.experienciaCapturada = experiencia
  }

  capturaEvento(evento:any){

  }
}
