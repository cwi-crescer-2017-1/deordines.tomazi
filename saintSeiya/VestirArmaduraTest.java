import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {
    @Test
    public void vestirArmadura() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Movimento vestirArmadura = new VestirArmadura(shiryu);
        vestirArmadura.executar();
        
        assertTrue(shiryu.getArmaduraVestida());
    }
    
    @Test
    public void naoVestirArmadura() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Movimento naoVestirArmadura = new VestirArmadura(shiryu);
        
        assertFalse(shiryu.getArmaduraVestida());
    }
    
    @Test(expected=NullPointerException.class)
    public void vestirArmaduraComSaintNull() throws Exception {
        Saint shiryu = null;
        Movimento vestirArmadura = new VestirArmadura(shiryu);
        vestirArmadura.executar();
    }
}
