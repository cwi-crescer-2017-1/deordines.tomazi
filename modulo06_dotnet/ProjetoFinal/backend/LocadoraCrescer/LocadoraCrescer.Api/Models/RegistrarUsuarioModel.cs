﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.WebApi.Models
{
    public class RegistrarUsuarioModel
    {
        public string Email { get; set; }
        public string Nome { get; set; }
        public string Senha { get; set; }
        public string[] Permissao { get; set; }
    }
}