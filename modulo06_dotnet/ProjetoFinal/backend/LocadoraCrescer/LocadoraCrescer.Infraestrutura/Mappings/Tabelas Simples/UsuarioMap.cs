﻿using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            // Somente criar a tabela
            ToTable("Usuario");

            //HasMany(x => x.Permissoes)
            //    .WithMany()
            //    .Map(x =>
            //    {
            //        x.MapLeftKey("IdUsuario");
            //        x.MapRightKey("IdPermissao");
            //        x.ToTable("UsuarioPermissao");
            //    });
        }
    }
}
