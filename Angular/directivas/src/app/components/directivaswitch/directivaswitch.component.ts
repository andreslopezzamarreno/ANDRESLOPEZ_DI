import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaswitch',
  templateUrl: './directivaswitch.component.html',
  styleUrls: ['./directivaswitch.component.css'],
})
export class DirectivaswitchComponent {
  opcion = 0;

  seleccionRadio(event: any) {
    this.opcion = event.target.value;
  }
}
