function ejemploFuncion() {
    console.log("Ejecucion de una funcion normal");
}

function funcionParametros(parametroUno,parametroDos) {
    console.log(`${parametroUno} + ${parametroDos}`);
}

function funcionArgumentosInvisibles() {
    console.log(arguments);
}

function funcionesRetorno(numeroUno,numeroDos) {
    return numeroUno + numeroDos;
}

function funcionSuma(num1,num2) {}

function funcionRetornoFuncion(param1,param2) {
    return funcionSuma(param1,param2)
}

//ejemploFuncion
//funcionParametros(1,5)
//funcionArgumentosInvisibles("uno","dos","tres","cuatro")
//console.log(funcionesRetorno(2,4));
funcionRetornoFuncion