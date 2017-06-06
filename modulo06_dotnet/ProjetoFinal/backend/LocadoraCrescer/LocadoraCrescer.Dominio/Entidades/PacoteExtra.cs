using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class PacoteExtra
    {
        public int Id { get; set; }
        public Pacote Pacote { get; set; }
        public Extra Extra { get; set; }
        public int Quantidade { get; set; }
    }
}
