import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest {

    @Test(expected=ArithmeticException.class)
    public void ataqueDuploSemMovimentos() throws Exception {
        Movimento ataqueDuplo = new AtaqueDuplo(new BronzeSaint("Hyoga", "Cisne"), new GoldSaint("Camus", "Aquário"), new DadoFalso(1));
        ataqueDuplo.executar();
    }

    @Test
    public void ataqueDuploSemArmaduraVestida() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        hyoga.aprenderGolpe(new Golpe("Pó de Diamante", 5));

        Saint camus = new GoldSaint("Camus", "Aquário");
        camus.aprenderGolpe(new Golpe("Pó de Diamante", 5));

        Movimento ataqueDuplo = new AtaqueDuplo(hyoga, camus, new DadoFalso(1));
        hyoga.adicionarMovimento(ataqueDuplo);
        hyoga.getProximoMovimento().executar();

        if (camus.getVida() == 90) {
            assertEquals(90.0, camus.getVida(), 0.01);
        } else {
            assertEquals(95.0, hyoga.getVida(), 0.01); 
            assertEquals(95.0, camus.getVida(), 0.01);
        }
    }

    @Test
    public void ataqueDuploComArmadura() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        hyoga.aprenderGolpe(new Golpe("Trovão Aurora Ataque", 10));

        Saint camus = new GoldSaint("Camus", "Aquário");
        camus.aprenderGolpe(new Golpe("Execução Aurora", 10));

        Movimento vestirArmadura = new VestirArmadura(hyoga);
        Movimento ataqueDuplo = new AtaqueDuplo(hyoga, camus, new DadoFalso(1));
        hyoga.adicionarMovimento(vestirArmadura);
        hyoga.adicionarMovimento(ataqueDuplo);

        for (int i = 0; i < 3; i++) hyoga.getProximoMovimento().executar();

        if (camus.getVida() == 60)
        {
            assertEquals(60.0, camus.getVida(), 0.01);
        } else {
            assertEquals(95.0, hyoga.getVida(), 0.01);
            assertEquals(80.0, camus.getVida(), 0.01);
        }
    }
}
