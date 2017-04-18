public class Constelacao
{
    private String nome;
    private Golpe[] golpe = new Golpe[3];
    
    public Constelacao(String nome, Golpe[] golpe)
    {
        this.nome = nome;
        this.golpe = golpe;
    }
    
    //It was too late when i saw
    public void adicionarGolpe(Golpe golpe)
    {
        //this.golpe.
    }
    
    /*public String getGolpes()
    {
        for (int i = 0; i < this.golpe.length; i++)
        {
            return this.golpe[i].getNome();
        }
    }*/
    
    public String getNome()
    {
        return this.nome;
    }
}
