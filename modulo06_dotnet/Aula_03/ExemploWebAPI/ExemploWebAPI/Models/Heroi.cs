using System.Collections.Generic;

namespace ExemploWebAPI.Controllers
{
    public class Heroi
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public Poder Poder { get; set; }
    }
}