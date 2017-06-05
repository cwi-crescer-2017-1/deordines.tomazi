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

        ~LivrosController()
        {
            _livroRepositorio.Dispose();
        }

        [HttpGet]
        public IHttpActionResult ListarLivros()
        {
            var obterLivros = _livroRepositorio.ListarTodosOsLivros();
            return Ok(new { dados = obterLivros });
        }

        [HttpGet]
        [Route("lancamentos")]
        public IHttpActionResult ListarLancamentos()
        {
            var obterLivros = _livroRepositorio.ListarTodosOsLancamentos();
            return Ok(new { dados = obterLivros });
        }

        [HttpGet]
        public IHttpActionResult ListarLivrosPaginados(int quantidadePular, int quantidadeTrazer)
        {
            var obterLivros = _livroRepositorio.ListarLivrosPaginadosExcetoLancamentos(quantidadePular, quantidadeTrazer);
            return Ok(new { dados = obterLivros });
        }

        [HttpGet]
        [Route("lancamentos")]
        public IHttpActionResult ListarLancamentosPaginados(int quantidadePular, int quantidadeTrazer)
        {
            var obterLivros = _livroRepositorio.ListarLivrosPaginadosPorLancamento(quantidadePular, quantidadeTrazer);
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
        public IHttpActionResult ListarPorGenero(string genero)
        {
            var obterLivros = _livroRepositorio.ObterPorGenero(genero);
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
        public IHttpActionResult CriarLivro(Livro[] livros)
        {
            foreach (var livro in livros)
                _livroRepositorio.Criar(livro);
            return Ok(new { dados = livros });
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
