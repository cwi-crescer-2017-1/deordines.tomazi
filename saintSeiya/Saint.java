import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Saint
{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int indiceProximoGolpe = 0;
    private ArrayList<Movimento> movimentos = new ArrayList<>();
    private int indiceProximoMovimento = 0;

    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
    }

    public void vestirArmadura() {
        armaduraVestida = true;
    }

    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return this.status;
    }

    public void perderVida(double dano) {
        if (dano < 0 ) {
            throw new InvalidParameterException("Parâmetro Inválido");
        }

        if (vida - dano < 1) {
            this.status = Status.MORTO;
            this.vida = 0;
        } else {
            this.vida -= dano;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public double getVida() {
        return this.vida;
    }

    public Armadura getArmadura() {
        return this.armadura;
    }

    public int getQtdSentidosDespertados() {
        return this.qtdSentidosDespertados;
    }

    public ArrayList<Golpe> getGolpes() {
        return this.armadura.getConstelacao().getGolpes();
    }

    private Constelacao getConstelacao() {
        return this.armadura.getConstelacao();
    }

    public void aprenderGolpe(Golpe golpe) {
        getConstelacao().adicionarGolpe(golpe);
    }

    public Golpe getProximoGolpe() {
        ArrayList<Golpe> golpes = getGolpes();
        if (golpes.size() == 0) {
            throw new InvalidParameterException("Sem Golpes Para Executar");
        }
        int posicao = this.indiceProximoGolpe % golpes.size();
        return golpes.get(this.indiceProximoGolpe++ % golpes.size());
    }
    
    public ArrayList<Movimento> getMovimentos() {
        return this.movimentos;
    }
    
    public void adicionarMovimento(Movimento movimento) {
        this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento() {
        if (movimentos.isEmpty()) {
            throw new InvalidParameterException("Sem Movimentos Para Executar");
        }
        int posicao = this.indiceProximoMovimento % movimentos.size();
        return movimentos.get(this.indiceProximoMovimento++ % movimentos.size());
    }
    
    public String getCSV() {
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.getNome(),
            this.vida,
            this.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.armaduraVestida);
    }
}