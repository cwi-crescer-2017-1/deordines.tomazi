using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ExtraRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(Extra extra)
        {
            /*{
                "Nome": "Nome Item",
                "Valor": 9.99,
                "Estoque": 10
            }*/
            contexto.Extra.Add(extra);
            contexto.SaveChanges();
        }

        public List<Extra> Listar()
        {
            return contexto.Extra.ToList();
        }

        public Extra BuscarPorId(int id)
        {
            return Listar().FirstOrDefault(x => x.Id == id);
        }

        public Extra Alugar(Extra extra, int quantidade)
        {
            extra.Alugar(quantidade);
            contexto.Entry(extra).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return extra;
        }

        public Extra Devolver(Extra extra, int quantidade)
        {
            extra.Devolver(quantidade);
            contexto.Entry(extra).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return extra;
        }
    }
}
