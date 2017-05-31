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
    public class AutoresController : ApiController
    {
        private AutorRepositorio _produtoRepositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok();
        }

        public IHttpActionResult Post(Autor autor)
        {
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            return Ok();
        }
    }
}
