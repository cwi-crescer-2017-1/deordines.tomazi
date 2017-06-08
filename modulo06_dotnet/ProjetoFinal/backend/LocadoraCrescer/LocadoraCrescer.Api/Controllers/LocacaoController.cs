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
        private UsuarioRepositorio repositorioUsuario = new UsuarioRepositorio();
        private ClienteRepositorio repositorioCliente = new ClienteRepositorio();
        private ProdutoConsoleRepositorio repositorioProduto = new ProdutoConsoleRepositorio();
        private PacoteRepositorio repositorioPacote = new PacoteRepositorio();

        [HttpGet]
        public IHttpActionResult Listar()
        {
            var locacao = repositorioLocacao.Listar();
            return Ok(new { dados = locacao });
        }

        [HttpPost]
        public IHttpActionResult Criar([FromBody]CriarLocacaoModel model)
        {
            var locacao = new Locacao(model.Usuario, model.Cliente, model.ProdutoConsole, model.Pacote);
            return Ok(new { dados = locacao });
        }
    }
}