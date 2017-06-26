namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using LocadoraCrescer.Dominio.Entidades;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<LocadoraCrescer.Infraestrutura.Contexto>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(LocadoraCrescer.Infraestrutura.Contexto context)
        {
            context.Cliente.AddOrUpdate(x => x.Id,
                new Cliente("Cliente 1", "1", new DateTime(1990, 01, 01), "Rua 1", Genero.MASCULINO),
                new Cliente("Cliente 2", "2", new DateTime(1990, 01, 01), "Rua 2", Genero.FEMININO),
                new Cliente("Cliente 3", "3", new DateTime(1990, 01, 01), "Rua 3", Genero.NAOINFORMADO),
                new Cliente("Cliente 4", "4", new DateTime(1990, 01, 01), "Rua 4", Genero.MASCULINO),
                new Cliente("Cliente 5", "5", new DateTime(1990, 01, 01), "Rua 5", Genero.FEMININO),
                new Cliente("Cliente 6", "6", new DateTime(1990, 01, 01), "Rua 6", Genero.NAOINFORMADO),
                new Cliente("Cliente 7", "7", new DateTime(1990, 01, 01), "Rua 7", Genero.MASCULINO),
                new Cliente("Cliente 8", "8", new DateTime(1990, 01, 01), "Rua 8", Genero.FEMININO),
                new Cliente("Cliente 9", "9", new DateTime(1990, 01, 01), "Rua 9", Genero.NAOINFORMADO),
                new Cliente("Cliente 10", "10", new DateTime(1990, 01, 01), "Rua 10", Genero.NAOINFORMADO)
                );

            context.ProdutoConsole.AddOrUpdate(x => x.Id,
                new ProdutoConsole("PS3", 500m, 100),
                new ProdutoConsole("SNES", 100m, 100),
                new ProdutoConsole("XBOX 360", 350m, 100),
                new ProdutoConsole("ATARI", 100m, 100)
                );

            context.Extra.AddOrUpdate(x => x.Id,
                new Extra("Jogo", 10m, 100),
                new Extra("Memory Card", 20m, 100),
                new Extra("Controle", 15m, 100),
                new Extra("Guia de Cheat", 30m, 100)
                );

            context.Pacote.AddOrUpdate(x => x.Id,
                new Pacote("Diário", "1 jogo e 1 controle", 25, 1),
                new Pacote("Finde", "2 jogos e 1 controle", 50, 2),
                new Pacote("Semanal", "5 jogos, 2 controles e 1 memory card", 75, 7)
                );

            context.Usuario.AddOrUpdate(x => x.Id,
                new Usuario("Funcionario", "123", "funcionario@cwi", "funcionario"),
                new Usuario("Gerente", "123", "gerente@cwi", "gerente")
                );

            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //
        }
    }
}
