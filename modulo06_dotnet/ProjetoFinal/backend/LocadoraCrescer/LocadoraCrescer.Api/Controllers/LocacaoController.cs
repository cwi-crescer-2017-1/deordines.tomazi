using LocadoraCrescer.Api.Models;
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
    [RoutePrefix("api/locacao")]
    public class LocacaoController : ApiController
    {
        private LocacaoRepositorio repositorioLocacao = new LocacaoRepositorio();
        private ClienteRepositorio repositorioCliente = new ClienteRepositorio();
        private ProdutoConsoleRepositorio repositorioProduto = new ProdutoConsoleRepositorio();
        private PacoteRepositorio repositorioPacote = new PacoteRepositorio();

        [HttpGet]
        public IHttpActionResult Listar()
        {
            var locacao = repositorioLocacao.Listar();
            return Ok(new { dados = locacao });
        }

        //[Authorize(Roles = "funcionario")]
        [HttpPost]
        public IHttpActionResult Criar([FromBody]CriarLocacaoModel model)
        {
            var cliente = repositorioCliente.BuscarPorId(model.IdCliente);
            var produto = repositorioProduto.BuscarPorId(model.IdProdutoConsole);
            var pacote = repositorioPacote.BuscarPorId(model.IdPacote);
            var locacao = new Locacao(cliente, produto, pacote);
            repositorioLocacao.Criar(locacao);
            return Ok(new { dados = locacao });
        }

        //[HttpPut]
        //public IHttpActionResult
    }
}