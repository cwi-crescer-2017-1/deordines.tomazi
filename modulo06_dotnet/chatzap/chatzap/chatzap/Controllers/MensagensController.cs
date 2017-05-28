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
        private static List<Mensagem> Mensagem = new List<Mensagem>();
        private static object objetoLock = new object();

        public IEnumerable<Mensagem> Get(Pessoa usuario, string texto = null)
        {
            //var mensagemAux = new List<Mensagem>()
            //{
            //    new Mensagem() { Usuario = new Pessoa() {Id = 1, Nome = "Deórdines", UrlFoto = "http://" }, Texto = "auhaushaushasu" },
            //    new Mensagem() { Usuario = new Pessoa() {Id = 2, Nome = "Geovane", UrlFoto = "http://" }, Texto = "Eu joguei lolzinho" },
            //    new Mensagem() { Usuario = new Pessoa() {Id = 3, Nome = "Renan", UrlFoto = "http://" }, Texto = "Qualquer coisa haha" },
            //    new Mensagem() { Usuario = new Pessoa() {Id = 4, Nome = "Taiguara", UrlFoto = "http://" }, Texto = "Canalizar poder" }
            //};

            //Mensagem.AddRange(mensagemAux);
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
                    Mensagem.Add(mensagem);

                }
                return Ok();
            }
        }
    }
}
