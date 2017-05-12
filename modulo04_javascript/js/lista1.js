// Exercício 1
var daisyGame = function(a) {
  if (a % 2 === 0)
    return "Love me *-*";
  else
    return "Love me not :(";

  // return a % 2 !== 0 ? 'Love me' : 'Love me not';
  // ou
  // Interpolação de string, similar com o stringFormat
  // ES 2015
  // return `Love me${ a % 2 !== 0 ? '' : ' not'}`;

  // var impar = a % 2 !== 0;
  // return `Love me${ impar ? '' : ' not'}`;
}
console.log("Daisy Game: ", daisyGame(6));

// Exercício 2
function maiorTexto(textos) {
  var maiorTexto = "";
  // let protege a variável, mantendo ela viva somente dentro do escopo
  for (let palavra of textos) {
    if (palavra.length > maiorTexto.length) {
      maiorTexto = palavra;
    }
  }
  return maiorTexto;
}
console.log("Maior texto: ", maiorTexto(["Eu", "Você", "Dois", "Filhos", "E", "Um", "Cachorro"]));
console.log("Maior texto: ", maiorTexto([ ]));

// Exercício 3
function imprime(nome, funcao) {
  if (typeof(funcao) !== "function") {
    console.log("YOLO: Você não inseriu uma função.");
    return;
  } else {
    for (let professor of nome) {
      funcao(professor);
    }
  }

  // nome.forEach( (t) => funcao(t));
  // nome.forEach(funcao); // forEach executa a função, o parâmetro somente informa ao javascript que tem algo para ser executado
}

var instrutores = function(instrutor) {
  console.log(arguments); // saber o que está sendo executado
  console.log("Olá, querido instrutor: ", instrutor);
}
console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"], instrutores));
// console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"], 3.14));
// console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"], function(instrutor) { console.log("Olá, querido professor: ", instrutor);}));


//Exercício 4
function somar(a) {
  return function(b) {
    return a + b;
  }
}
console.log("Somar(5)(5): ", somar(5)(5));

function somar2(a) {
  return function(b) {
    return function(c) {
      return a + b + c;
    }
  }
}
console.log("Somar(5)(5)(5)", somar2(5)(5)(5));

console.log((function somar(a) {
  return function(b) {
    return a + b;
  }
})(2)(3))

// Exercício 5
function fibonacci(number) {
  var fnum = 0;
  var val1 = 0;
  var val2 = 1;

  if (number === 0) {
    return 1;
  }
  // let protege a variável, mantendo ela viva somente dentro do escopo
  for (let i = 0; i < number; i++) {
    if (number < 2) {
      return 1;
    } else {
      fnum = val1 + val2;
      val1 = val2;
      val2 = fnum;
    }
  }
  return fnum;
}
for (var i = 0; i < 9; i++) {
  console.log("Fibonacci: ", i , fibonacci(i));
}
console.log("Fucking Fibonacci: ", fibonacci(8));

// Fibonacci feito em aula
// function fibonacci2(n) {
//   if (n === 1 || n === 2)
//     return 1;
//   return fibonacci2(n - 1) + (n - 2);
// }
//
// function fiboSum(n) {
//   if (n === 1) {
//     return 1;
//   }
//   return fibonacci(n) + fibonacci(n - 2);
// }
// console.log(fibonacci2(4));

// Exercício 6 TO-DO
function queroCafe(mascada, precos) {
  var precosDentroDoOrcamento = [];
  precos.forEach((p) => {
    if (p <= mascada) {
      precosDentroDoOrcamento.push(p);
    }
  });
  precosDentroDoOrcamento.sort( (a, b) => a - b).join(",");

  /*
  return precos
    .filter(function(a) {
      return a <= mascada;
    })
    .sort(function(a,b) {
      return a - b;
    })
    .join(", ")

  return precos
    .filter(a => a <= mascada)
    .sort((a,b) => a-b)
    .join(", ")
    */
}
console.log(queroCafe(3.14, [5.16, 2.12, 1.15, 3.11, 17.5]));
