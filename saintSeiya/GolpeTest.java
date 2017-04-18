

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpeTest
{
    @Test
    public void criarGolpe()
    {
        Golpe golpe = new Golpe("Meteoro de Pégasus", 50);
        
        assertEquals("Meteoro de Pégasus", golpe.getNome());
        assertEquals(50, golpe.getFatorDano(), 0.01);
    }
}
