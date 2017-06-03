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
        private List<Livro> livrosPublicados = new List<Livro>();

        public void Criar(Livro livro)
        {
            //livro.DataPublicacao = DateTime.Now;
            //livro.DataRevisao = DateTime.Now;
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public dynamic Listar()
        {
            return contexto.Livros
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

        public dynamic ListarLivrosPaginados(int quantidadePular, int quantidadeTrazer)
        {
            livrosPublicados = contexto.Livros.ToList();

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
                quantidadeTotal = QuantidadeLivrosPublicados()
            };
        }

        public int QuantidadeLivrosPublicados()
        {
            return livrosPublicados.Count();
        }

        public Livro ObterLivro(int isbn)
        {
            return contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
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

        public dynamic ObterPorLancamento()
        {
            return contexto.Livros
                //.Where(x => (DateTime.Now - x.DataPublicacao).TotalDays <= 7)
                .Where(x => System.Data.Entity.SqlServer.SqlFunctions.DateDiff("day", x.DataPublicacao, DateTime.Now) <= 7)
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
