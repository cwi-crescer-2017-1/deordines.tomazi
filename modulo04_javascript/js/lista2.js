// Exercício 1
function seriesInvalidas(series) {
  var seriesInvalidas = [];
  var tituloSerieInvalidas = [];

  var dataAtual = new Date();
  var anoAtual = dataAtual.getFullYear();

  for (let serie of series) {
    let dataAtual = new Date();
    let anoAtual = dataAtual.getFullYear();
    let serieAtual = Object.values(serie);

    for (let serie of serieAtual) {
      var boolean = false;
      if (serie === null || typeof(serie) === 'undefined') {
        boolean = true;
      }
    }

    if (boolean) {
      seriesInvalidas.push(serie);
    }
    else if (serie.anoEstreia > anoAtual) {
      seriesInvalidas.push(serie);
    }
  }

  // for (let serie of seriesInvalidas) {
  //   tituloSerieInvalidas.push(serie.titulo);
  // }
  // return 'Séries inválidas: ' + tituloSerieInvalidas.join(' - ');

  return 'Séries inválidas: ' + seriesInvalidas
   .map(serie => serie.titulo).join(' - ');

  // return series
  //   .filter (serie => serie.anoEstreia > anoAtual,
  //             serie => serie.contains(null),
  //             serie => serie.contains('undefined'))
  //   .map (serie => seriesInvalidas.push(serie.titulo))
  //
  //   return series
  //   .filter (function(serie) {
  //     if (serie.anoEstreia > anoAtual) {
  //       return serie;
  //     }
  //     return function(serie) {
  //       if ()
  //     }
  //   })
}

// Exercício 2
function filtrarSeriesPorAno(series, ano) {
  // var tituloSerie = [];
  //
  // for (let serie of series) {
  //   if (serie.anoEstreia >= ano) {
  //     tituloSerie.push(serie.titulo);
  //   }
  // }
  //
  // return 'Séries acima do ano ' + ano + ': ' + tituloSerie.join(' - ');

  return series
    .filter (serie => ano <= serie.anoEstreia)
}

// Exercício 3
function mediaDeEpisodios(series) {
  // var totalEpisodios = 0;
  // var mediaDeEpisodios = 0;
  //
  // for (let serie of series) {
  //   totalEpisodios += serie.numeroEpisodios;
  // }
  // mediaDeEpisodios = totalEpisodios / series.length;
  //
  // return 'Média de episódios da soma de todas as séries: ' + mediaDeEpisodios;

  return 'Média de episódios da soma de todas as séres: ' + series
    .map (serie => serie.numeroEpisodios)
    .reduce ((qtdAnterior, qtdAtual) => qtdAnterior + qtdAtual) / series.length;
}

// Exercício 4
function procurarPorNome(series, nome) {
  // for (let serie of series) {
  //   let elenco = Object.values(serie.elenco);
  //
  //   for (let nomeAtor of elenco) {
  //     if (nomeAtor.includes(nome)) {
  //       return true;
  //     }
  //   }
  // }

  return series
    .filter (serie => serie.elenco.includes(nome));
}

// Exercício 5
function mascadaEmSerie(series) {
  var salarioDiretores = 100000;
  var salarioAtores = 40000;

  if (series.length > 1) {
    return;
  } else {
    // return (series.diretor.length * salarioDiretores) + (series.elenco.length * salarioAtores);
    return `${series.titulo}:\n   Gasto Mensal: ${series.diretor.length * salarioDiretores + series.elenco.length * salarioAtores}`;
  }
}

function mascadaEmSerieTotal(series) {
  for (let serie of series) {
    console.log(mascadaEmSerie(serie));
    // console.log(
      // `${serie.titulo}:\n   Gasto Mensal: ${mascadaEmSerie(serie)}`);
  }
}

// Exercício 6
function queroGenero(genero) {
  return series
    .filter (serie => serie.genero.includes(genero))
    .map (serie => serie.titulo);
}

function queroTitulo(titulo) {
  return series
    .filter (serie => serie.titulo.includes(titulo))
    .map (serie => serie.titulo)
}

// Exercício 7
function creditosIlluminatis(series) {
  var diretores = Object.values(series.diretor).toString();
  var elenco = Object.values(series.elenco);

  function sortSobrenome(a, b) {
    a = a.split(' ');
    b = b.split(' ');

    a = a[a.length - 1].toString()[0];
    b = b[b.length - 1].toString()[0];

    if (a < b) {
      return -1
    } else if (a > b) {
      return 1;
    } else {
      return 0;
    }
  }

  return console.log(
    `Título:\n   ${series.titulo}\n
    Diretores:\n   ${series.diretor.sort(sortSobrenome).join(', ')}\n
    Elenco:\n   ${series.elenco.sort(sortSobrenome).join(', ')}`
  );
}

// Exercício 8
function serieIlluminati(series) {
  var elencoComAbreviacao = [];
  var letrasAbreviadas = [];

  for (let serie of series) {
    let elenco = Object.values(serie.elenco);
    let boolean = stringComAbreviacao(elenco);

    if (boolean) {
      for (let nome of elenco) {
        elencoComAbreviacao.push(nome);
      }
    }
  }

  function stringComAbreviacao(elenco) {
    for (let nome of elenco) {
      if (!nome.includes('.')) {
        return false;
      }
    }
    return true;
  }

  // return console.log(elencoComAbreviacao.join('\n'));
  elencoComAbreviacao = elencoComAbreviacao.toString().split(' ');
  // return elencoComAbreviacao;
  for (let letra of elencoComAbreviacao) {
    if (letra.includes('.') && letra.length === 2) {
      letrasAbreviadas.push(letra[0]);
    }
  }

  return console.log(
    `${letrasAbreviadas.join('\n')}`
  );
}
