using chatzap.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Web.Http;

namespace chatzap.Controllers
{
    public class MensagensController : ApiController
    {
        private static List<Mensagem> Mensagem = new List<Mensagem>();
        private static object objetoLock = new object();

        public IEnumerable<Mensagem> Get(Pessoa usuario, string frase = null)
        {
            return Mensagem;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem.Usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    mensagem.Texto = Regex.Replace(mensagem.Texto, "Andre Nunes", "$$$$$ $$$$$", RegexOptions.IgnoreCase);
                    Mensagem.Add(mensagem);
                }
                return Ok();
            }
        }
    }
}
