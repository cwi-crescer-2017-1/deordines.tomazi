

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ConstelacaoTest
{
    @Test
    public void criaUmSaintComConstelacao() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
    }
    
    @Test
    public void aoAdicionarUmTerceiroGolpeDeveDarErro() throws Exception {
       Golpe golpe1 = new Golpe("Cápsula do Poder", 25);
       Golpe golpe2 = new Golpe("Relâmpago de Plasma", 50);
       Golpe golpe3 = new Golpe("Fótns", 75);
       Constelacao leao = new Constelacao("Leão");
       leao.adicionarGolpe(golpe1);
       leao.adicionarGolpe(golpe2);
       leao.adicionarGolpe(golpe3);
       Saint regulus = new GoldSaint("Regulus", "Leão");
    }
    
    @Test
    public void adiconarUmGolpe() {
        Constelacao touro = new Constelacao("Touro");
        Golpe grandeChifre = new Golpe("Grande Chifre", 25);
        touro.adicionarGolpe(grandeChifre);
        ArrayList<Golpe> golpes = touro.getGolpes();
        
        assertEquals(grandeChifre, golpes.get(0));
        assertEquals(1, golpes.size());
    }
    
    @Test
    public void adicionarDoisGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra Dimensão", 25);
        Golpe explosaoGalatica = new Golpe("Explosão Galática", 50);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(2, golpes.size());
    }
    
    @Test
    public void adicionarTresGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra Dimensão", 25);
        Golpe explosaoGalatica = new Golpe("Explosão Galática", 50);
        Golpe sataImperial = new Golpe("Satã Imperial", 75);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(sataImperial, golpes.get(2));
        assertEquals(3, golpes.size());
    }
    
    @Test
    public void adicionarQuatroGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra Dimensão", 25);
        Golpe explosaoGalatica = new Golpe("Explosão Galática", 50);
        Golpe sataImperial = new Golpe("Satã Imperial", 75);
        Golpe golpeExtra = new Golpe("golpeExtra", 100);
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);
        gemeos.adicionarGolpe(golpeExtra);
        
        assertEquals(4, golpes.size());        
    }
}
