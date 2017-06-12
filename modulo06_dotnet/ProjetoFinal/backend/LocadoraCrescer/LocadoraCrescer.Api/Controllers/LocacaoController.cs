﻿using LocadoraCrescer.Api.Models;
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
    [RoutePrefix("api/locacao")]
    public class LocacaoController : ApiController, IDisposable
    {
        private LocacaoRepositorio repositorioLocacao = new LocacaoRepositorio();
        private ClienteRepositorio repositorioCliente = new ClienteRepositorio();
        private ProdutoConsoleRepositorio repositorioProduto = new ProdutoConsoleRepositorio();
        private PacoteRepositorio repositorioPacote = new PacoteRepositorio();
        private ExtraRepositorio repositorioExtra = new ExtraRepositorio();

        [Authorize(Roles = "funcionario")]
        [HttpGet]
        public IHttpActionResult Listar()
        {
            var locacao = repositorioLocacao.Listar();
            return Ok(new { dados = locacao });
        }

        [Authorize(Roles = "funcionario")]
        [HttpPost]
        public IHttpActionResult Criar([FromBody]CriarLocacaoModel model)
        {
            var cliente = repositorioCliente.BuscarPorId(model.IdCliente);
            var produto = repositorioProduto.BuscarPorId(model.IdProdutoConsole);
            var pacote = repositorioPacote.BuscarPorId(model.IdPacote);
            //var extra = repositorioExtra.BuscarPorId(model.IdExtra);
            var locacao = new Locacao(cliente, produto, pacote);

            repositorioProduto.Alugar(produto);

            var extraJogo = repositorioExtra.BuscarPorId(1);
            var extraControle = repositorioExtra.BuscarPorId(2);
            switch (pacote.Id)
            {
                case 1:
                    repositorioExtra.Alugar(extraJogo, 1);
                    repositorioExtra.Alugar(extraControle, 1);
                    break;
                case 2:
                    repositorioExtra.Alugar(extraJogo, 2);
                    repositorioExtra.Alugar(extraControle, 1);
                    break;
                case 3:
                    repositorioExtra.Alugar(extraJogo, 5);
                    repositorioExtra.Alugar(extraControle, 2);
                    break;
            }

            repositorioLocacao.Criar(locacao);
            return Ok(new { dados = locacao });
        }

        [Authorize(Roles = "funcionario")]
        [HttpPut]
        [Route("devolver")]
        public IHttpActionResult Devolver([FromBody]AlterarPedido model)
        {
            var locacao = repositorioLocacao.BuscarPorId(model.Id);

            repositorioProduto.Devolver(locacao.ProdutoConsole);

            var extraJogo = repositorioExtra.BuscarPorId(1);
            var extraControle = repositorioExtra.BuscarPorId(2);
            switch (locacao.Pacote.Id)
            {
                case 1:
                    repositorioExtra.Devolver(extraJogo, 1);
                    repositorioExtra.Devolver(extraControle, 1);
                    break;
                case 2:
                    repositorioExtra.Devolver(extraJogo, 2);
                    repositorioExtra.Devolver(extraControle, 1);
                    break;
                case 3:
                    repositorioExtra.Devolver(extraJogo, 5);
                    repositorioExtra.Devolver(extraControle, 2);
                    break;
            }

            repositorioLocacao.Devolver(locacao);
            return Ok(new { dados = locacao });
        }

        protected override void Dispose(bool disposing)
        {
            repositorioCliente.Dispose();
            repositorioProduto.Dispose();
            repositorioPacote.Dispose();
            repositorioLocacao.Dispose();
            base.Dispose(disposing);
        }
    }
}