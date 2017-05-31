using EditoraCrescer.Api.Repositorios;
using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisorController : ApiController
    {
        private RevisorRepositorio _revisorRepositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok();
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
