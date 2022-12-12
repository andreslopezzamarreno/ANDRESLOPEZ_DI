console.log("Script ejecutado desde web");

//para comentar todo lo seleccionado shift alt A

//variables
//no existen tipos en definicion --> NO TIPADO
let numero = 5;
let numeroDecimal = 3.14;
let palabras = "Esto es un ejemplo de palabra en JS";
let letras = "A"; //String --> char
let experiencias = true; //boolean
let sinDefinir = undefined; //undefined
let objeto = null; //null
let coleccion = []//array --> Any
let fechaActual = new Date();

//typeof --> dice el tipo de dato de la variable
console.log(typeof numero);
console.log(numeroDecimal);
console.log(palabras);
console.log(letras);
console.log(experiencias);
console.log(sinDefinir);
console.log(objeto);
console.log(coleccion);

//alert("Ejemplo de mensaje de aviso"); // no hay iteracion con el usuario
//confirm("ejemplo de mensaje de confirmacion"); 
//prompt("Ejemplo de mensaje de introduccion");

let confirmacion = confirm("Estas seguro que quieres continuar")
console.log(confirmacion);

//calculadora
/*
se piden por prompt dos datos -->op1 y op2
si los dos datos son numeros 
    salen alerts con los mensajes op1 * op2 = RESULTADO
    salen alerts con los mensajes op1 + op2 = RESULTADO
    salen alerts con los mensajes op1 - op2 = RESULTADO
    salen alerts con los mensajes op1 / op2 = RESULTADO
    salen alerts con los mensajes op1 % op2 = RESULTADO

si no son numeros --> alert-> hay elementos que no cumple condicion
*/

if (confirmacion){
    //console.log("Me han confirmado");
    let datos = prompt("Introduce los datos que se piden");
    console.log(datos);
    console.log(typeof datos);
    //NaN --> not a number 
}else {
    console.log("No me han confirmado");
} 


let operandoUno = Number(prompt("Escribe el operando 1"));
let operandoDos = Number(prompt("Escribe el operando 2"));

//if ternario
//condicion ? cuando es True : cuando es False
isNaN(operandoUno) ? console.log("es numero") : console.log("No es un Numero");;

if (!isNaN(operandoUno) && !isNaN(operandoDos) ){
    console.log("Ambos son Numeros");
    console.log(`La suma de ambos numeros ${operandoUno} + ${operandoDos} es ${operandoUno+operandoDos}`);
    console.log(`La suma de ambos numeros ${operandoUno} - ${operandoDos} es ${operandoUno-operandoDos}`);
    console.log(`La suma de ambos numeros ${operandoUno} * ${operandoDos} es ${operandoUno*operandoDos}`);
    console.log(`La suma de ambos numeros ${operandoUno} / ${operandoDos} es ${operandoUno/operandoDos}`);
    console.log(`La suma de ambos numeros ${operandoUno} % ${operandoDos} es ${operandoUno%operandoDos}`);
}else{
    alert("Uno de los datos no es un numero")
}
//constantes --> Elemento no Cambiante
const constante = "Dato";
