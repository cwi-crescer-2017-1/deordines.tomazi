public class AtaqueDuplo implements Movimento {

    private Saint golpeador, golpeado;
    private Sorteador sorteador;

    public AtaqueDuplo(Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
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

        if (this.golpeado.getContraAtacar()) {
            this.golpeado.perderVida(0);
            this.golpeador.perderVida(this.golpeador.getVida() * 0.25);
            this.golpeado.setContraAtacar();
        } else {
            this.golpeado.perderVida(danoCausado);;
        }
    }

    public TipoDeMovimento getTipoDeMovimento() {
        return TipoDeMovimento.OFENSIVO;
    }

    private boolean ataqueDuplo() {
        return this.sorteador.sortear() <= 2;
    }
}