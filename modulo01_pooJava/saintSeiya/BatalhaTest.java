import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test(expected=Exception.class)
    public void categoriaSaint1MaiorQueSaint2() throws Exception {
        Saint shaina = new SilverSaint("Shaina", "Serpente");        
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        
        Batalha batalha = new Batalha(shaina, hyoga);
        batalha.iniciar();
        
        assertEquals(100, shaina.getVida(), 0.01);
        assertEquals(90, hyoga.getVida(), 0.01);      
    }
    
    @Test(expected=Exception.class)
    public void categoriaSaint1MenorQueSaint2() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint camus = new GoldSaint("Camus", "Aquário");
        
        Batalha batalha = new Batalha(hyoga, camus);
        batalha.iniciar();
        
        assertEquals(90, hyoga.getVida(), 0.01);
        assertEquals(100, camus.getVida(), 0.01);
    }
    
    @Test(expected=Exception.class)
    public void categoriaSaint1IgualAoSaint2() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint shion = new GoldSaint("Shion", "Áries");
        
        Batalha batalha = new Batalha(dohko, shion);
        batalha.iniciar();
        
        assertEquals(100, dohko.getVida(), 0.001);
        assertEquals(90, shion.getVida(), 0.001);
    }
    
    @Test
    public void iniciarBatalhaGoldSaintComMovimentos() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Golpe coleraDoDragao = new Golpe("Cólega do Dragão", 5);
        Golpe coleraDosCemDragoes = new Golpe("Cólera dos Cem Dragões", 8);
        dohko.aprenderGolpe(coleraDoDragao);
        //dohko.aprenderGolpe(coleraDosCemDragoes);
        
        Saint shion = new GoldSaint("Shion", "Áries");
        Golpe extincaoEstelar = new Golpe("Extinção Estelar", 5);
        Golpe revolucaoEstelar = new Golpe("Revolução Estelar", 8);
        shion.aprenderGolpe(extincaoEstelar);
        //shion.aprenderGolpe(revolucaoEstelar);
        
        Movimento dohkoVestirArmadura = new VestirArmadura(dohko);
        Movimento golpear1 = new Golpear(dohko, shion);
        //dohko.adicionarMovimento(dohkoVestirArmadura);
        dohko.adicionarMovimento(golpear1);
        
        Movimento shionVestirArmadura = new VestirArmadura(shion);
        Movimento golpear2 = new Golpear(shion, dohko);
        //shion.adicionarMovimento(shionVestirArmadura);
        shion.adicionarMovimento(golpear2);
        
        Batalha batalha = new Batalha(dohko, shion);
        batalha.iniciar();
        
        assertEquals(Status.VIVO, dohko.getStatus());
        assertEquals(Status.MORTO, shion.getStatus());
    }
}