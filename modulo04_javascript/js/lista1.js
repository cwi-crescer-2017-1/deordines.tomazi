// Exercício 1
var daisyGame = function(a) {
  if (a % 2 === 0)
    return "Love me *-*";
  else
    return "Love me not :(";
}
console.log("Daisy Game: ", daisyGame(6));

// Exercício 2
function maiorTexto(textos) {
  var maiorTexto = "a";
  for (var palavra of textos) {
    if (palavra.length > maiorTexto.length) {
      maiorTexto = palavra;
    }
  }
  return maiorTexto;
}
console.log("Maior texto: ", maiorTexto(["Eu", "Você", "Dois", "Filhos", "E", "Um", "Cachorro"]));

// Exercício 3
function imprime(nome, funcao) {
  if (typeof(funcao) !== "function") {
    console.log("YOLO: Você não inseriu uma função.");
    return;
  }
  for (var professor of nome) {
    funcao(professor);
  }
}

var instrutores = function(instrutor) {
  console.log("Olá, querido instrutor: ", instrutor);
}
console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"], instrutores));
console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"], 3.14));
// console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"], function(instrutor) { console.log("Olá, querido professor: ", instrutor);}));


//Exercício 4
function somar(a) {
  return function(b) {
    return a + b;
  };
}
console.log("Somar(5)(5): ", somar(5)(5));

// Exercício 5
// function fiboSum(number) {
//   return (number <= 3) ? number : fiboSum(number - 1) + fiboSum(number - 2) + 1;
// }
//   if (number === 1) return a;
//   if (number === 2) return b;
//
//   return fiboSum(b, a + b, number - 1);
// }
//
// var fibo = function(number) {
//   return fiboSum(0, 1, (number > 0) ? n : 1);
// }
// console.log("Fibo: ", fibo(7));


// function fib(number) {
//   return number < 2 ? number : fib(number - 1) + fib(number - 2);
// }
//
// function sumFib(number) {
//   return number < 0 ? 0 : fib(number) + sumFib(number - 1);
// }

function fib(number) {
  var fnum = 0;
  var val1 = 0;
  var val2 = 1;

  for (var i = 1; i <= number; i++) {
    if (number < 2) {
      fnum = 1;
    } else {
      fnum = val1 + val2;
      val1 = val2;
      val2 = fnum;
    }
  }
  return fnum;
}
console.log("Fucking Fibonacci: ", fib(8));

// Exercício 6 TO-DO
function queroCafe(mascada, precos) {

}
