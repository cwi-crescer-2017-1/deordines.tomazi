document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  let numeroPkmn = document.getElementById('numeroPkmn');

  btnPesquisar.onclick = function() {
    // console.log('Click');
    // console.log(numeroPkmn.value);

    let url = 'http://pokeapi.co/api/v2/pokemon/' + numeroPkmn.value;
    fetch(url)
      .then (response => response.json())
      .then(json => {
      console.log(json);
      console.log(json.sprites.front_default);
      let div = document.getElementById('detalhesPokemon');

      let newDiv = document.createElement('div');
      let img = document.createElement('img');
      let h1 = document.createElement('h1');
      let h2 = document.createElement('h2');
      let ul = document.createElement('ul');
      let br = document.createElement('br');
      let hr = document.createElement('hr');

      let id = json.id;
      let nome = json.name;
      img.src = json.sprites.front_default;
      let tipos = json.types;
      tipos.reverse();

      div.append(newDiv);
      newDiv.setAttribute('id', 'pokemon');
      newDiv.append(h1);
      h1.append(`${ id } - ${ nome.charAt(0).toUpperCase() + nome.slice(1) }`);
      newDiv.append(br);
      newDiv.append(img);
      img.setAttribute('height', '10%');
      img.setAttribute('width', '10%');
      newDiv.append(h2);
      h2.append(ul);

      tipos.forEach(tipo => {
        let novaLi = document.createElement('li');
        let textNode = document.createTextNode(tipo.type.name.charAt(0).toUpperCase() + tipo.type.name.slice(1));
        novaLi.appendChild(textNode);
        ul.insertBefore(novaLi, ul.childNodes[0]);
      });

      newDiv.append(hr);
    })
  }
});
