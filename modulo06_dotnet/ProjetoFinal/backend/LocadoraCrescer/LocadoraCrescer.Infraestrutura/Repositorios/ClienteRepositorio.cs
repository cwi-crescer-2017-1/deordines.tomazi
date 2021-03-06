﻿using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Criar(Cliente cliente)
        {
            /*{
                "Nome": "Nome Cliente",
                "CPF": 01234567890,
                "DataNascimento": "1990-01-01",
                "Endereco": "Av. de Teste, 0123",
                "Genero": 0 - 1 - 2
            }*/
            //var cliente = new Cliente(nome, cpf, dataNascimento, endereco, genero);
            contexto.Cliente.Add(cliente);
            contexto.SaveChanges();
        }

        public List<Cliente> Listar()
        {
            return contexto.Cliente.ToList();
        }

        public Cliente BuscarPorId(int id)
        {
            return Listar().FirstOrDefault(x => x.Id == id);
        }

        public Cliente BuscarPorCpf(string cpf)
        {
            return Listar().FirstOrDefault(x => x.CPF == cpf);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
