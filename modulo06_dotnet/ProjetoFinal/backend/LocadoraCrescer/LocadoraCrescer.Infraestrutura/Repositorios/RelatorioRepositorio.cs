using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class RelatorioRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
