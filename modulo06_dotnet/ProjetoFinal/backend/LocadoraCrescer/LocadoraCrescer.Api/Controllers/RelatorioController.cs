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
    [RoutePrefix("api/relatorios")]
    public class RelatorioController : ApiController, IDisposable
    {
        private LocacaoRepositorio repositorio = new LocacaoRepositorio();

        [Authorize(Roles = "gerente")]
        [HttpGet]
        [Route("mensal/{data}")]
        public IHttpActionResult RelatorioMensal(DateTime data)
        {
            var relatorio = repositorio.ListarRelatorioMensal(data);
            return Ok(new { dados = relatorio });
        }

        [Authorize(Roles = "funcionario, gerente")]
        [HttpGet]
        [Route("atraso")]
        public IHttpActionResult RelatorioAtraso()
        {
            var relatorio = repositorio.ListarRelatorioAtraso();
            return Ok(new { dados = relatorio });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
