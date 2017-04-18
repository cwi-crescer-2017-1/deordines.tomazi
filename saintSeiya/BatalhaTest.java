

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void categoriaSaint1MaiorQueSaint2() throws Exception
    {
        Saint shaina = new Saint("Shaina", new Armadura(new Constelacao("Serpente", new Golpe[]{new Golpe("Garras de Trovão", 25), new Golpe("Garras de Trovão v2", 50)}), Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne", new Golpe[]{new Golpe("Pó de Diamante", 25), new Golpe("Trovão Aurora Ataque", 50)}), Categoria.BRONZE));
        
        Batalha batalha = new Batalha(shaina, hyoga);
        
        batalha.Iniciar();
        
        assertEquals(100, shaina.getVida(), 0.01);
        assertEquals(90, hyoga.getVida(), 0.01);      
    }
    
    @Test
    public void categoriaSaint1MenorQueSaint2() throws Exception
    {
        
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne", new Golpe[]{new Golpe("Pó de Diamante", 25), new Golpe("Trovão Aurora Ataque", 50)}), Categoria.BRONZE));
        Saint camus = new Saint("Camus", new Armadura(new Constelacao("Aquário", new Golpe[]{new Golpe("Pó de Diamante", 25), new Golpe("Execução Aurora", 50)}), Categoria.OURO));
        
        Batalha batalha = new Batalha(hyoga, camus);
        
        batalha.Iniciar();
        
        assertEquals(90, hyoga.getVida(), 0.01);
        assertEquals(100, camus.getVida(), 0.01);
    }
    
    @Test
    public void categoriaSaint1IgualAoSaint2() throws Exception
    {
        Saint dohko = new Saint("Dohko", new Armadura(new Constelacao("Libra", new Golpe[]{new Golpe("Cóleta dos Cem Dragões", 25), new Golpe("Último Dragão", 50)}), Categoria.OURO));
        Saint shion = new Saint("Shion", new Armadura(new Constelacao("Áries", new Golpe[]{new Golpe("Extinção Estelar", 25), new Golpe("Revolução Estelar", 50)}), Categoria.OURO));
        
        Batalha batalha = new Batalha(dohko, shion);
        
        batalha.Iniciar();
        
        assertEquals(100, dohko.getVida(), 0.001);
        assertEquals(90, shion.getVida(), 0.001);
    }
}