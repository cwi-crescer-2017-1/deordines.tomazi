

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest
{
    @Test
    public void vestirArmaduraDeixarArmaduraVestida()
    {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura leao = new Armadura("Leão", Categoria.OURO);
        Saint regulus = new Saint("Regulus", leao);
        // 2. Act - Invocar a ação a ser testado
        regulus.VestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = regulus.getArmaduraVestida();
        
        assertEquals(true, resultado);
    }
    
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraVestida()
    {
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado()
    {
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    
    
    
}