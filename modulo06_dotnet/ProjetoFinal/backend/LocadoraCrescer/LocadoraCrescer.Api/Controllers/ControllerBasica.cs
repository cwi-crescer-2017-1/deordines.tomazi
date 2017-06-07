﻿using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
//using LocadoraCrescer.WebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    public class ControllerBasica : ApiController
    {

        public HttpResponseMessage ResponderOK(object dados = null)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { dados });
        }

        public HttpResponseMessage ResponderErro(params string[] mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens });
        }

        public HttpResponseMessage ResponderErro(IEnumerable<string> mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens });
        }
    }
}