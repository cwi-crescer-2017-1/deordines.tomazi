using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Criar(Livro livro)
        {
            livro.DataPublicacao = DateTime.Now;
            livro.DataRevisao = DateTime.Now;
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public List<Livro> Listar()
        {
            return contexto.Livros.ToList();
        }

        public Livro ObterLivro(int isbn)
        {
            return contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros.Where(x => x.Genero.Contains(genero)).ToList();
        }

        public void AlterarLivro(Livro livro)
        {
            var isbn = livro.Isbn;
            Livro aux = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            aux.Descricao = livro.Descricao;
            contexto.Entry(aux).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Excluir(int isbn)
        {
            var livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
