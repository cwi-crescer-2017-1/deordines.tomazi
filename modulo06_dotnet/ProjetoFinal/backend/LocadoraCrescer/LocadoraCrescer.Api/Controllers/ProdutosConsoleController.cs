using LocadoraCrescer.Api.Models;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using LocadoraCrescer.WebApi;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.Api.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/produtosConsole")]
    public class ProdutosConsoleController : ApiController
    {
        private ProdutoConsoleRepositorio repositorio = new ProdutoConsoleRepositorio();

        [Authorize(Roles = "funcionario")]
        [HttpGet]
        public IHttpActionResult Listar()
        {
            var produtosConsole = repositorio.Listar();
            return Ok(new { dados = produtosConsole });
        }

        [Authorize(Roles = "funcionario")]
        [HttpGet]
        public IHttpActionResult BuscarPorId(int id)
        {
            var produtosConsole = repositorio.BuscarPorId(id);
            return Ok(new { dados = produtosConsole });
        }

        [Authorize(Roles = "gerente")]
        [HttpPost, Route("registrar")]
        public IHttpActionResult Criar([FromBody]CriarProdutoModel model)
        {
            var produto = new ProdutoConsole(model.Nome, model.Valor, model.Estoque);
            repositorio.Criar(produto);
            return Ok(new { dados = produto });
        }

        [Authorize(Roles = "funcionario")]
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

        [Authorize(Roles = "funcionario")]
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
