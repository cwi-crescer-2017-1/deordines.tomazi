namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDatabase : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.Int(nullable: false),
                        Endereco = c.String(),
                        CPF = c.Long(nullable: false),
                        Genero = c.Byte(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Extra",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Estoque = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        DataEntrega = c.DateTime(nullable: false),
                        DataDevolucao = c.DateTime(),
                        ValorPrevisto = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorFinal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdPacoteExtra = c.Int(nullable: false),
                        IdProdutoConsole = c.Int(nullable: false),
                        IdUsuario = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.PacoteExtra", t => t.IdPacoteExtra, cascadeDelete: true)
                .ForeignKey("dbo.ProdutoConsole", t => t.IdProdutoConsole, cascadeDelete: true)
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacoteExtra)
                .Index(t => t.IdProdutoConsole)
                .Index(t => t.IdUsuario);
            
            CreateTable(
                "dbo.PacoteExtra",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        IdExtra = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Extra", t => t.IdExtra)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .Index(t => t.IdExtra)
                .Index(t => t.IdPacote);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        QuantidadeDias = c.Int(nullable: false),
                        PacoteExtra_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.PacoteExtra", t => t.PacoteExtra_Id)
                .Index(t => t.PacoteExtra_Id);
            
            CreateTable(
                "dbo.ProdutoConsole",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Estoque = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                        Cargo = c.Byte(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.LocacaoExtra",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        IdExtra = c.Int(nullable: false),
                        IdLocacao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Extra", t => t.IdExtra)
                .ForeignKey("dbo.Locacao", t => t.IdLocacao)
                .Index(t => t.IdExtra)
                .Index(t => t.IdLocacao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.LocacaoExtra", "IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.LocacaoExtra", "IdExtra", "dbo.Extra");
            DropForeignKey("dbo.Locacao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Locacao", "IdProdutoConsole", "dbo.ProdutoConsole");
            DropForeignKey("dbo.Locacao", "IdPacoteExtra", "dbo.PacoteExtra");
            DropForeignKey("dbo.PacoteExtra", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.Pacote", "PacoteExtra_Id", "dbo.PacoteExtra");
            DropForeignKey("dbo.PacoteExtra", "IdExtra", "dbo.Extra");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.LocacaoExtra", new[] { "IdLocacao" });
            DropIndex("dbo.LocacaoExtra", new[] { "IdExtra" });
            DropIndex("dbo.Pacote", new[] { "PacoteExtra_Id" });
            DropIndex("dbo.PacoteExtra", new[] { "IdPacote" });
            DropIndex("dbo.PacoteExtra", new[] { "IdExtra" });
            DropIndex("dbo.Locacao", new[] { "IdUsuario" });
            DropIndex("dbo.Locacao", new[] { "IdProdutoConsole" });
            DropIndex("dbo.Locacao", new[] { "IdPacoteExtra" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.LocacaoExtra");
            DropTable("dbo.Usuario");
            DropTable("dbo.ProdutoConsole");
            DropTable("dbo.Pacote");
            DropTable("dbo.PacoteExtra");
            DropTable("dbo.Locacao");
            DropTable("dbo.Extra");
            DropTable("dbo.Cliente");
        }
    }
}
