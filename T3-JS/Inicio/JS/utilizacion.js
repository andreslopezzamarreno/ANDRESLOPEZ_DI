/* let objeto = new ClaseEjemplo("p1","p2",["p3"])
objeto.mostrarDatos()
 */
//titulo completa
//tareas de texto --> descripcion  --> agregarDefinicion()
//tareas multimedia --> fichero --> agregarFichero()

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

    mostrarDatosNota(){
        console.log(`\t titulo: ${this.titulo}`);
        console.log(`\t\t completa: ${this.completa}`);
    }
}

class tareaMultimedia extends Tarea{

    fichero
    constructor(titulo,fichero){
        super(titulo) 
        this.fichero = fichero
    }

    set setFichero(fichero){
        this.fichero = fichero
    }

    mostrarDatosNota(){
        super.mostrarDatosNota
        console.log(`\t\t fichero: ${this.fichero}`);
    }

}

class tareaTexto extends Tarea{
    descripcion
    constructor(titulo,descripcion){
        super(titulo)
        this.descripcion = descripcion
    }

    set setDescripcion(descripcion){
        this.descripcion = descripcion
    }

    mostrarDatosNota(){
        super.mostrarDatosNota
        console.log(`\t\t descripcion: ${this.descripcion}`);
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

    listarTareas(){
        console.log( this.titulo)
        this.tareas.forEach((item) => {
        
            item.mostrarDatosNota()}) 
    }

    completarTarea(titulo){
        /*this.tareas.filter((item)=>{return item.titulo == tarea})
        .forEach((item) => item.setCompleta = true)*/

        this.tareas.find((item)=>{return item.titulo == titulo}).completa = true
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
/* 

let nota1 = new nota("Nota ejemplo","Esta nota es un ejemplo para hacer el ejercicio",new Date())

console.log(nota1.getTitulo);
console.log(nota1.descripcion);

nota1.agregarTarea(new Tarea("tarea 1"))
nota1.agregarTarea(new Tarea("tarea 2"))
nota1.agregarTarea(new Tarea("tarea 3"))
nota1.agregarTarea(new Tarea("tarea 4"))
nota1.agregarTarea(new Tarea("tarea 4"))
nota1.agregarTarea(new tareaMultimedia("tarea multimedia","./images/fichero.png"))
nota1.agregarTarea(new tareaTexto("tarea de Texto","Esto es un ejemplo de tarea de texto utilizando extension"))

nota1.completarTarea("tarea 1")
nota1.completarTarea("tarea 3")

//nota1.tareasPendientes()
nota1.tareasCompletas()


nota1.marcarCompleta()

console.log(nota1.completa) 

 nota1.listarTareas()*/