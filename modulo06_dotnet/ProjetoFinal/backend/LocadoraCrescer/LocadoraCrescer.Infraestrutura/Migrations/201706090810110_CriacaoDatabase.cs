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
                        Nome = c.String(),
                        CPF = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                        Endereco = c.String(),
                        Genero = c.Byte(nullable: false),
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
                        ValorFinal = c.Decimal(precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                        IdProdutoConsole = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.ProdutoConsole", t => t.IdProdutoConsole, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProdutoConsole);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Descricao = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        QuantidadeDias = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
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
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Nome = c.String(),
                        Senha = c.String(),
                        Email = c.String(),
                        Permissao = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.PacoteExtra", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.PacoteExtra", "IdExtra", "dbo.Extra");
            DropForeignKey("dbo.LocacaoExtra", "IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.LocacaoExtra", "IdExtra", "dbo.Extra");
            DropForeignKey("dbo.Locacao", "IdProdutoConsole", "dbo.ProdutoConsole");
            DropForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.PacoteExtra", new[] { "IdPacote" });
            DropIndex("dbo.PacoteExtra", new[] { "IdExtra" });
            DropIndex("dbo.LocacaoExtra", new[] { "IdLocacao" });
            DropIndex("dbo.LocacaoExtra", new[] { "IdExtra" });
            DropIndex("dbo.Locacao", new[] { "IdProdutoConsole" });
            DropIndex("dbo.Locacao", new[] { "IdPacote" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.PacoteExtra");
            DropTable("dbo.LocacaoExtra");
            DropTable("dbo.ProdutoConsole");
            DropTable("dbo.Pacote");
            DropTable("dbo.Locacao");
            DropTable("dbo.Extra");
            DropTable("dbo.Cliente");
        }
    }
}
