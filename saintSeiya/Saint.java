public class Saint
{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    private int qtdSentidosDespertados;
    
    public Saint(String nome, Armadura armadura) throws Exception
    {
        this.nome = nome;
        this.armadura = armadura;
        
        /*int valorCategoria = this.armadura.getCategoria().getValor();
        this.qtdSentidosDespertados += valorCategoria;*/
        
        if(this.armadura.getCategoria() == Categoria.PRATA)
        {
            this.qtdSentidosDespertados = 6;
        } else if(this.armadura.getCategoria() == Categoria.OURO){
            this.qtdSentidosDespertados = 7;
            String constelacao = armadura.getNome();
            
            if (!constelacao.equals("Áries")
                && !constelacao.equals("Touro")
                && !constelacao.equals("Gêmeos")
                && !constelacao.equals("Câncer")
                && !constelacao.equals("Virgem")
                && !constelacao.equals("Leão")
                && !constelacao.equals("Peixes")
                && !constelacao.equals("Capricórnio")){
                //dar erro
                throw new Exception("Constelação inválida");
            }
            
            
            
            
            
        } else {
            this.qtdSentidosDespertados = 5;
        }
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