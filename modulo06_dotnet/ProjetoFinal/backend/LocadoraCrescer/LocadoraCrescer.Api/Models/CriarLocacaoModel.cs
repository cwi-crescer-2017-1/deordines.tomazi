using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.Api.Models
{
    public class CriarLocacaoModel
    {
        public int IdCliente { get; set; }
        public int IdProdutoConsole { get; set; }
        public int IdPacote { get; set; }
        //public PacoteExtra PacoteExtra { get; set; }
        public DateTime DataPedido { get; set; }
    }
}