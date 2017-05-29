using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Demo1.WebApi.Models
{
    public class Produto
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public int Estoque { get; set; }

    }
}