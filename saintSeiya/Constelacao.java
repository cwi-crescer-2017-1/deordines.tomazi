public class Constelacao
{
    private String nome;
    private Golpe[] golpes = new Golpe[2];
    private int qtdGolpes = 0;
    
    public Constelacao(String nome)
    {
        this.nome = nome;
    }
    
    public Constelacao(String nome, Golpe[] golpes) throws Exception
    {
        this.nome = nome;
        this.golpes = golpes;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void adicionarGolpe(Golpe golpe) throws Exception
    {
        if(qtdGolpes < golpes.length)
        {
            this.golpes[qtdGolpes] = golpe;
            qtdGolpes++;
        }
        else
        {
            throw new Exception ("Limite de golpes excedido");
        }
    }
    
    public Golpe getGolpe(int indiceGolpe)
    {
        return this.golpes[indiceGolpe];
    }
    
    public Golpe[] getGolpes()
    {
        return golpes;
    }
}
