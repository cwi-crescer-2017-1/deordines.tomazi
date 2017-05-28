using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace chatzap.Models
{
    public class Mensagem
    {
        public Pessoa Usuario { get; set; }
        public string Texto { get; set; }
    }
}