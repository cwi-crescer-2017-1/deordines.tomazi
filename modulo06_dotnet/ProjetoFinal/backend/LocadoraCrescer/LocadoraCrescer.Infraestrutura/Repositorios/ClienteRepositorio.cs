using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ClienteRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(string nome, string cpf, DateTime dataNascimento, string endereco, Genero genero)
        {
            /*{
                "Nome": "Nome Cliente",
                "CPF": 01234567890,
                "DataNascimento": "1990-01-01",
                "Endereco": "Av. de Teste, 0123",
                "Genero": 0 - 1 - 2
            }*/
            var cliente = new Cliente(nome, cpf, dataNascimento, endereco, genero);
            contexto.Cliente.Add(cliente);
            contexto.SaveChanges();
        }

        public List<Cliente> Listar()
        {
            return contexto.Cliente.ToList();
        }
    }
}
