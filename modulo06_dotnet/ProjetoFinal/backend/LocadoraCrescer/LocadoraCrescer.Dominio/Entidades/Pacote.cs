using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public PacoteExtra PacoteExtra { get; set; }
        public int QuantidadeDias { get; set; }

        protected Pacote() { }

        public Pacote(string nome, PacoteExtra pacoteExtra, int quantidadeDias)
        {
            Nome = nome;
            PacoteExtra = pacoteExtra;
            QuantidadeDias = quantidadeDias;
        }
    }
}
