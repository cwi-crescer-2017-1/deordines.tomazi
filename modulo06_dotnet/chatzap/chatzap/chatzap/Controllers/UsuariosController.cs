using chatzap.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace chatzap.Controllers
{
    public class UsuariosController : ApiController
    {
        private static int UltimoId = 0;
        private static List<Pessoa> Usuarios = new List<Pessoa>();
        private static object objetoLock = new object();

        public IEnumerable<Pessoa> Get(string nome = null, int? id = null)
        {
            //var usuarioAux = new List<Pessoa>()
            //{
            //    new Pessoa() { Id = ++UltimoId, Nome = "Deórdines" },
            //    new Pessoa() { Id = ++UltimoId, Nome = "Geovane" },
            //    new Pessoa() { Id = ++UltimoId, Nome = "Renan" },
            //    new Pessoa() { Id = ++UltimoId, Nome = "Taiguara" }
            //};

            //Usuarios.AddRange(usuarioAux);
            return Usuarios;
        }

        public IHttpActionResult Post(Pessoa usuario)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    Usuarios.Add(usuario);
                    usuario.Id = ++UltimoId;
                }
                return Ok();
            }
        }
    }
}
