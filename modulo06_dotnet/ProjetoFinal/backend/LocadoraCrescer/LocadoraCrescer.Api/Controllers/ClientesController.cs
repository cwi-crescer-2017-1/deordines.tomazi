using LocadoraCrescer.Api.Models;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using LocadoraCrescer.WebApi;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.Api.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/clientes")]
    public class ClientesController : ApiController, IDisposable
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        [Authorize(Roles = "funcionario")]
        [HttpGet]
        public IHttpActionResult Listar()
        {
            var clientes = repositorio.Listar();
            return Ok(new { dados = clientes });
        }

        [Authorize(Roles = "funcionario")]
        [HttpPost, Route("registrar")]
        public IHttpActionResult Criar([FromBody]CriarClienteModel model)
        {
            var cliente = new Cliente(model.Nome, model.CPF, model.DataNascimento, model.Endereco, model.Genero);
            repositorio.Criar(cliente);
            return Ok(new { dados = model });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
