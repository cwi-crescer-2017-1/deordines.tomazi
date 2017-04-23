import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class GolpearTest {
    
    @Test 
    public void golpearComSaintBronzeSemArmadura() throws Exception {
        Saint tenma = new BronzeSaint("Tenma", "Pégaso");
        Golpe meteoroDePegaso = new Golpe("Meteoro de Pégaso", 5);
        Golpe cometaDePegaso = new Golpe("Cometa de Pégaso", 7);
        Golpe cometaBigBang = new Golpe("Cometa Big Bang", 10);
        tenma.aprenderGolpe(meteoroDePegaso);
        tenma.aprenderGolpe(cometaDePegaso);
        tenma.aprenderGolpe(cometaBigBang);
        
        Saint hasgard = new GoldSaint("Asgard", "Touro");
        
        Movimento golpear = new Golpear(tenma, hasgard);
        golpear.executar();
        golpear.executar();
        golpear.executar();
        
        assertEquals(78.0, hasgard.getVida(), 0.01);
    }
    
    @Test
    public void golpearComSaintPrataSemArmadura() throws Exception {
        Saint orfeu = new SilverSaint("Orfeu", "Lira");
        Golpe requiemDeCordas = new Golpe("Réquiem de Cordas", 20);
        orfeu.aprenderGolpe(requiemDeCordas);
        
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        
        Movimento golpear = new Golpear(orfeu, shun);
        golpear.executar();
        golpear.executar();
        
        assertEquals(60.0, shun.getVida(), 0.01);
    }
    
    
    @Test
    public void golpearComSaintOuroSemArmadura() throws Exception {
        Saint hasgard = new GoldSaint("Asgard", "Touro");
        Golpe grandeChifre = new Golpe("Grande Chifre", 5);
        Golpe destruicaoTitanica = new Golpe("Destruição Titânica", 7);
        Golpe supernovaTitanica = new Golpe("Supernova Titânica", 10);
        hasgard.aprenderGolpe(grandeChifre);
        hasgard.aprenderGolpe(destruicaoTitanica);
        hasgard.aprenderGolpe(supernovaTitanica);
        
        Saint tenma = new BronzeSaint("Tenma", "Pégaso");
        
        Movimento golpear = new Golpear(hasgard, tenma);
        golpear.executar();
        golpear.executar();
        golpear.executar();
        
        assertEquals(78.0, tenma.getVida(), 0.01);
    }
    
    @Test
    public void golpearComSaintBronzeComArmadura() throws Exception {
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        Golpe golpeFantasmaDaFenix = new Golpe("Golpe Fantasma da Fênix", 8);
        Golpe aveFenix = new Golpe("Ave Fênix", 15);
        ikki.aprenderGolpe(golpeFantasmaDaFenix);
        ikki.aprenderGolpe(aveFenix);
        
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        
        Movimento vestirArmadura = new VestirArmadura(ikki);
        vestirArmadura.executar();
        Movimento golpear = new Golpear(ikki, shaka);
        golpear.executar();
        golpear.executar();
        
        assertEquals(54.0, shaka.getVida(), 0.01);
    }
    
    @Test
    public void golpearComSaintPrataComArmadura() throws Exception {
        Saint hakurei = new SilverSaint("Hakurei", "Altar");
        Golpe ondasDoInferno = new Golpe("Ondas do Inferno", 7);
        Golpe marchaDosEspiritos = new Golpe("Marcha dos Espíritos", 13);
        hakurei.aprenderGolpe(ondasDoInferno);
        hakurei.aprenderGolpe(marchaDosEspiritos);
        
        Saint yuzuriha = new SilverSaint("Yuzuriha", "Altar");
        Golpe dancaMagnificaDosChutesVelozes = new Golpe("Dança Magnífica dos Chutes Velozes", 10);
        yuzuriha.aprenderGolpe(dancaMagnificaDosChutesVelozes);
        
        Movimento vestirArmadura = new VestirArmadura(hakurei);
        vestirArmadura.executar();
        Movimento golpear = new Golpear(hakurei, yuzuriha);
        golpear.executar();
        golpear.executar();
        
        assertEquals(40.0, yuzuriha.getVida(), 0.01);
    }
    
    @Test
    public void golpearComSaintOuroComArmadura() throws Exception {
        Saint elCid = new GoldSaint("El Cid", "Capricórnio");
        Golpe pedraSaltitante = new Golpe("Pedra Saltitante", 2);
        Golpe excaliburV1 = new Golpe("Excalibur V1", 4);
        Golpe excaliburV2 = new Golpe("Excalibur V2", 8);
        Golpe excaliburV3 = new Golpe("Excalibur V3", 10);
        elCid.aprenderGolpe(pedraSaltitante);
        elCid.aprenderGolpe(excaliburV1);
        elCid.aprenderGolpe(excaliburV2);
        elCid.aprenderGolpe(excaliburV3);
        
        Saint degel = new GoldSaint("Dégel", "Aquário");
        
        Movimento vestirArmadura = new VestirArmadura(elCid);
        vestirArmadura.executar();
        Movimento golpear = new Golpear(elCid, degel);
        golpear.executar(); // 8
        golpear.executar(); // 16
        golpear.executar(); // 32
        golpear.executar(); // 40
        
        assertEquals(4.0, degel.getVida(), 0.01);
    }
    
    @Test(expected=Exception.class)
    public void golpearComSaintBronzeSemGolpes() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        
        Movimento golpear = new Golpear(seiya, hyoga);
        golpear.executar();
    }
}
