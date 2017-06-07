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
    [RoutePrefix("api/clientes")]
    public class ClientesController : ApiController
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        [HttpGet]
        public IHttpActionResult Listar()
        {
            var clientes = repositorio.Listar();
            return Ok(new { dados = clientes });
        }

        [HttpPost]
        public IHttpActionResult Criar(Cliente cliente)
        {
            repositorio.Criar(cliente.Nome, cliente.CPF, cliente.DataNascimento, cliente.Endereco, cliente.Genero);
            return Ok(new { dados = cliente });
        }
    }
}
