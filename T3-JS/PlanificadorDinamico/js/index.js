let planificador = {
  notas: [
    {
      fecha: new Date(),
      titulo: "Nota1",
      Descripcion: "descripcion 1",
      completa: false,
      tareas: [
        { titulo: "titulo n1 nota 1", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 1", completa: true, fichero: "./ejemplo" },
      ],
    },
    {
      fecha: new Date(),
      titulo: "Nota2",
      Descripcion: "descripcion 2",
      completa: false,
      tareas: [
        { titulo: "titulo n1 nota 2", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 2", completa: true, fichero: "./ejemplo" },
      ],
    },
    {
      fecha: new Date(),
      titulo: "Nota3",
      Descripcion: "descripcion 3",
      completa: false,
      tareas: [
        { titulo: "titulo n1 nota 3", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 3", completa: true, fichero: "./ejemplo" },
      ],
    },
    {
      fecha: new Date(),
      titulo: "Nota4",
      Descripcion: "descripcion 4",
      completa: false,
      tareas: [
        { titulo: "titulo n1 nota 4", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 4", completa: true, fichero: "./ejemplo" },
      ],
    },
    {
      fecha: new Date(),
      titulo: "Nota5",
      Descripcion: "descripcion 5",
      completa: false,
      tareas: [
        { titulo: "titulo n1 nota 5", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 5", completa: true, fichero: "./ejemplo" },
      ],
    },
    {
      fecha: new Date(),
      titulo: "Nota6",
      Descripcion: "descripcion 6",
      completa: false,
      tareas: [
        { titulo: "titulo n1 nota 6", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 6", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 6", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2 nota 6", completa: true, fichero: "./ejemplo" },
      ],
    },
  ],
  cantidad: 4,
};

function ponerNotas(notas) {
  let grid = document.querySelector(".row");

  notas.forEach((element) => {
    let listaHTML =
      grid.innerHTML +
      `<div class="card m-2" style="width: 18rem">
          <div class="card-body">
            <h3 class="card-title">${element.titulo}</h3>
            <h6 class="card-date">${element.fecha}</h6>
            <p class="card-text">${element.Descripcion}</p>
            <p class="card-text">completa: ${element.completa}</p>
            <ul id = ${element.titulo}></ul>
          </div>
        </div>`;
    grid.innerHTML = listaHTML;

    let lista2 = document.querySelectorAll("ul");

    element.tareas.forEach((tarea) => {
      let nodoLI = document.createElement("li");
      nodoLI.innerText = tarea.titulo;
      lista2[lista2.length - 1].append(nodoLI);
    });
  });
}

ponerNotas(planificador.notas);
