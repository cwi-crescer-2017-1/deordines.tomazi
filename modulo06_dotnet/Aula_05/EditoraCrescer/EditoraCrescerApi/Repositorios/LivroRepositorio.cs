﻿using EditoraCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Repositorios
{
    public class LivroRepositorio : ApiController
    {
        private Contexto contexto = new Contexto();
    }
}
