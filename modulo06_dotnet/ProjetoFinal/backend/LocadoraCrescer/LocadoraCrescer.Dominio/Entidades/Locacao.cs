using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Locacao
    {
        public int Id { get; private set; }
        public Usuario Usuario { get; private set; }
        public Cliente Cliente { get; private set; }
        public ProdutoConsole ProdutoConsole { get; private set; }
        public Pacote Pacote { get; private set; }
        //public Extra Extra { get; set; }
        //public PacoteExtra PacoteExtra { get; private set; 
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntrega { get; private set; }
        public DateTime? DataDevolucao { get; private set; }
        public decimal ValorPrevisto { get; private set; }
        public decimal ValorFinal { get; private set; }

        protected Locacao() { }

        public Locacao(Usuario usuario, Cliente cliente, ProdutoConsole produto, Pacote pacote/*PacoteExtra pacote*/)
        {
            Usuario = usuario;
            Cliente = cliente;
            ProdutoConsole = produto;
            Pacote = pacote;
            //PacoteExtra = pacote;
        }
    }
}
