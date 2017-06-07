using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class LocacaoExtra
    {
        public int Id { get; set; }
        public Locacao Locacao { get; set; }
        public Extra Extra { get; set; }
        public int Quantidade { get; set; }

        protected LocacaoExtra() { }

        public LocacaoExtra(Locacao locacao, Extra extra, int quantidade)
        {
            Locacao = locacao;
            Extra = extra;
            Quantidade = quantidade;
        }
    }
}
