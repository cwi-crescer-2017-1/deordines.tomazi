public class Armadura
{
    private Constelacao constelacao;
    private Categoria categoria;
    
    public Armadura(Constelacao constelacao, Categoria categoria)
    {
        this.constelacao = constelacao;
        this.categoria = categoria;
    }
    
    public String getNome()
    {
        return this.constelacao.getNome();
    }
    
    public Categoria getCategoria()
    {
        return this.categoria;
    }
    
    /*public Constelacao getGolpesConstelacao()
    {
        return this.constelacao.getGolpes();
    }*/
}