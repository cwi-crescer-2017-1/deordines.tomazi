using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Extra
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public decimal Valor { get; private set; }
        public int Estoque { get; private set; }

        protected Extra() { }

        public Extra(string nome, decimal valor, int estoque)
        {
            Nome = nome;
            Valor = valor;
            Estoque = estoque;
        }

        public void Alugar(int quantidade)
        {
            Estoque -= quantidade;
        }

        public void Devolver(int quantidade)
        {
            Estoque += quantidade;
        }

        public bool ValidarEstoque()
        {
            return Estoque > 0;
        }
    }
}
