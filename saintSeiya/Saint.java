import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Saint
{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int indiceProximoGolpe = 0;
    
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
    
    public ArrayList<Golpe> getGolpes()
    {
        return this.armadura.getConstelacao().getGolpes();
    }
    
    private Constelacao getConstelacao()
    {
        return this.armadura.getConstelacao();
    }
    public void aprenderGolpe(Golpe golpe)
    {
        getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe()
    {
        ArrayList<Golpe> golpes = getGolpes();
        int posicao = this.indiceProximoGolpe % golpes.size();
        return golpes.get(indiceProximoGolpe++ % golpes.size());
    }
}