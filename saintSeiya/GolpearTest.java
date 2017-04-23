import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class GolpearTest {
    
    @Test
    public void golpearUmSaint() throws Exception {
        Saint hasgard = new GoldSaint("Asgard", "Touro");
        Golpe grandeChifre = new Golpe("Grande Chifre", 5);
        Golpe destruicaoTitanica = new Golpe("Destruição Titânica", 7);
        Golpe supernovaTitanica = new Golpe("Supernova Titânica", 10);
        hasgard.aprenderGolpe(grandeChifre);
        hasgard.aprenderGolpe(destruicaoTitanica);
        hasgard.aprenderGolpe(supernovaTitanica);
        
        Saint tenma = new BronzeSaint("Tenma", "Pégaso");
        Golpe meteodoDePegaso = new Golpe("Meteoro de Pégaso", 5);
        Golpe cometaDePegaso = new Golpe("Cometa de Pégaso", 7);
        Golpe cometaBigBang = new Golpe("Cometa Big Bang", 10);
        tenma.aprenderGolpe(meteodoDePegaso);
        tenma.aprenderGolpe(cometaDePegaso);
        tenma.aprenderGolpe(cometaBigBang);
        
        Movimento golpear = new Golpear(hasgard, tenma);
        golpear.executar(); //5
        golpear.executar(); //+7
        golpear.executar(); //+10
        
        assertEquals(78.0, tenma.getVida(), 0.01);
        
        Movimento vestirArmadura = new VestirArmadura(hasgard);
        vestirArmadura.executar();
        golpear.executar();
        golpear.executar();
        
        assertEquals(30.0, tenma.getVida(), 0.01);
    }
}
