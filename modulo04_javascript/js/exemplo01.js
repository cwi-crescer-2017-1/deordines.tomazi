// MDN - Mozilla Developer Network

console.log("Carregou!");
// alert("Seja bem-vindo(a)!");

// var pi = 3.14;
// Melhor forma de verificar se uma variável está definida
if (typeof pi !== "undefined") {
  console.log(pi);
}

// ES 2015 - não roda em todos os navegadores, ex.: ie11 e opera
// http://caniuse.com/#search=arrow%20functions
var somarArrowFunction = (a, b) => a + b;
console.log("somarArrowFunction", somarArrowFunction(1, 2));
console.log("typeof somarArrowFunction", typeof somarArrowFunction);

console.log("tem somarSemReturn?", somarSemReturn);
function somarSemReturn(a, b) {
  return a + b;
}
console.log("somarSemReturn", somarSemReturn(1, 2));
console.log("somarSemReturn", typeof somarSemReturn);

console.log("somar", somar);
var somar = function(a, b) {
  return a + b;
}
console.log("somar", somar(1, 2));
console.log("typeof somar", typeof somar);

var somarArguments = function() {
  var a = arguments[0], b = arguments[1];
  return a + b;
}
console.log("somarArguments", somarArguments(1, 2));

// Função que trabalha com função
var calcular = function(funcao, a, b) {
  return funcao(a, b);
}

var somarComCalcular = (a, b) => a + b;
console.log("somarComCalcular", somarComCalcular(1, 2));

var subtrairComCalcular = (a, b) => a - b;
console.log("subtrairComCalcular", subtrairComCalcular(1, 2));

// IIFE
var multiplicarComCalcular = (function (a, b) {
  return a * b;
})(2, 3);
console.log("multiplicarComCalcular", multiplicarComCalcular);

var funcoes = [
  function(a, b) { return a + b; },
  function(a, b) { return a - b; },
  function(a, b) { return a * b; },
  function(a, b) { return a / b; }
]

// ECMA 2015 - for-of: percorre as propriedades do array
for (var funcao of funcoes) {
  var a = 1, b = 2;
  console.log(funcao(a, b));
}

// for-in: percorre as propriedades do objeto
for (var funcao in funcoes) {
  var a = 1, b = 2;
  //console.log(funcao); imprime os índices do array
  console.log(funcoes[funcao](a, b)); // imprime os valores do array
}
