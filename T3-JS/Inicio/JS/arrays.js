let jugadores = [];

//agrega datos al final del array y obtengo la nueva longitud
jugadores.push("jugador 1","jugador 2", "jugador 3");


//agrega datos al principio del array y obtengo la nueva longitud
jugadores.unshift("jugador nuevo", "Otro jugador");

/* 
//borra datos
//eliminar ultimo elemento de la lista y lo retorna
console.log(`Elemento borrado es ${jugadores.pop()}`);

//eliminar ultimo elemento de la lista y lo retorna
console.log(`Elemento borrado es ${jugadores.shift()}`); */

/* //filtrar por una condicion indicada
let arrayResultante = []
for (let index = 0; index < jugadores.length; index++) {
    if(!jugadores[index].includes("2")){
        arrayResultante.push(jugadores[index]);
    }
} */

//filtrar por metodo filter
jugadores = jugadores.filter((item) => !item.includes("2"))

console.log(jugadores);
