

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void categoriaSaint1MaiorQueSaint2() throws Exception {
        Saint shaina = new SilverSaint("Shaina", "Serpente");        
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        
        Batalha batalha = new Batalha(shaina, hyoga);
        batalha.Iniciar();
        
        assertEquals(100, shaina.getVida(), 0.01);
        assertEquals(90, hyoga.getVida(), 0.01);      
    }
    
    @Test
    public void categoriaSaint1MenorQueSaint2() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint camus = new GoldSaint("Camus", "Aquário");
        
        Batalha batalha = new Batalha(hyoga, camus);
        batalha.Iniciar();
        
        assertEquals(90, hyoga.getVida(), 0.01);
        assertEquals(100, camus.getVida(), 0.01);
    }
    
    @Test
    public void categoriaSaint1IgualAoSaint2() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint shion = new GoldSaint("Shion", "Áries");
        
        Batalha batalha = new Batalha(dohko, shion);
        batalha.Iniciar();
        
        assertEquals(100, dohko.getVida(), 0.001);
        assertEquals(90, shion.getVida(), 0.001);
    }
}