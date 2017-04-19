

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class SaintTest
{
    @Test
    public void vestirArmaduraDeixarArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Golpe golpe1 = new Golpe("Cápsula do Poder", 25);
        Golpe golpe2 = new Golpe("Relâmpago de Plasma", 50);
        Constelacao leao = new Constelacao("Leão");
        leao.adicionarGolpe(golpe1);
        leao.adicionarGolpe(golpe2);
        Armadura ouroLeao = new Armadura(leao, Categoria.OURO);
        Saint regulus = new Saint("Regulus", ouroLeao);
        // 2. Act - Invocar a ação a ser testado
        regulus.VestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = regulus.getArmaduraVestida();
        
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraVestida() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new Saint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
        
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new Saint("Jabu", new Armadura(new Constelacao("Unicórino"), Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        
        assertEquals(Genero.MASCULINO, jabu.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusDeveSerVivo() throws Exception {
        Saint ikki = new Saint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
        
        assertEquals(Status.VIVO, ikki.getStatus());
    }
    
    @Test
    public void aoCriarSaintVidaDeveSer100() throws Exception {
        Saint albafica = new Saint("Albafica", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        
        assertEquals(100.0, albafica.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintValor10() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        saga.perderVida(10);

        assertEquals(90, saga.getVida(), 0.01);
    }
    
    @Test
    public void causarDanoAoSaintValor100() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        saga.perderVida(100);
        
        assertEquals(0, saga.getVida(), 0.01);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void causarDanoAoSaintComValorMenos1000() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        saga.perderVida(-1000);
    }
    
    @Test
    public void causarDanoAoSaintValor1000() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        saga.perderVida(1000);
        
        assertEquals(0, saga.getVida(), 0.01);
    }
 
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint1() throws Exception {
        Saint manigold = new Saint("Manigold", new Armadura(new Constelacao("Câncer"), Categoria.OURO));
        Categoria saint1 = manigold.getArmadura().getCategoria();
        
        assertEquals(saint1, Categoria.OURO);      
    }
    
    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint2() throws Exception {       
        Saint asmita = new Saint("Asmita", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
        Categoria saint2 = asmita.getArmadura().getCategoria();
        
        assertEquals(saint2, Categoria.OURO);        
    }
    
    @Test
    public void criarSaintNasceComCincoSentidosDespertados() throws Exception {
        Saint shun = new BronzeSaint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        
        assertEquals(5, shun.getQtdSentidosDespertados(), 0.01);
    }
    
    @Test
    public void criarSaintPrataNasceComSeisSentidosDespertados() throws Exception {
        Saint marin = new SilverSaint("Marin", new Armadura(new Constelacao("Águia"), Categoria.PRATA));
        
        assertEquals(6, marin.getQtdSentidosDespertados(), 0.01);    
    }
    
    @Test
    public void criarSaintPrataNasceComSeteSentidosDespertados() throws Exception {
        Saint aiolos = new GoldSaint("Aiolos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
        
        assertEquals(7, aiolos.getQtdSentidosDespertados(), 0.01);    
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura(new Constelacao("Café"), Categoria.OURO));
    }
    
    @Test
    public void saintCriadoRecebe100DeDanoEAlteraStatusParaMorto() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        seiya.perderVida(100);
        
        assertEquals(Status.MORTO, seiya.getStatus());
    }
    
    @Test
    public void saintComStatusMortoNaoPodeLevarDanoEDeveLancarErro() throws Exception {
        Saint milo = new GoldSaint("Milo", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        milo.perderVida(100);
        assertEquals(0, milo.getVida(), 0.01);
        milo.perderVida(100);
    }
    
    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint milo = new Saint("Milo", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        Golpe agulhaEscarlate = new Golpe("Agulha Escarlate", 25);
        milo.aprenderGolpe(agulhaEscarlate);
        ArrayList<Golpe> golpes = milo.getGolpes();
        
        assertEquals(agulhaEscarlate, golpes.get(0));
        assertEquals(1, golpes.size());
    }
    
    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint milo = new Saint("Milo", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        Golpe agulhaEscarlate = new Golpe("Agulha Escarlate", 25);
        Golpe agulhaEscarlateAntares = new Golpe("Agulha Escarlate de Antares", 50);
        milo.aprenderGolpe(agulhaEscarlate);
        milo.aprenderGolpe(agulhaEscarlateAntares);    
        ArrayList<Golpe> golpes = milo.getGolpes();
        
        assertEquals(agulhaEscarlate, golpes.get(0));
        assertEquals(agulhaEscarlateAntares, golpes.get(1));
        assertEquals(2, golpes.size());
    }
    
    @Test
    public void aprenderTresGolpes() throws Exception {
        Saint asmita = new Saint("Asmita", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
        Golpe rendicaoDivina = new Golpe("Rendição Divina", 25);
        Golpe cicloSeisExistencias = new Golpe("Ciclo das Seis Existêcias", 50);
        Golpe tesouroDoCeu = new Golpe("Tesouro do Céu", 75);
        asmita.aprenderGolpe(rendicaoDivina);
        asmita.aprenderGolpe(cicloSeisExistencias);
        asmita.aprenderGolpe(tesouroDoCeu);
        ArrayList<Golpe> golpes = asmita.getGolpes();
        
        assertEquals(rendicaoDivina, golpes.get(0));
        assertEquals(cicloSeisExistencias, golpes.get(1));
        assertEquals(tesouroDoCeu, golpes.get(2));
        assertEquals(3, golpes.size());
    }
    
    @Test
    public void aprenderQuatroGolpes() throws Exception {
        Saint asmita = new Saint("Asmita", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
        Golpe rendicaoDivina = new Golpe("Rendição Divina", 25);
        Golpe cicloSeisExistencias = new Golpe("Ciclo das Seis Existêcias", 50);
        Golpe tesouroDoCeu = new Golpe("Tesouro do Céu", 75);
        Golpe golpeExtra = new Golpe("Golpe Extra", 100);
        asmita.aprenderGolpe(rendicaoDivina);
        asmita.aprenderGolpe(cicloSeisExistencias);
        asmita.aprenderGolpe(tesouroDoCeu);
        asmita.aprenderGolpe(golpeExtra);
        ArrayList<Golpe> golpes = asmita.getGolpes();
        
        assertEquals(rendicaoDivina, golpes.get(0));
        assertEquals(cicloSeisExistencias, golpes.get(1));
        assertEquals(tesouroDoCeu, golpes.get(2));
        assertEquals(golpeExtra, golpes.get(3));
        assertEquals(4, golpes.size());
    }
    
        
    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint milo = new Saint("Milo", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        Golpe agulhaEscarlate = new Golpe("Agulha Escarlate", 25);
        milo.aprenderGolpe(agulhaEscarlate);
        
        assertEquals(agulhaEscarlate, milo.getProximoGolpe());
    }
    
    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint milo = new Saint("Milo", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        Golpe agulhaEscarlate = new Golpe("Agulha Escarlate", 25);
        Golpe agulhaEscarlateAntares = new Golpe("Agulha Escarlate de Antares", 50);
        milo.aprenderGolpe(agulhaEscarlate);
        milo.aprenderGolpe(agulhaEscarlateAntares);    
        
        assertEquals(agulhaEscarlate, milo.getProximoGolpe());
        assertEquals(agulhaEscarlateAntares, milo.getProximoGolpe());
    }
    
    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint asmita = new Saint("Asmita", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
        Golpe rendicaoDivina = new Golpe("Rendição Divina", 25);
        Golpe cicloSeisExistencias = new Golpe("Ciclo das Seis Existêcias", 50);
        Golpe tesouroDoCeu = new Golpe("Tesouro do Céu", 75);
        asmita.aprenderGolpe(rendicaoDivina);
        asmita.aprenderGolpe(cicloSeisExistencias);
        asmita.aprenderGolpe(tesouroDoCeu);
        
        assertEquals(rendicaoDivina, asmita.getProximoGolpe());
        assertEquals(cicloSeisExistencias, asmita.getProximoGolpe());
        assertEquals(tesouroDoCeu, asmita.getProximoGolpe());
    }
    
    @Test
    public void getProximoGolpeComQuatro() throws Exception {
        Saint asmita = new Saint("Asmita", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
        Golpe rendicaoDivina = new Golpe("Rendição Divina", 25);
        Golpe cicloSeisExistencias = new Golpe("Ciclo das Seis Existêcias", 50);
        Golpe tesouroDoCeu = new Golpe("Tesouro do Céu", 75);
        asmita.aprenderGolpe(rendicaoDivina);
        asmita.aprenderGolpe(cicloSeisExistencias);
        asmita.aprenderGolpe(tesouroDoCeu);
        
        assertEquals(rendicaoDivina, asmita.getProximoGolpe());
        assertEquals(cicloSeisExistencias, asmita.getProximoGolpe());
        assertEquals(tesouroDoCeu, asmita.getProximoGolpe());
        assertEquals(rendicaoDivina, asmita.getProximoGolpe());
    }
}