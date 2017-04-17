

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void categoriaSaint1MaiorQueSaint2()
    {
        Saint shaina = new Saint("Shaina", new Armadura("Serpente", Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        
        Batalha batalha = new Batalha(shaina, hyoga);
        
        batalha.Iniciar();
        
        assertEquals(100, shaina.getVida(), 0.01);
        assertEquals(90, hyoga.getVida(), 0.01);      
    }
    
    @Test
    public void categoriaSaint1MenorQueSaint2()
    {
        
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        Saint camus = new Saint("Camus", new Armadura("Aquário", Categoria.OURO));
        
        Batalha batalha = new Batalha(hyoga, camus);
        
        batalha.Iniciar();
        
        assertEquals(90, hyoga.getVida(), 0.01);
        assertEquals(100, camus.getVida(), 0.01);
    }
    
    @Test
    public void categoriaSaint1IgualAoSaint2()
    {
        Saint dohko = new Saint("Dohko", new Armadura("Libra", Categoria.OURO));
        Saint shion = new Saint("Shion", new Armadura("Áries", Categoria.OURO));
        
        Batalha batalha = new Batalha(dohko, shion);
        
        batalha.Iniciar();
        
        assertEquals(100, dohko.getVida(), 0.001);
        assertEquals(90, shion.getVida(), 0.001);
    }
}