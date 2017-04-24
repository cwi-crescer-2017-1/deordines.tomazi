public class Batalha {
    private Saint saint1, saint2;

    public Batalha(Saint saint1, Saint saint2) {
        int valorSaint1 = saint1.getArmadura().getCategoria().getValor();
        int valorSaint2 = saint2.getArmadura().getCategoria().getValor();

        if (valorSaint1 >= valorSaint2) {
            this.saint1 = saint1;
            this.saint2 = saint2;
        } else {
            this.saint1 = saint2;
            this.saint2 = saint1;
        }
    }

    public void iniciar() throws Exception {
        boolean saint1Ataca = true;
        
        while (true) {
            if (saint1Ataca) {
                this.saint1.getProximoMovimento().executar();
                saint1Ataca = false;
            } else {
                this.saint2.getProximoMovimento().executar();
                saint1Ataca = true;
            }
            
            boolean saintsEstaoVivos = this.saint1.getStatus() == Status.VIVO && this.saint2.getStatus() == Status.VIVO;
            
            if (!saintsEstaoVivos) {
                break;
            }
        }
    }
}