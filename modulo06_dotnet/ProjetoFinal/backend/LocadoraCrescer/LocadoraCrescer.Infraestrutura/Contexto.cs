using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ConnectionString")
        {

        }

        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Extra> Extra { get; set; }
        public DbSet<Locacao> Locacao { get; set; }
        public DbSet<Pacote> Pacote { get; set; }
        public DbSet<ProdutoConsole> ProdutoConsole { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<LocacaoExtra> LocacaoExtra { get; set; }
        public DbSet<PacoteExtra> PacoteExtra { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new ExtraMap());
            modelBuilder.Configurations.Add(new LocacaoMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new ProdutoConsoleMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new LocacaoExtraMap());
            modelBuilder.Configurations.Add(new PacoteExtraMap());
            // base.OnModelCreating(modelBuilder);
        }

    }
}
