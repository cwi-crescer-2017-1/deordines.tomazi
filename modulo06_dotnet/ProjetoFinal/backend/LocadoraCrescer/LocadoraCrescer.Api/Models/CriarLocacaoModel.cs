using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.Api.Models
{
    public class CriarLocacaoModel
    {
        public Usuario Usuario { get; set; }
        public Cliente Cliente { get; set; }
        public ProdutoConsole ProdutoConsole { get; set; }
        public Pacote Pacote { get; set; }
        //public PacoteExtra PacoteExtra { get; set; }
        public DateTime DataPedido { get; set; }
    }
}