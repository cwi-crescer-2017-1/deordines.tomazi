﻿using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ProdutoConsoleRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Criar(ProdutoConsole produto)
        {
            contexto.ProdutoConsole.Add(produto);
            contexto.SaveChanges();
        }

        public List<ProdutoConsole> Listar()
        {
            return contexto.ProdutoConsole.ToList();
        }

        public ProdutoConsole BuscarPorId(int id)
        {
            return Listar().FirstOrDefault(x => x.Id == id);
        }

        public ProdutoConsole Alugar(ProdutoConsole produto)
        {
            produto.Alugar();
            contexto.Entry(produto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return produto;
        }

        public ProdutoConsole Devolver(ProdutoConsole produto)
        {
            produto.Devolver();
            contexto.Entry(produto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return produto;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
