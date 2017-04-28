import java.util.ArrayList;

public class Golpear implements Movimento {
    private Saint golpeador;
    private Saint golpeado;

    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() throws Exception {
        double danoCausado = multiplicadorDeDano(golpeador, golpeador.getProximoGolpe());   
        this.golpeado.perderVida(danoCausado);
    }

    private double multiplicadorDeDano(Saint saint, Golpe golpe) {        
        double fatorDano = golpe.getFatorDano();
        double multiplicador = golpeador.getArmadura().getCategoria().getValor();

        if (saint.getArmaduraVestida()) {
            fatorDano = golpe.getFatorDano() * (multiplicador + 1);
        }

        return fatorDano;
    }

    public boolean equals(Object outro) {
        Golpear outroGolpear = (Golpear)outro;
        return this.golpeador.equals(outroGolpear.golpeador)
        && this.golpeado.equals(outroGolpear.golpeado);
    }
}