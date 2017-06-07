using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.Api.Controllers
{
    [RoutePrefix("api/produtosConsole")]
    public class ProdutosConsoleController : ApiController
    {
        private ProdutoConsoleRepositorio repositorio = new ProdutoConsoleRepositorio();

        [HttpGet]
        public IHttpActionResult Listar()
        {
            var produtosConsole = repositorio.Listar();
            return Ok(new { dados = produtosConsole });
        }

        [HttpGet]
        public IHttpActionResult BuscarPorId(int id)
        {
            var produtosConsole = repositorio.BuscarPorId(id);
            return Ok(new { dados = produtosConsole });
        }

        [HttpPost]
        public IHttpActionResult Criar(ProdutoConsole produto)
        {
            repositorio.Criar(produto);
            return Ok(new { dados = produto });
        }

        [HttpPut]
        [Route("alugar/{id}")]
        public IHttpActionResult Alugar(int id)
        {
            var produtoConsole = repositorio.BuscarPorId(id);

            if (!produtoConsole.ValidarEstoque())
                return BadRequest();

            repositorio.Alugar(produtoConsole);

            return Ok(new { dados = produtoConsole });
        }

        [HttpPut]
        [Route("devolver/{id}")]
        public IHttpActionResult Devolver(int id)
        {
            var produtoConsole = repositorio.BuscarPorId(id);

            repositorio.Devolver(produtoConsole);

            return Ok(new { dados = produtoConsole });
        }
    }
}
