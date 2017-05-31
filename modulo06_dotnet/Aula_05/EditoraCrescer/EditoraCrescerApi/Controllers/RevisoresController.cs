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
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio _revisorRepositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var obterRevisores = _revisorRepositorio.Listar();
            return Ok(obterRevisores);
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            return Ok();
        }
    }
}
