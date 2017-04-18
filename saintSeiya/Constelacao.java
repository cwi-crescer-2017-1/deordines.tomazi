public class Constelacao
{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
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
    
    public Golpe[] getGolpes()
    {
        return this.golpes;
    }
    
    public void adicionarGolpe(Golpe golpe)
    {
        for(int i = 0; i < golpes.length; i++)
        {
            Golpe golpeAtual = this.golpes[i];
            if (golpeAtual == null)
            {
                this.golpes[i] = golpe;
                break;
            }
        }
    }
    
    public Golpe getGolpe(int indiceGolpe)
    {
        indiceGolpe--;
        return this.golpes[indiceGolpe];
    }
}
