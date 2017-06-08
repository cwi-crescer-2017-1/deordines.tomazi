using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.Api.Models
{
    public class CriarPacoteModel
    {
        public string Nome { get; set; }
        public string Descricao { get; set; }
        public decimal Valor { get; set; }
        //public int PacoteExtra { get; set; }
        public int QuantidadeDias { get; set; }

    }
}