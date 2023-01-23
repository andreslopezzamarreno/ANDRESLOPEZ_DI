//trabajr con etiquetas
//trabajar con class 
// trabajar con id
/*
// elemento por id --> unico
let elementPorId= document.getElementById("lista")
console.log(elementPorId);
// elemento con etiqueta --> lista(HTML ELEMENT lista)
let elementoPorTag = document.getElementsByTagName("li")
console.log(elementoPorTag);
//elemento que tenga class --> unico
let elementoPorClass = document.getElementsByClassName("m-4")
console.log(elementoPorClass);

//#id .class tag

//-->elemento único-->primer elemento -->Node
let elementoquery = document.querySelector("#lista1")

console.log(elementoquery);

// -->elemento multiple --> todos los elementos --> NodeList
let elementosquery = document.querySelectorAll("#lista1 li")
console.log(elementosquery);

let elementosquery2 = document.querySelectorAll("ul.clase1")
console.log(elementosquery2);

let elementoListaDos = document.querySelectorAll(".clase2 li")
elementoListaDos.forEach(element => console.log(element.textContent))
*/

// agregar
/* let elementoLista = document.querySelector("ul.clase2");
// 1 - crear un li
let nodoLI = document.createElement("li");
// 2 - personalizar li (agregar las clases y poner el contenido - tipo texto)
// nodoLI.className = "list-group-item";
//nodoLI.className = "elemento1";
nodoLI.classList.add("list-group-item");
nodoLI.classList.add("elemento1");
nodoLI.innerText = "Elemento 66";
// 3 - agregar el li al ul (encontrado!)
elementoLista.append(nodoLI); */

/* let elementoLista = document.querySelector("ul.clase2");
let listaHTML =
  elementoLista.innerHTML +
  `<li class="list-group-item elemento1">Elemento 66</li>`;
elementoLista.innerHTML = listaHTML; */

// borrar
/* let elementoLista = document.querySelector("ul.clase2");
let nodoLIBuscado = document.querySelector(".elemento3");
elementoLista.removeChild(nodoLIBuscado); */

/*let elementoLista = document.querySelector("ul.clase2");
document.querySelector("#boton_add").addEventListener("click", () => {
  let listaHTML =
    elementoLista.innerHTML +
    `<li class="list-group-item elemento1">Elemento Nuevo</li>`;

  elementoLista.innerHTML = listaHTML;
});*/


document.querySelector("#boton_add").addEventListener("click", () => {
    let lista;
    let listaSeleccionada = document.querySelector("select")

    if (listaSeleccionada.value == 1){
      lista = document.querySelector("ul.clase1");
    }else{
      lista = document.querySelector("ul.clase2");
    }

    let nodoLI = document.createElement("li")
    nodoLI.classList.add("list-group-item")
    nodoLI.classList.add("elemento1")
    nodoLI.innerText = document.querySelector("#text").value
    lista.append(nodoLI);

    document.querySelector("#text").value = ""
});


