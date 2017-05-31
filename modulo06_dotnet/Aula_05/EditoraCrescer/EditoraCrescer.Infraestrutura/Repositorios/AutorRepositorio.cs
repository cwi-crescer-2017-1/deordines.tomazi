using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(string nome)
        {
            var autor = new Autor()
            {
                Nome = nome
            };
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public void Excluir(int id)
        {
            var autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }
    }
}