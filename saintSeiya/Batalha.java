public class Batalha {
    private Saint saint1, saint2;
    final double dano = 10;
    
    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    
    public void iniciar() throws Exception {
        int valorSaint1 = this.saint1.getArmadura().getCategoria().getValor();
        int valorSaint2 = this.saint2.getArmadura().getCategoria().getValor();
        
        if(valorSaint1 >= valorSaint2) {
            this.saint2.perderVida(dano);
        } else {
            this.saint1.perderVida(dano);
        }  
    }
}