using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class PacoteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Criar(Pacote pacote)
        {
            contexto.Pacote.Add(pacote);
            contexto.SaveChanges();
        }

        public List<Pacote> Listar()
        {
            return contexto.Pacote.ToList();
        }

        public Pacote BuscarPorId(int id)
        {
            return Listar().FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
