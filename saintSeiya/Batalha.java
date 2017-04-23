public class Batalha {
    private Saint saint1, saint2;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar() throws Exception {
        int valorSaint1 = this.saint1.getArmadura().getCategoria().getValor();
        int valorSaint2 = this.saint2.getArmadura().getCategoria().getValor();
        
        while (true) {
            if (valorSaint1 >= valorSaint2) {
                this.saint1.getProximoMovimento().executar();
                if (!statusDosSaintsEmBatalha()) { break; }
                this.saint2.getProximoMovimento().executar();
                if (!statusDosSaintsEmBatalha()) { break; }
            } else {
                this.saint2.getProximoMovimento().executar();
                if (!statusDosSaintsEmBatalha()) { break; }
                this.saint1.getProximoMovimento().executar();
                if (!statusDosSaintsEmBatalha()) { break; }
            }
        }
    }

    private boolean statusDosSaintsEmBatalha() {
        boolean saintsEstaoVivos = this.saint1.getStatus() == Status.VIVO && this.saint2.getStatus() == Status.VIVO;
        return saintsEstaoVivos;
    }
}