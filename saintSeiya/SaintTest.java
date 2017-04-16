

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
    
    @Test
    public void aoCriarSaintStatusEVivo()
    {
        Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE));
        assertEquals(Status.VIVO, ikki.getStatus());
    }
    
    @Test
    public void aoCriarSaintVerificaSuaVidaIgual100()
    {
        Saint albafica = new Saint("Albafica", new Armadura("Peixes", Categoria.OURO));
        double health = 100;
        assertEquals(health, albafica.getVida(), 0);
    }
    
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint1()
    {
        Saint manigold = new Saint("Manigold", new Armadura("Câncer", Categoria.OURO));
        Categoria saint1 = manigold.getCategoria();
        
        assertEquals(saint1, Categoria.OURO);      
    }
    
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint2()
    {       
        Saint asmita = new Saint("Asmita", new Armadura("Virgem", Categoria.OURO));
        Categoria saint2 = asmita.getCategoria();
        
        assertEquals(saint2, Categoria.OURO);        
    }
    
    @Test
    public void aoIniciarBatalhaVerificaQuemRecebeDanoPrimeiroOuroVsOuro()
    {
        Saint dohko = new Saint("Dohko", new Armadura("Libra", Categoria.OURO));
        Saint shion = new Saint("Shion", new Armadura("Áries", Categoria.OURO));
        
        assertEquals(dohko, dohko);
    }
    
    @Test
    public void aoIniciarBatalhaVerificaQuemRecebeDanoPrimeiroOuroVsBronze()
    {
        Saint camus = new Saint("Camus", new Armadura("Aquário", Categoria.OURO));
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        
        assertEquals(camus, camus);
    }
    
    @Test
    public void aoIniciarBatalhaVerificaQuemRecebeDanoPrimeiroBronzeVsPrata()
    {
        Saint seiya = new Saint("Seiya", new Armadura("Pégasus", Categoria.BRONZE));
        Saint misty = new Saint("Misty", new Armadura("Lagarto", Categoria.PRATA));
        
        assertEquals(misty, misty);
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}