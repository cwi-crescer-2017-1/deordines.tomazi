using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        private AutorRepositorio _autorRepositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult ListarAutores()
        {
            var obterAutores = _autorRepositorio.Listar();
            return Ok(new { dados = obterAutores });
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterAutorPorId(int id)
        {
            var obterAutor = _autorRepositorio.ObterAutor(id);
            return Ok(new { dados = obterAutor });
        }

        [HttpGet]
        [Route("{id}/Livros")]
        public IHttpActionResult ObterLivrosDoAutor(int id)
        {
            var livrosDoAutor = _autorRepositorio.ObterLivrosDoAutor(id);
            return Ok(new { dados = livrosDoAutor });
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult AlterarAutor(int id, Autor autor)
        {
            _autorRepositorio.AlterarAutor(id, autor);
            return Ok(new { dados = autor });
        }

        [HttpPost]
        public IHttpActionResult CriarAutor(Autor autor)
        {
            _autorRepositorio.Criar(autor.Nome);
            return Ok();
        }

        [HttpDelete]
        public IHttpActionResult DeletarAutor(int id)
        {
            _autorRepositorio.Excluir(id);
            return Ok();
        }
    }
}
