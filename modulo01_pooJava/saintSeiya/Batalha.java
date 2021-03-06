public class Batalha {

    private Saint saint1, saint2;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar() throws Exception {
        int valorSaint1 = saint1.getArmadura().getCategoria().getValor();
        int valorSaint2 = saint2.getArmadura().getCategoria().getValor();
        final int danoGeral = 10;
        boolean saint1Ataca = valorSaint1 >= valorSaint2;
        boolean saintsEstaoVivos =  this.saint1.getStatus() == Status.VIVO && this.saint2.getStatus() == Status.VIVO;

        if (saint1Ataca) {
            this.saint2.perderVida(danoGeral);
        } else {
            this.saint1.perderVida(danoGeral);
        }

        while (saintsEstaoVivos) {
            if (saint1Ataca) {
                this.saint1.getProximoMovimento().executar();
                saint1Ataca = false;
            } else {
                this.saint2.getProximoMovimento().executar();
                saint1Ataca = true;
            }

            saintsEstaoVivos = this.saint1.getStatus() != Status.MORTO && this.saint2.getStatus() != Status.MORTO;
        }
    }
}