import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaif',
  templateUrl: './directivaif.component.html',
  styleUrls: ['./directivaif.component.css']
})
export class DirectivaifComponent {

  mostrarElemento = false

  cambiarCondicion(){
    this.mostrarElemento = !this.mostrarElemento
  }

  comprobarEstado(nombre:string){
    nombre === 'andres' ? this.mostrarElemento = true : this.mostrarElemento = false
  }
}
