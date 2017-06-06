using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacote");

            HasMany(x => x.Itens)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("PacoteId");
                    x.MapRightKey("ExtraId");
                    x.ToTable("ExtraPAcote");
                });
        }
    }
}
