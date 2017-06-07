namespace LocadoraCrescer.Dominio.Entidades
{
    public class Permissao
    {
        public int Id { get; set; }
        public string Nome { get; private set; }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}