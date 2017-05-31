using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio
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

        public void Excluir(int isbn)
        {
            var livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }
    }
}
