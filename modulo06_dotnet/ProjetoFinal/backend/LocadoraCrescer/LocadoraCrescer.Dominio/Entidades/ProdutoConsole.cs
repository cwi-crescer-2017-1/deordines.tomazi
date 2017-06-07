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
        public string Nome { get; set; }
        public decimal Valor { get; set; }
        public int Estoque { get; set; }

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
