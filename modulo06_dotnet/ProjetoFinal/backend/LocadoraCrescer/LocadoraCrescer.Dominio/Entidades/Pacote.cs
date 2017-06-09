using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Descricao { get; private set; }
        //public PacoteExtra PacoteExtra { get; private set; }
        public decimal Valor { get; private set; }
        public int QuantidadeDias { get; private set; }

        protected Pacote() { }

        public Pacote(string nome, string descricao, decimal valor, /*PacoteExtra pacoteExtra,*/ int quantidadeDias)
        {
            Nome = nome;
            Descricao = descricao;
            Valor = valor;
            //PacoteExtra = pacoteExtra;
            QuantidadeDias = quantidadeDias;
        }
    }
}
