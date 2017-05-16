let url = "http://pokeapi.co/api/v2/pokemon/1/";
fetch(url)
  .then(response => response.json())
  .then(json => console.log(json));
