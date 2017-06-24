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
    [RoutePrefix("api/extras")]
    public class ExtrasController : ApiController, IDisposable
    {
        private ExtraRepositorio repositorio = new ExtraRepositorio();

        [Authorize(Roles = "funcionario, gerente")]
        [HttpGet]
        public IHttpActionResult Listar()
        {
            var extras = repositorio.Listar();
            return Ok(new { dados = extras });
        }

        [Authorize(Roles = "funcionario, gerente")]
        [HttpGet]
        public IHttpActionResult BuscarPorId(int id)
        {
            var extra = repositorio.BuscarPorId(id);
            return Ok(new { dados = extra });
        }

        [Authorize(Roles = "gerente")]
        [HttpPost]
        [Route("registrar")]
        public IHttpActionResult Criar([FromBody]CriarExtraModel model)
        {
            var extra = new Extra(model.Nome, model.Valor, model.Estoque);
            repositorio.Criar(extra);
            return Ok(new { dados = extra });
        }

        [Authorize(Roles = "funcionario, gerente")]
        [HttpPut]
        [Route("alugar")]
        public IHttpActionResult Alugar([FromBody]AlterarQuantidade model)
        {
            var extra = repositorio.BuscarPorId(model.Id);

            if (!extra.ValidarEstoque())
                return BadRequest();

            repositorio.Alugar(extra, model.Quantidade);

            return Ok(new { dados = extra });
        }

        [Authorize(Roles = "funcionario, gerente")]
        [HttpPut]
        [Route("devolver")]
        public IHttpActionResult Devolver([FromBody]AlterarQuantidade model)
        {
            var extra = repositorio.BuscarPorId(model.Id);

            repositorio.Devolver(extra, model.Quantidade);

            return Ok(new { dados = extra });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
