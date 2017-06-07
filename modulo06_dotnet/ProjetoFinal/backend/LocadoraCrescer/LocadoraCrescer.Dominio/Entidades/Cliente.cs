using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Endereco { get; private set; }
        public long CPF { get; private set; }
        public Genero Genero { get; private set; }
        public DateTime DataNascimento { get; private set; }

        protected Cliente() { }

        public Cliente(string nome, string endereco, long cpf, Genero genero, DateTime dataNascimento)
        {
            Nome = nome;
            Endereco = endereco;
            CPF = cpf;
            Genero = genero;
            DataNascimento = dataNascimento;
        }

        
    }
}
