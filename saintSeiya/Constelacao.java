public class Constelacao
{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int qtdGolpesAprendidos = 0;
    
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
        this.golpes[qtdGolpesAprendidos] = golpe;
        this.qtdGolpesAprendidos++;
    }
    
    public Golpe getGolpe(int indiceGolpe)
    {
        indiceGolpe--;
        return this.golpes[indiceGolpe];
    }
}
