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
    [RoutePrefix("api/pacotes")]
    public class PacotesController : ApiController, IDisposable
    {
        private PacoteRepositorio repositorio = new PacoteRepositorio();

        [Authorize(Roles = "funcionario, gerente")]
        [HttpGet]
        public IHttpActionResult Listar()
        {
            var pacotes = repositorio.Listar();
            return Ok(new { dados = pacotes });
        }

        [Authorize(Roles = "funcionario, gerente")]
        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult BuscarPorId(int id)
        {
            var pacotes = repositorio.BuscarPorId(id);
            return Ok(new { dados = pacotes });
        }

        [Authorize(Roles = "gerente")]
        [HttpPost, Route("registrar")]
        public IHttpActionResult Criar([FromBody]CriarPacoteModel model)
        {
            var pacote = new Pacote(model.Nome, model.Descricao, model.Valor, model.QuantidadeDias);
            repositorio.Criar(pacote);
            return Ok(new { dados = pacote });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
