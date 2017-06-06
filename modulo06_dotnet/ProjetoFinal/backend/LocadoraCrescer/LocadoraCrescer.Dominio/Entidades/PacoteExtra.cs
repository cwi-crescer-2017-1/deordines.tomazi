using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class PacoteExtra
    {
        public int PacoteExtraId { get; set; }
        public int PacoteId { get; set; }
        public int ExtraId { get; set; }
        public int Quantidade { get; set; }
    }
}
