using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Locacao
    {
        public int Id { get; set; }
        public Usuario Usuario { get; set; }
        public Cliente Cliente { get; set; }
        public ProdutoConsole ProdutoConsole { get; set; }
        public PacoteExtra PacoteExtra { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal ValorFinal { get; set; }

        protected Locacao() { }

        public Locacao(Usuario usuario, Cliente cliente, ProdutoConsole produto, PacoteExtra pacote)
        {
            Usuario = usuario;
            Cliente = cliente;
            ProdutoConsole = produto;
            PacoteExtra = pacote;
        }
    }
}
