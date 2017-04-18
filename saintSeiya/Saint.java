import java.security.InvalidParameterException;

public class Saint
{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int indiceGolpe = 0;
    private int indiceGolpeMax = 2;
    
    public Saint(String nome, Armadura armadura) throws Exception
    {
        this.nome = nome;
        this.armadura = armadura;
        
        /*int valorCategoria = this.armadura.getCategoria().getValor();
        this.qtdSentidosDespertados += valorCategoria;*/
    }

    public void VestirArmadura()
    {
        armaduraVestida = true;
    }
    
    public boolean getArmaduraVestida()
    {
        return this.armaduraVestida;
    }
    
    public Genero getGenero()
    {
        return this.genero;
    }
    
    public void setGenero(Genero genero)
    {
        this.genero = genero;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    
    public void perderVida(double dano)
    {
        if (dano < 0 )
        {
            throw new InvalidParameterException("Parâmetro Inválido");
        }
        
        if (vida - dano < 1)
        {
            this.status = Status.MORTO;
            this.vida = 0;
        }
        else
        {
            this.vida -= dano;
        }
    }
    
    public double getVida()
    {
        return this.vida;
    }
    
        public String getNome()
    {
        return this.nome;
    }
    
    public Armadura getArmadura()
    {
        return this.armadura;
    }
    
    public int getQtdSentidosDespertados()
    {
        return this.qtdSentidosDespertados;
    }
    
    public Golpe[] getGolpes()
    {
        return this.armadura.getConstelacao().getGolpes();
    }
    
    public void aprendendoGolpe(Golpe golpe) throws Exception
    {
        armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    //to do
    public Golpe getProximoGolpe()
    {
        indiceGolpe++;
        return this.armadura.getConstelacao().getGolpe(indiceGolpe);        
    }
}