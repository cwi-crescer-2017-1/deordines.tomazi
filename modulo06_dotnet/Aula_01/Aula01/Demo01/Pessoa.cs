using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo01
{
    public class Pessoa
    {
        public const double PI = 3.14;
        public readonly double PIreadonly = 3.14;
        
        // readOnly: valor pode ser atribuído somente no instanciamento ou no construtor da classe. Valor inalterado. Somente leitura.
        public readonly double propReadOnly;

        //protected: somente as classes filhas tem acesso.
        protected double propProtected;
        //private: somente a classe tem acesso. Métodos públicos podem acessá-las.
        private double propPrivate;
        public double propPublic;
        internal double propInternal;

        // ctor - gera construtor
        public Pessoa()
        {
            propReadOnly = 5;
        }

        // prop - gera propriedade
        //public int MyProperty { get; set; }

        // ? depois do tipo da variável informa que ela pode ser null
        public int? Id { get; set; }
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}
