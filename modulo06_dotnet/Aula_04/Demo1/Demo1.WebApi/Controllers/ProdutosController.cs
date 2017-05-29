using Demo1.WebApi.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class ProdutosController : ApiController
    {
        public IHttpActionResult Post(Produto produto)
        {
            string stringConexao =
                "Server=13.65.101.67;User Id=deordines.tomazi;PAssword=123456;Database=aluno03db";

            if (produto.Estoque < 1)
            {
                return BadRequest("Quantidade em estoque deve ser maior que 0.");
            }
            else if (produto.Preco < 0.01M)
            {
                return BadRequest("Preço deve ser mais que zero.");
            }
            else if (string.IsNullOrWhiteSpace(produto.Nome))
            {
                return BadRequest("Nome deve ser informado.");
            }

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "INSERT INTO Produto(Nome, Preco, Estoque) VALUES (@nome, @preco, @estoque)";
                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);

                    // Executa o comando e retorna somente a quantidade de linhas afetadas
                    comando.ExecuteNonQuery(); // retorno int

                    // Lê o resultado de um SELECT
                    //comando.ExecuteReader();

                    // Executa o comando e retorna o primeiro resultado
                    //comando.ExecuteScalar();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    // Executa o comando e retorna o primeiro resultado
                    var resultado = (decimal)comando.ExecuteScalar();
                    produto.Id = (int)resultado;
                }
            }

            // String.Empty é uma constante, repsenta uma string vazia é igual abre e fecha aspas
            return Ok(produto);
        }
    }
}
