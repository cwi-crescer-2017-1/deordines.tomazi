﻿using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class ProdutoConsoleMap : EntityTypeConfiguration<ProdutoConsole>
    {
        public ProdutoConsoleMap()
        {
            // Somente criar a tabela
            ToTable("ProdutoConsole");
        }
    }
}
