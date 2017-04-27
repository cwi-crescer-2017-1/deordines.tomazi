import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest {

    @Test
    public void sorteDoDia() {
        SorteDoDia sorteDoDia = new SorteDoDia(new DadoD6());
        boolean resultados[] = new boolean[100];
        int resultadoFalse = 0, resultadoTrue = 0;

        for (int i = 0; i < 100; i++) {
            resultados[i] = sorteDoDia.estouComSorte();
            System.out.println(resultados[i]);

            if (resultados[i] == true) {
                resultadoTrue++;
            } else {
                resultadoFalse++;
            }
        }

        System.out.println("True: " + resultadoTrue + " False: " + resultadoFalse);

        //assertEquals(50, resultadoTrue, 0.01);
        //assertEquals(50, resultadoFalse, 0.01);
    }

}