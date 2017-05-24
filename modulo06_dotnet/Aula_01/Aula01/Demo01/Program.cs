using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo01
{
    class Program
    {
        static void Main(string[] args)
        {
            // Exemplo 1
            /*
            Pessoa pessoa = new Pessoa();
            var pessoa2 = new Pessoa();

            pessoa.Id = null;
            //pessoa.Nome = "Deórdines Tomazi";
            pessoa.Nome = "Deórdines Tomazi";
            pessoa.DataNascimento = new DateTime(1993, 08, 18);

            if (pessoa.Id == null)
                Console.WriteLine("Não tem valor");

            Console.WriteLine($"{pessoa.Id} - {pessoa.Nome} - {pessoa.DataNascimento}");
            Console.WriteLine(int.MinValue);
            Console.WriteLine(int.MaxValue);
            Console.ReadKey();
            */

            // Exemplo 2
            /*
            Console.WriteLine("Informe sua altura: ");
            var entradaAltura = Console.ReadLine();

            Console.WriteLine("Informe seu peso: ");
            var entradaPeso = Console.ReadLine();

            //var altura = double.Parse(entradaAltura);
            //var peso = double.Parse(entradaPeso);
            var altura = 0D;
            var peso = 0D;

            if (!double.TryParse(entradaAltura, out altura))
                Console.WriteLine("Entrada inválida");

            if (!double.TryParse(entradaPeso, out peso))
                Console.WriteLine("Entrada inválida");

            var calculoIMC = new CalculoIMC(altura, peso);
            var imc = calculoIMC.CalcularIMC();

            Console.WriteLine($"Seu IMC: {imc}");
            */

            // Exercício 1

            var entradasArray = new int[] { };

            while (true)
            {
                Console.Write("Digite um valor: ");
                string entrada = Console.ReadLine();

                if (entrada == "exit")
                {
                    break;
                } else
                {
                    var valor = int.Parse(entrada);
                    var auxArray = new int[entradasArray.Length + 1];
                    
                    for (int i = 0; i < entradasArray.Length; i++)
                        auxArray[i] = entradasArray[i];

                    auxArray[auxArray.Length - 1] = valor;
                    entradasArray = auxArray;
                }
            }

            Console.WriteLine("--- Valores do Array ---");
            foreach (var entrada in entradasArray)
            {
                Console.WriteLine(entrada);
            }

            List<int> entradasList = new List<int>();

            while (true)
            {
                Console.Write("Digite um valor: ");
                string entrada = Console.ReadLine();

                if (entrada == "exit")
                {
                    break;
                }
                else
                {
                    var valor = int.Parse(entrada);
                    entradasList.Add(valor);
                }
            }

            Console.WriteLine("--- Valores da Lista ---");
            foreach (var entrada in entradasList)
            {
                Console.WriteLine(entrada);
            }




            Console.ReadKey();
        }
    }
}
