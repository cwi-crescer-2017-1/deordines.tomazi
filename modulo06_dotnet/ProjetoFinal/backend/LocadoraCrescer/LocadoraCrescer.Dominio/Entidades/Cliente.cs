﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }
        public int Nome { get; set; }
        public string Endereco { get; set; }
        public long CPF { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }

        protected Cliente() { }
    }
}
