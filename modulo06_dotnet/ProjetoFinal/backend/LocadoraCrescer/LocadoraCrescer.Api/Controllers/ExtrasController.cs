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
    [RoutePrefix("api/extras")]
    public class ExtrasController : ApiController
    {
        private ExtraRepositorio repositorio = new ExtraRepositorio();

        [HttpGet]
        public IHttpActionResult Listar()
        {
            var extras = repositorio.Listar();
            return Ok(new { dados = extras });
        }

        [HttpGet]
        public IHttpActionResult BuscarPorId(int id)
        {
            var extra = repositorio.BuscarPorId(id);
            return Ok(new { dados = extra });
        }

        [HttpPost]
        public IHttpActionResult Criar(Extra extra)
        {
            repositorio.Criar(extra.Nome, extra.Valor, extra.Estoque);
            return Ok(new { dados = extra });
        }

        [HttpPut]
        [Route("alugar/{id}")]
        public IHttpActionResult Alugar(int id, int quantidade)
        {
            var extra = repositorio.BuscarPorId(id);

            if (!extra.ValidarEstoque())
                return BadRequest();

            repositorio.Alugar(extra, quantidade);

            return Ok(new { dados = extra });
        }

        [HttpPut]
        [Route("devolver/{id}")]
        public IHttpActionResult Devolver(int id, int quantidade)
        {
            var extra = repositorio.BuscarPorId(id);

            repositorio.Devolver(extra, quantidade);

            return Ok(new { dados = extra });
        }
    }
}
