using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class LocacaoExtra
    {
        public int LocacaoExtraId { get; set; }
        public int LocacaoId { get; set; }
        public int ExtraId { get; set; }
        public int Quantidade { get; set; }
    }
}
