using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.Api.Models
{
    public class CriarProdutoModel
    {
        public string Nome { get; set; }
        public decimal Valor { get; set; }
        public int Estoque { get; set; }
    }
}