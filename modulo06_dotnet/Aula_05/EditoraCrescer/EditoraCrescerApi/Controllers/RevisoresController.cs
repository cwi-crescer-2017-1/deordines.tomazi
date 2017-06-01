using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio _revisorRepositorio = new RevisorRepositorio();

        [HttpGet]
        public IHttpActionResult ListarRevisores()
        {
            var obterRevisores = _revisorRepositorio.Listar();
            return Ok(new { dados = obterRevisores });
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterRevisor(int id)
        {
            var obterRevisor = _revisorRepositorio.ObterRevisor(id);
            return Ok(new { dados = obterRevisor });
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult AlterarRevisor(int id, Revisor revisor)
        {
            _revisorRepositorio.AlterarRevisor(id, revisor);
            return Ok(new { dados = revisor });
        }

        [HttpPost]
        public IHttpActionResult CriarRevisor(Revisor revisor)
        {
            _revisorRepositorio.Criar(revisor.Nome);
            return Ok();
        }

        [HttpDelete]
        [Route("{id}")]
        public IHttpActionResult DeletarLivro(int id)
        {
            _revisorRepositorio.Excluir(id);
            return Ok();
        }
    }
}
