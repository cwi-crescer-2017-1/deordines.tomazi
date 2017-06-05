using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.SqlServer;
using System.Linq;
using System.Linq.Expressions;
using System.Web;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        private List<Livro> livrosPublicados = new List<Livro>();

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public dynamic ListarTodosOsLivros()
        {
            var data = DateTime.Now.AddDays(-7);

            return contexto.Livros
                .Where(livro => livro.DataPublicacao < data)
                .Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor,
                    ObterPorGenero = x.Genero
                })
                .ToList();
        }

        public dynamic ListarTodosOsLancamentos()
        {
            var data = DateTime.Now.AddDays(-7);

            return contexto.Livros
                .Where(livro => livro.DataPublicacao > data)
                .Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor,
                    ObterPorGenero = x.Genero
                })
                .ToList();
        }

        public dynamic ListarLivrosPaginadosExcetoLancamentos(int quantidadePular, int quantidadeTrazer)
        {
            var data = DateTime.Now.AddDays(-7);
            livrosPublicados = contexto.Livros
                .Where(livro => livro.DataPublicacao != null && livro.DataPublicacao < data)
                .ToList();

            var livrosPaginados = livrosPublicados
                .Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor,
                    Genero = x.Genero
                })
                .OrderBy(a => a.Isbn)
                .Skip(quantidadePular)
                .Take(quantidadeTrazer)
                .ToList();

            return new
            {
                livros = livrosPaginados.ToList(),
                quantidadeTotal = Quantidade(livrosPublicados)
            };
        }

        public dynamic ListarLivrosPaginadosPorLancamento(int quantidadePular, int quantidadeTrazer)
        {
            var data = DateTime.Now.AddDays(-7);
            livrosPublicados = contexto.Livros
                .Where(livro => livro.DataPublicacao != null && livro.DataPublicacao > data)
                .ToList();

            var livrosPaginados = livrosPublicados
                .Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor,
                    ObterPorGenero = x.Genero
                })
                .OrderBy(livro => livro.Isbn)
                .Skip(quantidadePular)
                .Take(quantidadeTrazer)
                .ToList();

            return new
            {
                livros = livrosPaginados.ToList(),
                quantidadeTotal = Quantidade(livrosPublicados)
            };
        }

        public int Quantidade(List<Livro> livro)
        {
            return livro.Count();
        }

        public Livro ObterLivro(int isbn)
        {
            return contexto.Livros.Include("Autor").FirstOrDefault(x => x.Isbn == isbn);
        }

        public dynamic ObterPorGenero(string genero)
        {
            return contexto.Livros
                .Where(x => x.Genero.Contains(genero))
                .Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor,
                    ObterPorGenero = x.Genero
                })
                .ToList();
        }

        public void AlterarLivro(int isbn, Livro livro)
        {
            if (isbn != livro.Isbn)
                return;

            //Livro aux = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            //aux = livro;
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
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
