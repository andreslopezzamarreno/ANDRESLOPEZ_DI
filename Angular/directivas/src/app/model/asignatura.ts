//modelo

/* class Asignatura {

  constructor(
    private nombre: string,
    private siglas: string,
    private ciclo: string,
    private curso: Number,
    private profesor: string,
    private conocimientos: []
  ) {

  }
} */

export interface Asignatura {
  nombre: string;
  siglas: string;
  curso: Number;
  ciclo: string;
  imagen: string;
  conocimientos: string[];
  profesor: string;
}
