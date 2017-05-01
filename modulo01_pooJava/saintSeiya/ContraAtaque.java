import java.util.Random;

public class ContraAtaque implements Movimento {

    private Saint golpeador, golpeado;
    private Sorteador sorteador;

    ContraAtaque(Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }

    public void executar() {
        if (executarContraAtaque()) {
            this.golpeado.setContraAtacar();
        }
    }

    public boolean executarContraAtaque() {
        if (this.golpeado.getVida() < 50 && !this.golpeado.getArmaduraVestida()) {
            return this.sorteador.sortear() < 5;
        } else {
            return false; 
        }
    }
}