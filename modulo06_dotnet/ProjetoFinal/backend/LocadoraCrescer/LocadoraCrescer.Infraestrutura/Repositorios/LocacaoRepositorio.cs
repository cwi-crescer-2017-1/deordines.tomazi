using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class LocacaoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Criar(Locacao locacao)
        {
            contexto.Entry(locacao.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(locacao.Pacote).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(locacao.ProdutoConsole).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Locacao.Add(locacao);
            contexto.SaveChanges();
        }


        public List<Locacao> Listar()
        {
            return contexto.Locacao.Include("Cliente").Include("ProdutoConsole").Include("Pacote").ToList();
        }


        public Locacao BuscarPorId(int id)
        {
            return Listar().FirstOrDefault(x => x.Id == id);
        }

        public Locacao Devolver(Locacao locacao)
        {
            locacao.Devolver();
            contexto.Entry(locacao).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return locacao;
        }

        public List<Locacao> ListarRelatorioMensal(DateTime data)
        {
            var TrintaDiasAntes = data.AddDays(-30);
            return Listar()
                .Where(l => l.DataDevolucao > TrintaDiasAntes && l.DataDevolucao < data)
                .ToList();
        }

        public List<Locacao> ListarRelatorioAtraso()
        {
            var dataAtual = DateTime.Now;
            return Listar()
                .Where(l => l.DataEntrega <= dataAtual && l.DataDevolucao == null)
                .OrderBy(l => l.DataEntrega)
                .ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        private double teste (DateTime dataDevolucao, DateTime dataAtual)
        {
            return (dataDevolucao - dataAtual).TotalDays;
        }
    }
}
