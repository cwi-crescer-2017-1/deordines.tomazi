public class Saint
{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    
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
        this.vida -= dano;
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
}