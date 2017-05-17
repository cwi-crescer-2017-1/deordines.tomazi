document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  let numeroPkmn = document.getElementById('numeroPkmn');

  btnPesquisar.onclick = function() {
    let url = 'http://pokeapi.co/api/v2/pokemon/' + numeroPkmn.value;
    fetch(url)
      .then (response => response.json())
      .then(json => {
        console.log(json);

        let div = document.getElementById('detalhesPokemon');
        let ul = document.createElement('ul');
        let identificacao = document.createElement('h1');
        let img = document.createElement('img');
        let tipos = json.types;
        let atributos = json.stats;

        identificacao.innerHTML = `${ json.id } - ${ json.name.charAt(0).toUpperCase() + json.name.slice(1)}`;
        img.src = json.sprites.front_default;
        img.setAttribute('height', '20%');
        img.setAttribute('width', '20%');

        div.appendChild(identificacao);
        div.appendChild(img);
        div.appendChild(ul);

        tipos.forEach(tipo => {
          let li = document.createElement('li');
          li.innerHTML = tipo.type.name.charAt(0).toUpperCase() + tipo.type.name.slice(1);
          ul.appendChild(li);
        });

        atributos.forEach(atributo => {
          let info = document.createElement('h3');
          info.innerHTML = `${ atributo.stat.name.charAt(0).toUpperCase() + atributo.stat.name.slice(1) }: ${ atributo.base_stat }`;
          div.appendChild(info);

          let progresso = document.createElement('progress');
          progresso.setAttribute('value', atributo.base_stat);
          progresso.setAttribute('max', '255');
          div.appendChild(progresso);
        });

        div.appendChild(document.createElement('hr'));
      });
    }
});
