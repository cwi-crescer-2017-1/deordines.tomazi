import java.util.Random;

public class AtaqueDuplo implements Movimento {
    
    private Saint golpeador, golpeado;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() {
        Golpe golpe = this.golpeador.getProximoGolpe();
        double danoCausado = golpe.getFatorDano();
        
        if (golpeador.getArmaduraVestida()) {
            danoCausado *= this.golpeador.getArmadura().getCategoria().getValor() + 1;
        }
        
        if (ataqueDuplo()) {
            danoCausado *= 2;
        } else {
            this.golpeador.perderVida(this.golpeador.getVida() * 0.05);
        }
        
        this.golpeado.perderVida(danoCausado);
    }
    
    private boolean ataqueDuplo() {
        Random random = new Random();
        int min = 1, max = 6;
        boolean ataqueDuploOcorre = random.nextInt(max - min + 1) + min <= 2 ? true : false;
        return ataqueDuploOcorre;
    }
}