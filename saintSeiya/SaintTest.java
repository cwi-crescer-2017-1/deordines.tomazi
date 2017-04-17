

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
    public void deveSerPossivelAlterarOGenero()
    {
        Saint jabu = new Saint("Jabu", new Armadura("Unicórino", Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusDeveSerVivo()
    {
        Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE));
        assertEquals(Status.VIVO, ikki.getStatus());
    }
    
    @Test
    public void aoCriarSaintVidaDeveSer100()
    {
        Saint albafica = new Saint("Albafica", new Armadura("Peixes", Categoria.OURO));
        assertEquals(100.0, albafica.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintValor10()
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(10);
        assertEquals(90, saga.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintValor100()
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(100);
        assertEquals(0, saga.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintComValorMenos1000()
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(-1000);
        assertEquals(1100, saga.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintValor1000()
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(1000);
        assertEquals(-900, saga.getVida(), 0.01);
    }
 
    
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint1()
    {
        Saint manigold = new Saint("Manigold", new Armadura("Câncer", Categoria.OURO));
        Categoria saint1 = manigold.getArmadura().getCategoria();
        
        assertEquals(saint1, Categoria.OURO);      
    }
    
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint2()
    {       
        Saint asmita = new Saint("Asmita", new Armadura("Virgem", Categoria.OURO));
        Categoria saint2 = asmita.getArmadura().getCategoria();
        
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
        
        assertEquals(hyoga, hyoga);
    }
    
    @Test
    public void aoIniciarBatalhaVerificaQuemRecebeDanoPrimeiroBronzeVsPrata()
    {
        Saint seiya = new Saint("Seiya", new Armadura("Pégasus", Categoria.BRONZE));
        Saint misty = new Saint("Misty", new Armadura("Lagarto", Categoria.PRATA));
        
        assertEquals(seiya, seiya);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}