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
    public class LivrosController : ApiController
    {
        private LivroRepositorio _livroRepositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            var obterLivros = _livroRepositorio.Listar();
            return Ok(obterLivros);
        }

        public IHttpActionResult Post(Livro livro)
        {
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            return Ok();
        }
    }
}
