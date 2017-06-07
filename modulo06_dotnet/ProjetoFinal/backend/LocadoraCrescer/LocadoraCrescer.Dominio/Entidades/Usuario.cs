using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Senha { get; set; }
        public string Email { get; set; }

        protected Usuario() { }

        public Usuario(string nome, string senha, string email)
        {
            Nome = nome;
            Email = email;
            Senha = senha;
        }
    }
}
