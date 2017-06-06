using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class LocacaoExtraMap : EntityTypeConfiguration<LocacaoExtra>
    {
        public LocacaoExtraMap()
        {
            ToTable("LocacaoExtra");

            HasKey(x => x.Id);

            HasRequired(x => x.Locacao)
                .WithMany()
                .Map(x => x.MapKey("IdLocacao"))
                .WillCascadeOnDelete(false);


            HasRequired(x => x.Extra)
                .WithMany()
                .Map(x => x.MapKey("IdExtra"))
                .WillCascadeOnDelete(false);
        }
    }
}
