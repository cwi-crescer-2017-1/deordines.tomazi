﻿using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
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
        private AutorRepositorio _autorRepositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            var obterAutores = _autorRepositorio.Listar();
            return Ok(obterAutores);
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