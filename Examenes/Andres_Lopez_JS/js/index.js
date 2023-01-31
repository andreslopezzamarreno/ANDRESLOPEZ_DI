let urlMonedas = "https://run.mocky.io/v3/16f71bfa-7bee-476f-ab6b-71348547a9d3";
let urlDetalle = "https://api.coingecko.com/api/v3/coins/";
let select = document.querySelector("select");
let boton = document.querySelector(".aniadir");
fetch(urlMonedas)
  .then((res) => {
    return res.json();
  })
  .then((res2) => {
    res2.forEach((element) => {
      let nodo = document.createElement("option");
      nodo.innerText = element.name;
      nodo.value = element.id;
      select.append(nodo);
    });

    select.addEventListener("change", () => {
      console.log("cambio");
      let carta = document.querySelector(".moneda");
      let urlDetalles = urlDetalle + select.value;
      fetch(urlDetalles)
        .then((res) => {
          return res.json();
        })
        .then((res) => {
          console.log();
          carta.innerHTML = `
        <div class="card" style="width: 18rem">
          <div class="card-body" id="carta">
                <h5 class="card-title">${res.name}</h5>
                <p class="card-text">${res.description.en}</p>
                <ul class="list-group">
                <li class="list-group-item">${res.categories}</li>
                </ul>
                <a href=${urlDetalles} class="btn btn-primary">ver detalle</a>
            </div>
        </div>`;
        });
      /*let divmoneda = document.querySelector(".moneda");
      let nodoBoton = document.createElement("button");
      nodoBoton.textContent = "Añadir a favoritos";
      nodoBoton.className = "btn btn-primary";
      divmoneda.append(nodoBoton);
      console.log(divmoneda);*/
    });
  })
  .catch((rej) => {
    console.log("Error");
  });
