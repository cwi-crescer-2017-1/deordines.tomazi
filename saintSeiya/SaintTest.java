

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest
{
    @Test
    public void vestirArmaduraDeixarArmaduraVestida() throws Exception
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
    public void naoVestirArmaduraDeixaArmaduraVestida() throws Exception
    {
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception
    {
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception
    {
        Saint jabu = new Saint("Jabu", new Armadura("Unicórino", Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusDeveSerVivo() throws Exception
    {
        Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE));
        assertEquals(Status.VIVO, ikki.getStatus());
    }
    
    @Test
    public void aoCriarSaintVidaDeveSer100() throws Exception
    {
        Saint albafica = new Saint("Albafica", new Armadura("Peixes", Categoria.OURO));
        assertEquals(100.0, albafica.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintValor10() throws Exception
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(10);
        assertEquals(90, saga.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintValor100() throws Exception
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(100);
        assertEquals(0, saga.getVida(), 0.01);
    }
    
    @Test(expected=Exception.class)
    public void causarDanoAoSaintComValorMenos1000() throws Exception
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(-1000);
    }
    
    @Test
    public void causarDanoAoSaintValor1000() throws Exception
    {
        Saint saga = new Saint("Saga", new Armadura("Gêmeos", Categoria.OURO));
        saga.perderVida(1000);
        assertEquals(-900, saga.getVida(), 0.01);
    }
 
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint1() throws Exception
    {
        Saint manigold = new Saint("Manigold", new Armadura("Câncer", Categoria.OURO));
        Categoria saint1 = manigold.getArmadura().getCategoria();
        
        assertEquals(saint1, Categoria.OURO);      
    }
    
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint2() throws Exception
    {       
        Saint asmita = new Saint("Asmita", new Armadura("Virgem", Categoria.OURO));
        Categoria saint2 = asmita.getArmadura().getCategoria();
        
        assertEquals(saint2, Categoria.OURO);        
    }
    
    @Test
    public void criarSaintNasceComCincoSentidosDespertados() throws Exception
    {
        Saint shun = new BronzeSaint("Shun", new Armadura("Andrômeda", Categoria.BRONZE));
        
        assertEquals(5, shun.getQtdSentidosDespertados(), 0.01);
    }
    
    @Test
    public void criarSaintPrataNasceComSeisSentidosDespertados() throws Exception
    {
        Saint marin = new SilverSaint("Marin", new Armadura("Águia", Categoria.PRATA));
        
        assertEquals(6, marin.getQtdSentidosDespertados(), 0.01);    
    }
    
    @Test
    public void criarSaintPrataNasceComSeteSentidosDespertados() throws Exception
    {
        Saint aiolos = new GoldSaint("Aiolos", new Armadura("Sagitário", Categoria.OURO));
        
        assertEquals(7, aiolos.getQtdSentidosDespertados(), 0.01);    
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception
    {
        new GoldSaint("Bernardo", new Armadura("Café", Categoria.OURO));
    }
    
    @Test
    public void saintCriadoRecebe100DeDanoEAlteraStatusParaMorto() throws Exception
    {
        Saint seiya = new BronzeSaint("Seiya", new Armadura("Pégasus", Categoria.BRONZE));
        seiya.perderVida(100);
        
        assertEquals(Status.MORTO, seiya.getStatus());
    }
    
    @Test(expected=Exception.class)
    public void saintComStatusMortoNaoPodeLevarDanoEDeveLancarErro() throws Exception
    {
        Saint milo = new GoldSaint("Milo", new Armadura("Escorpião", Categoria.OURO));
        milo.perderVida(100);
        //assertEquals(0, milo.getVida(), 0.01);
        milo.perderVida(100);
    }
}