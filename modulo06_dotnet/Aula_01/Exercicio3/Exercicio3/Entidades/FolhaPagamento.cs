using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3.Entidades
{
    class FolhaPagamento : IFolhaPagamento
    {
        private readonly double aliquota = 0.11;

        public Demonstrativo GerarDemonstrativo(double salarioBase, double horasCategoria, double horasExtras, double horasDescontadas)
        {
            double valorHora = ValorHora(salarioBase, horasCategoria);
            HorasCalculadas horaExtra = new HorasCalculadas(horasExtras, ValorTotalHoras(horasExtras));
            HorasCalculadas horaDescontada = new HorasCalculadas(horasDescontadas, ValorTotalHoras(horasDescontadas));
            double proventos = TotalProventos(salarioBase, horaExtra.ValorTotalHoras, horaDescontada.ValorTotalHoras);
            Desconto inss = Inss(proventos);
            Desconto irrf = Irrf(proventos - inss.Valor);
            double descontos = TotalDescontos(inss.Valor, irrf.Valor);
            double valorLiquido = SalarioLiquido(proventos, descontos);
            Desconto fgts = Fgts(aliquota, proventos);

            double ValorTotalHoras(double horas)
            {
                return valorHora * horas;
            }

            return new Demonstrativo(salarioBase, horasCategoria, horaExtra, horaDescontada, proventos, inss, irrf, descontos, valorLiquido, fgts);
            //return new Demonstrativo(salarioBase, horasCategoria, horasExtras, horasDescontadas, TotalProventos, valorInss, valorIrrf, valorDescontos, salarioLiquido, 11);
        }

        // Valor Hora: é o Salário-base dividido pelo número de horas estabelecido pela convenção.
        public double ValorHora(double salarioBase, double horaCategoria)
        {
            return salarioBase / horaCategoria;
        }

        // Total Horas Extras e Total Horas Descontadas: quantidade de horas extras ou descontadas multiplicados pelo Valor Hora.
        //public double ValorTotalHoras(double valorHora, double horas)
        //{
        //    return valorHora * horas;
        //}

        // Total de Proventos: A soma do Salário-base + Total Horas Extras - Total Horas Descontadas.
        public double TotalProventos(double salarioBase, double valorTotalHorasExtras, double valorTotalHorasDescontadas)
        {
            return salarioBase + valorTotalHorasExtras - valorTotalHorasDescontadas;
        }

        // INSS: Calcule o INSS com base no Total de Proventos e aplique a alíquota conforme as faixas salariais: Até R$1000,00 utilize 8%, até R$1500,00 9% e acima disso 10%.
        public Desconto Inss(double totalProventos)
        {
            double aliquota = 0;
            if (totalProventos <= 1000)
                aliquota = 0.08;
            else if (totalProventos > 1000 && totalProventos <= 1500)
                aliquota = 0.09;
            else
                aliquota = 0.1;

            var valor = totalProventos * aliquota;
            //string converter = calculo.ToString("R");

            //calculo = Math.Round(calculo, 2);

            return new Desconto(aliquota, Truncate(valor));
        }

        // Imposto de renda retido na fonte (IRRF): Considere como base cálculo o Total de Proventos deduzido o INSS. Aplique a aliquota conforme as faixas: até R$1710.78 isento, até R$2563.91 7,5%, até R$3418.59 15%, até R$4271.59 22,5% e acima disso 27,5%.
        public Desconto Irrf(double totalProventos)
        {
            double aliquota = 0;
            if (totalProventos <= 1710.78)
                aliquota = 0;
            else if (totalProventos > 1710.78 && totalProventos <= 2563.91)
                aliquota = 0.075;
            else if (totalProventos > 2563.91 && totalProventos <= 3418.59)
                aliquota = 0.15;
            else if (totalProventos > 3418.59 && totalProventos <= 4271.59)
                aliquota = 0.225;
            else
                aliquota = 0.275;

            var valor = totalProventos * aliquota;

            return new Desconto (aliquota, Truncate(valor));
        }

        // Total de descontos:é a soma do INSS e do IRRF.
        public double TotalDescontos(double inss, double irrf)
        {
            return inss + irrf;
        }

        // Salário líquido: A remuneração a ser repassada (transferida) para o colaborador. Para o cálculo some o Total de Proventos - Total de Descontos.
        public double SalarioLiquido(double totalProventos, double totalDescontos)
        {
            return Truncate(totalProventos - totalDescontos);
        }

        // FGTS: Fundo de garantia sobre tempo de serviço deve ser apenas discriminado 11% fixo.
        public Desconto Fgts(double aliquota, double totalProventos)
        {
            var valor = totalProventos * aliquota;

            return new Desconto(aliquota, Truncate(valor));
        }

        public double Truncate (double valor)
        {
            return Math.Truncate(valor * 100) / 100;
        }
    }
}
