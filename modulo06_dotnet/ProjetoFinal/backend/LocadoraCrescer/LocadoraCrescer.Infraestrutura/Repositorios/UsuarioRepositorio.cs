using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Criar(Usuario usuario)
        {
            contexto.Usuario.Add(usuario);
            contexto.SaveChanges();
        }

        //public void Alterar(Usuario usuario)
        //{
        //    var novoUsuario = usuario;
        //}

        public void Excluir(Usuario usuario)
        {
            var u = Listar().FirstOrDefault(x => x.Id == usuario.Id);
            contexto.Usuario.Remove(u);
            contexto.SaveChanges();
        }

        public List<Usuario> Listar()
        {
            return contexto.Usuario.ToList();
        }
        
        public Usuario Obter(string email)
        {
            return contexto.Usuario.FirstOrDefault(x => x.Email.Equals(email));
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
