//clase
class ClaseEjemplo{
    //variables
    propiedadUno;
    propiedadDos;
    propiedadTres;

    //constructores
    constructor(param1,param2,param3){
        this.propiedadUno = param1
        this.propiedadDos = param2
        this.propiedadTres = param3
    }

    /* constructor(param1,param2){
        this.propiedadUno = param1
        this.propiedadDos = param2
        this.propiedadTres = []
    } */


    //funciones
    mostrarDatos(){
        console.log(`Propiedad Uno: ${this.propiedadUno}`);
        console.log(`Propiedad Dos: ${this.propiedadDos}`);
        this.propiedadTres.forEach(element => {
            console.log(element);
        });
    }


    agregarDatos (param1){
        this.propiedadTres.push(param1)
    }

    set setPropiedadUno (param){
        this.propiedadUno = param
    }
    get getPropiedadUno(){
        return this.propiedadUno
    }
}

/* let ejemploObjeto = new ClaseEjemplo("Propiedad 1","Propiedad 2",["param1","param2"])


//ejemploObjeto.agregarDatos(parseInt(Math.random()*20))
ejemploObjeto.setPropiedadUno= "holaaa"
console.log(ejemploObjeto.getPropiedadUno);

ejemploObjeto.mostrarDatos(); */


//json