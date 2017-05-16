Number.prototype.arredondar = function(casasDecimais) {
  casasDecimais = casasDecimais || 2;
  let casas = Math.pow(10, casasDecimais);
  return Math.round(this * casas) / casas;
}

function arredondarToFixed(numero, casas) {
  if (casas === 0) {
    return numero;
  } else {
    return numero.toFixed(casas);
  }
}
