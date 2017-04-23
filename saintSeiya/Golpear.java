import java.util.ArrayList;

public class Golpear implements Movimento {
    private Saint golpeador;
    private Saint golpeado;

    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() {
        double danoCausado = multiplicadorDeDano(golpeador, golpeador.getProximoGolpe());   
        this.golpeado.perderVida(danoCausado);
    }

    private double multiplicadorDeDano(Saint saint, Golpe golpe) {        
        double fatorDano = golpe.getFatorDano();
        double multiplicador = golpeador.getArmadura().getCategoria().getValor();

        if (saint.getArmaduraVestida()) {
            fatorDano = golpe.getFatorDano() * (multiplicador + 1);
        } else {
            fatorDano = golpe.getFatorDano(); 
        }
        return fatorDano;
    }
}