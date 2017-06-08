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
    [RoutePrefix("api/pacotes")]
    public class PacotesController : ApiController
    {
        private PacoteRepositorio repositorio = new PacoteRepositorio();

        [HttpGet]
        public IHttpActionResult Listar()
        {
            var pacotes = repositorio.Listar();
            return Ok(new { dados = pacotes });
        }

        [HttpPost, Route("registrar")]
        public IHttpActionResult Criar([FromBody]CriarPacoteModel model)
        {
            var pacote = new Pacote(model.Nome, model.Descricao, model.Valor, model.QuantidadeDias);
            repositorio.Criar(pacote);
            return Ok(new { dados = pacote });
        }
    }
}
