using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class ExtraMap : EntityTypeConfiguration<Extra>
    {
        public ExtraMap()
        {
            // Somente criar a tabela
            ToTable("Extra");
        }
    }
}
