using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class LocacaoRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(Locacao locacao)
        {
            contexto.Locacao.Add(locacao);
            contexto.SaveChanges();
        }

        public List<Locacao> Listar()
        {
            return contexto.Locacao.ToList();
        }
    }
}
