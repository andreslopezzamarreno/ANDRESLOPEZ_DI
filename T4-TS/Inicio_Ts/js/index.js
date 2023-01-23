console.log("Declaracion de variables");
//let var const
/*let nombre: String  = "Andrés"
let edad: Number = 22
let asignaturas: Array<String> = ["Prorgramacion","Desarrollo Interfaces", "Programacion Multimedia"]
*/
var profesor = {
    nombre: "Borja",
    apellido: "Martin",
    asignaturas: [
        { nombre: "Programacion ", horas: 8 },
        { nombre: "Desarrollo interfaces", horas: 6 }
    ]
};
var profesor2 = {
    nombre: "jesus",
    apellido: "Niño",
    asignaturas: [
        { nombre: "Servicios y procesos", horas: 4 },
        { nombre: "Entornos de desarrollo", horas: 3 },
    ]
};
/*
hacer una funcion que pida por parametro un array de cualquier cosa(any)
y muestre por consola el nombre de las asignaturas
*/
function mostrarAsignaturas(asignaturas) {
    asignaturas.forEach(function (element) {
        console.log(element.nombre);
    });
}
mostrarAsignaturas(profesor.asignaturas);
