using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebAPI.Controllers
{
    // Controller trata requisições http

    public class HeroisController : ApiController
    {
        private static int UltimoId = 0;
        private static List<Heroi> Herois = new List<Heroi>();
        private static object objetoLock = new object();

        public IEnumerable<Heroi> Get(string nome = null, int? id = null)
        {
            //var heroisAux = new List<Heroi>()
            //{
            //    new Heroi()
            //    {
            //        Id = 1,
            //        Nome = "Goku",
            //        Poder = new Poder()
            //        {
            //            Nome = "Kamehameha", Dano = 8000
            //        }
            //    },
            //    new Heroi() { Id = 2, Nome = "Uchiha Madara", Poder = new Poder() { Nome = "Susanoo", Dano = 8000 } },
            //    new Heroi() { Id = 3, Nome = "Seiya", Poder = new Poder() { Nome = "Meteoro de Pégaso", Dano = 8000 } },
            //    new Heroi() { Id = 4, Nome = "Kurosaki Ichigo", Poder = new Poder() { Nome = "Getsuga Tenshou", Dano = 8000 } },
            //    new Heroi() { Id = 5, Nome = "Null", Poder = new Poder() { Nome = "Null", Dano = 8000 } }
            //};

            //herois.AddRange(heroisAux);

            //if (id == null)
            //    return herois;
            //else
            //    return herois.Where(x => x.Nome == id);

            //return herois.Where(x => (x == null || x.Id == id) && (x.Nome == null || x.Nome == nome));

            return Herois;
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    Herois.Add(heroi);
                    heroi.Id = ++UltimoId;
                }
                return Ok();
            }
        }
    }
}
