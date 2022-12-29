let planificador = []

let nota1 = new nota("Nota Uno","Esta nota es la Primera nota del planificador",new Date())
let nota2 = new nota("Nota Dos","Esta nota es la Segunda nota del planificador",new Date())
let nota3 = new nota("Nota Tres","Esta nota es la Tercera nota del planificador",new Date())

nota1.agregarTarea(new Tarea("tarea 1"))
nota1.agregarTarea(new Tarea("tarea 2"))
nota1.agregarTarea(new tareaMultimedia("tarea Tres MUltimedia","./images/fichero.png"))
nota1.agregarTarea(new tareaTexto("tarea cuatro de Texto","Esto es un ejemplo de tarea de texto utilizando extension"))


nota2.agregarTarea(new tareaMultimedia("tarea uno MUltimedia","./images/fichero.png"))
nota2.agregarTarea(new Tarea("tarea Dos"))
nota2.agregarTarea(new tareaTexto("tarea Tres de Texto","Esto es un ejemplo de tarea de texto utilizando extension"))

nota3.agregarTarea(new Tarea("tarea UNo"))
nota3.agregarTarea(new tareaMultimedia("tarea dos MUltimedia","./images/fichero.png"))

planificador.push(nota1)
planificador.push(nota2)
planificador.push(nota3)

planificador.forEach((item)=>{
    item.listarTareas()
})