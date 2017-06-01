using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(string nome)
        {
            var revisor = new Revisor()
            {
                Nome = nome
            };
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor ObterRevisor(int id)
        {
            return contexto.Revisores.FirstOrDefault(x => x.Id == id);
        }

        public void AlterarRevisor(int id, Revisor revisor)
        {
            if (id != revisor.Id)
                return;

            contexto.Entry(revisor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Excluir(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }
    }
}