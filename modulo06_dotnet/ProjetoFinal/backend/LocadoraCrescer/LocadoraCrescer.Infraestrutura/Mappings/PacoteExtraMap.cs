using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class PacoteExtraMap : EntityTypeConfiguration<PacoteExtra>
    {
        public PacoteExtraMap()
        {
            ToTable("PacoteExtra");

            HasKey(x => x.Id);

            HasRequired(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"))
                .WillCascadeOnDelete(false);


            HasRequired(x => x.Extra)
                .WithMany()
                .Map(x => x.MapKey("IdExtra"))
                .WillCascadeOnDelete(false);

        }
    }
}
