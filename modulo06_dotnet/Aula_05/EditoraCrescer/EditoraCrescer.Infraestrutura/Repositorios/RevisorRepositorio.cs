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

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
        }

        public void Excluir(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }
    }
}