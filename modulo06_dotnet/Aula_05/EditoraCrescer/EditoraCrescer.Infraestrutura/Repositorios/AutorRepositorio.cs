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

        public Autor ObterAutor(int id)
        {
            return contexto.Autores.FirstOrDefault(x => x.Id == id);
        }

        public List<Livro> ObterLivrosDoAutor(int id)
        {
            return contexto.Livros.Where(x => x.IdAutor == id).ToList();
        }

        public void AlterarAutor(int id, Autor autor)
        {
            if (id != autor.Id)
                return;

            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Excluir(int id)
        {
            var autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }
    }
}