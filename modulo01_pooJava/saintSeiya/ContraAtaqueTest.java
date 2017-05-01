import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest {
    
    @Test
    public void saintCom45DeVidaSemArmaduraContraAtacaENaoRecebeDano() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.aprenderGolpe(new Golpe("Cólega do Dragão", 5));

        Saint shion = new GoldSaint("Shion", "Áries");
        shion.aprenderGolpe(new Golpe("Extinção Estelar", 5));

        Movimento dohkoGolpear = new Golpear(dohko, shion);
        Movimento shionContraAtaca = new ContraAtaque(dohko, shion, new DadoFalso(1));

        dohkoGolpear.executar();
        shion.perderVida(50);
        shionContraAtaca.executar();
        dohkoGolpear.executar();

        assertEquals(45.0, shion.getVida(), 0.01);
        assertEquals(75.0, dohko.getVida(), 0.01);
    }
    
    @Test
    public void saintCom40DeVidaComArmaduraNaoContraAtacaERecebeDano() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.aprenderGolpe(new Golpe("Cólega do Dragão", 5));

        Saint shion = new GoldSaint("Shion", "Áries");
        shion.aprenderGolpe(new Golpe("Extinção Estelar", 5));

        Movimento dohkoGolpear = new Golpear(dohko, shion);
        Movimento shionContraAtaca = new ContraAtaque(dohko, shion, new DadoFalso(1));

        dohkoGolpear.executar();
        shion.perderVida(50);
        shion.vestirArmadura();
        shionContraAtaca.executar();
        dohkoGolpear.executar();

        assertEquals(40.0, shion.getVida(), 0.01);
        assertEquals(100.0, dohko.getVida(), 0.01);
    }
    
    @Test
    public void saintCom95DeVidaSemArmaduraNaoContraAtacaERecebeDano() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.aprenderGolpe(new Golpe("Cólega do Dragão", 5));

        Saint shion = new GoldSaint("Shion", "Áries");
        shion.aprenderGolpe(new Golpe("Extinção Estelar", 5));

        Movimento dohkoGolpear = new Golpear(dohko, shion);
        Movimento shionContraAtaca = new ContraAtaque(dohko, shion, new DadoFalso(1));

        dohkoGolpear.executar();
        shionContraAtaca.executar();
        dohkoGolpear.executar();

        assertEquals(90.0, shion.getVida(), 0.01);
        assertEquals(100.0, dohko.getVida(), 0.01);
    }
}