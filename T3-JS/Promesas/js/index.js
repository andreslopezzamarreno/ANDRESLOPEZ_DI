/* let urlString = "https://dummyjson.com/products";

fetch(urlString)
  .then((res) => {
    //la respuesta hay que retornarla si se encadenan dos promesas
    return res.json();
  })
  .then((res1) => {
    console.log(res1);
    //sacar por consola la lista de productos (precio y nombre) del json
    res1.products.forEach((element) => {
      console.log(element.title);
      console.log(element.price);
    }); 
  })
  .catch((err) => {
    console.log("fetch resuelta sin exito");
  })
  .finally(() => {
    console.log("Fin de la evaluacion de la promesa");
  }); */

let urlStringCategorias = "https://dummyjson.com/products/categories";
let urlString = "https://dummyjson.com/products";

let select = document.querySelector("#categorias");
let boton = document.querySelector(".btn");
let grid = document.querySelector(".row");

fetch(urlStringCategorias)
  .then((res) => {
    return res.json();
  })
  .then((res1) => {
    //relleno el select
    res1.forEach((element) => {
      let nodoOption = document.createElement("option");
      nodoOption.innerText = element;
      nodoOption.value = element;
      select.append(nodoOption);
    });

    //hago fetch para leer  los productos
    fetch(urlString)
      .then((res) => {
        return res.json();
      })
      .then((res1) => {
        //escucho la pulsacion del boton
        boton.addEventListener("click", () => {
          grid.innerHTML = "";
          let seleccionado = select.value;

          //recorro productos y pongo en pantalla los que coinciden en categoria
          res1.products.forEach((element) => {
            if (seleccionado == element.category) {
              let cosas =
                grid.innerHTML +
                `<div class="card m-4 " style="width: 18rem">
                  <img src=${element.thumbnail} class="card-img-top" alt="...">
                  <div class="card-body">
                    <h5 class="card-title">${element.title}</h5>
                    <p class="card-text">${element.description}</p>
                    <p class="card-text">${element.price}</p>
                  </div>
                </div>`;
              grid.innerHTML = cosas;
            }
          });
        });
      })
      .catch((err) => {
        console.log("fetch resuelta sin exito");
      });
  })
  .catch((err) => {
    console.log("fetch resuelta sin exito");
  });
