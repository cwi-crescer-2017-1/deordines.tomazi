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
    [RoutePrefix("api/livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio _livroRepositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult ListarLivros()
        {
            var obterLivros = _livroRepositorio.Listar();
            _livroRepositorio.Dispose();
            return Ok(new { dados = obterLivros });
        }

        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult ObterLivro(int isbn)
        {
            var obterLivro = _livroRepositorio.ObterLivro(isbn);
            return Ok(new { dados = obterLivro });
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult ObterPorGenero(string genero)
        {
            var obterLivros = _livroRepositorio.ObterPorGenero(genero);
            return Ok(new { dados = obterLivros });
        }

        [HttpGet]
        [Route("lancamentos")]
        public IHttpActionResult ObterPorLancamento()
        {
            var obterLivros = _livroRepositorio.ObterPorLancamento();
            return Ok(new { dados = obterLivros });
        }

        [HttpPut]
        [Route("{isbn}")]
        public IHttpActionResult AlterarLivro(int isbn, Livro livro)
        {
            _livroRepositorio.AlterarLivro(isbn, livro);
            return Ok(new { dados = livro });
        }

        [HttpPost]
        public IHttpActionResult CriarLivro(Livro livro)
        {
            _livroRepositorio.Criar(livro);
            return Ok(new { dados = livro });
        }

        [HttpDelete]
        [Route("{isbn}")]
        public IHttpActionResult DeletarLivro(int isbn)
        {
            _livroRepositorio.Excluir(isbn);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            _livroRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
