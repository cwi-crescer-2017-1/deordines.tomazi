public class Armadura
{
    private String nome;
    private Categoria categoria;
    
    public Armadura(String nome, Categoria categoria)
    {
        this.nome = nome;
        this.categoria = categoria;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public Categoria getCategoria()
    {
        return this.categoria;
    }
}