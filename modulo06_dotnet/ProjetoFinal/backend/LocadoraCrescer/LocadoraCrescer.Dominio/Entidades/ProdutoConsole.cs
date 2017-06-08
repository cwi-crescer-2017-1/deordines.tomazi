using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class ProdutoConsole
    {
        public int Id { get; set; }
        public string Nome { get; private set; }
        public decimal Valor { get; private set; }
        public int Estoque { get; private set; }

        protected ProdutoConsole() { }

        public ProdutoConsole(string nome, decimal valor, int estoque)
        {
            Nome = nome;
            Valor = valor;
            Estoque = estoque;
        }

        public void Alugar()
        {
            Estoque--;
        }

        public void Devolver()
        {
            Estoque++;
        }

        public bool ValidarEstoque()
        {
            return Estoque > 0;
        }
    }
}
