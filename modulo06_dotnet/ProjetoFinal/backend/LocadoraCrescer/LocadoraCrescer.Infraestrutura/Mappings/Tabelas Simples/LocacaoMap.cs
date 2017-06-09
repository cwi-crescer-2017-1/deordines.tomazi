using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");

            // http://www.entityframeworktutorial.net/code-first/configure-many-to-many-relationship-in-code-first.aspx
            //HasMany(x => x.Itens)
            //    .WithMany()
            //    .Map(x =>
            //    {
            //        x.MapLeftKey("LocacaoId");
            //        x.MapRightKey("ExtraId");
            //        x.ToTable("ExtraLocacao");
            //    });

            //HasRequired(x => x.Usuario)
            //    .WithMany()
            //    .Map(x => x.MapKey("IdUsuario"));

            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));

            HasRequired(x => x.ProdutoConsole)
                .WithMany()
                .Map(x => x.MapKey("IdProdutoConsole"));

            //HasRequired(x => x.PacoteExtra)
            //    .WithMany()
            //    .Map(x => x.MapKey("IdPacoteExtra"));

            HasRequired(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));
        }
    }
}
