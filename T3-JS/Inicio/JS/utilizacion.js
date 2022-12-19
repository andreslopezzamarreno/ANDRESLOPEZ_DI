let objeto = new ClaseEjemplo("p1","p2",["p3"])

objeto.mostrarDatos()

class Tarea{

    titulo
    completa

    constructor(titulo){
        this.titulo = titulo
        this.completa = false
    }

    set setCompleta(boolean){
        this.completa = boolean
    }
}

class nota{
    titulo
    descripcion
    tareas
    fecha
    completa


    constructor(titulo,descripcion,fecha){
        this.titulo= titulo
        this.descripcion = descripcion
        this.fecha = fecha
        this.tareas = []
        this.completa = false
    }

    agregarTarea(tarea){
        //poner la restriccion para que no puedan existir tareas con el mismo nombre 

        /*this.tareas.filter((item)=>item.titulo == tarea.titulo).length>0 ?
        console.log("no se puede añadir, ya existe") : 
        this.tareas.push(tarea)*/
        
        this.tareas.some((item)=>item.titulo == tarea.titulo)?
        console.log("no se puede añadir, ya existe") : 
        this.tareas.push(tarea)
    }

    tareasPendientes(){
        this.tareas.filter((item)=>{return !item.completa}).forEach((item)=>{console.log(item.titulo);})
    }

    tareasCompletas(){
        this.tareas.filter((item)=> {return item.completa}).forEach(item => {
            console.log(item.titulo)
        });
    }

    listarTarea(){
        this.tareas.forEach((item) => {console.log(item.titulo)
            console.log(item.completa)})
    }

    completarTarea(tarea){
        /*this.tareas.filter((item)=>{return item.titulo == tarea})
        .forEach((item) => item.setCompleta = true)*/

        this.tareas.find((item)=>{return item.titulo == tarea}).completa = true
    }


    marcarCompleta(){
        this.tareas.forEach(item => {
            return item.completa ? this.completa = true: false})
    }
    get getTitulo(){
        return this.titulo
    }
    get getDescripcion(){
        return this.descripcion
    }
    get getFecha(){
        return this.fecha
    }
    get getCompleta(){
        return this.completa
    }
    get getTareas(){
        return this.tareas
    }

    set setTarea(tareas){
        this.tareas = tareas
    }
}


let nota1 = new nota("Nota ejemplo","Esta nota es un ejemplo para hacer el ejercicio",new Date())

console.log(nota1.getTitulo);
console.log(nota1.descripcion);

nota1.agregarTarea(new Tarea("tarea 1"))
nota1.agregarTarea(new Tarea("tarea 2"))
nota1.agregarTarea(new Tarea("tarea 3"))
nota1.agregarTarea(new Tarea("tarea 4"))
nota1.agregarTarea(new Tarea("tarea 4"))

nota1.completarTarea("tarea 1")
nota1.completarTarea("tarea 3")

//nota1.tareasPendientes()
nota1.tareasCompletas()


nota1.marcarCompleta()

console.log(nota1.completa)