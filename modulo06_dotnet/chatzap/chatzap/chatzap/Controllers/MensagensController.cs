using chatzap.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace chatzap.Controllers
{
    public class MensagensController : ApiController
    {
        private List<Mensagem> Mensagem = new List<Mensagem>();
        private static object objetoLock = new object();

        public IEnumerable<Mensagem> Get(Pessoa usuario, string frase = null)
        {
            return Mensagem;
        }

        public IHttpActionResult Post(Pessoa usuario, Mensagem mensagem)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    Mensagem.Add(mensagem);
                    mensagem.Usuario = usuario;

                }
                return Ok();
            }
        }
    }
}
