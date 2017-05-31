﻿using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = "Server=13.65.101.67;User Id=deordines.tomazi;Password=123456;Database=aluno03db";
        
        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "INSERT INTO Pedido (NomeCliente) VALUES (@nomeCliente)";
                    comando.CommandTimeout = 120;

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    comando.CommandTimeout = 120;

                    var resultado = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)resultado;
                }

                using (var comando = conexao.CreateCommand())
                {
                    foreach (var itemPedido in pedido.Itens)
                    {
                        comando.CommandText = "INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) VALUES (@pedidoId, @produtoId, @quantidade)";
                        comando.CommandTimeout = 120;

                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);

                        comando.ExecuteNonQuery();

                        comando.CommandText = "UPDATE Produto SET Estoque -= @quantidade WHERE Id = @itemProdutoId";

                        comando.Parameters.AddWithValue("@itemProdutoId", itemPedido.ProdutoId);

                        comando.ExecuteNonQuery();

                        comando.Parameters.Clear();
                    }
                }
            }
        }

        public void Alterar(Pedido pedido)
        {
            //using (var conexao = new SqlConnection(stringConexao))
            //{
            //    conexao.Open();

            //    using (var comando = conexao.CreateCommand())
            //    {
            //        comando.CommandText = "UPDATE PEDIDO SET NomeCliente = @nomeCliente WHERE Id = @id";

            //        comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

            //        comando.ExecuteNonQuery();
            //    }
            //}
        }

        public IEnumerable<Pedido> Listar()
        {
            //var pedidos = new List<Pedido>();

            //using (var conexao = new SqlConnection(stringConexao))
            //{
            //    conexao.Open();

            //    using (var comando = conexao.CreateCommand())
            //    {
            //        comando.CommandText = "SELECT Id, NomeCliente, Itens FROM Pedido";

            //        while (comando.ExecuteReader().Read())
            //        {
            //            var pedido = new Pedido()
            //            {
            //                Id = (int)comando.ExecuteReader()["Id"],
            //                NomeCliente = (string)comando.ExecuteReader()["NomeCliente"],
            //                Itens = (List<ItemPedido>)comando.ExecuteReader()["Itens"]
            //            };
            //            pedidos.Add(pedido);
            //        }
            //    }
            //}

            //return pedidos;
            return null;
        }

        public Pedido Obter(int id)
        {
            //Pedido pedido = null;

            //using (var conexao = new SqlConnection(stringConexao))
            //{
            //    using (var comando = conexao.CreateCommand())
            //    {
            //        comando.CommandText = "SELECT Id, NomeCliente, Itens FROM Pedido WHERE Id = @id";

            //        comando.Parameters.AddWithValue("@id", id);

            //        var dataReader = comando.ExecuteReader();
            //        while (dataReader.Read())
            //        {
            //            pedido = new Pedido()
            //            {
            //                Id = (int)dataReader["Id"],
            //                NomeCliente = (string)dataReader["NomeCliente"],
            //                Itens = (List<ItemPedido>)dataReader["Itens"]
            //            };
            //        }
            //    }
            //}

            //return pedido;
            return null;
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    comando.ExecuteNonQuery();
                }
            }
        }
    }
}