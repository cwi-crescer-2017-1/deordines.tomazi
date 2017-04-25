import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class SaintTest {
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void vestirArmaduraDeixarArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Golpe golpe1 = new Golpe("Cápsula do Poder", 25);
        Golpe golpe2 = new Golpe("Relâmpago de Plasma", 50);
        Constelacao leao = new Constelacao("Leão");
        leao.adicionarGolpe(golpe1);
        leao.adicionarGolpe(golpe2);
        Saint regulus = new GoldSaint("Regulus", "Leão");
        // 2. Act - Invocar a ação a ser testado
        regulus.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = regulus.getArmaduraVestida();

        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraVestida() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");

        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");

        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", "Unicórnio");
        jabu.setGenero(Genero.MASCULINO);

        assertEquals(Genero.MASCULINO, jabu.getGenero());
    }

    @Test
    public void aoCriarSaintStatusDeveSerVivo() throws Exception {
        Saint ikki = new BronzeSaint("Ikki", "Fênix");

        assertEquals(Status.VIVO, ikki.getStatus());
    }

    @Test
    public void aoCriarSaintVidaDeveSer100() throws Exception {
        Saint albafica = new GoldSaint("Albafica", "Peixes");

        assertEquals(100.0, albafica.getVida(), 0.01);
    }

    @Test
    public void causarDanoAoSaintValor10() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        saga.perderVida(10);

        assertEquals(90, saga.getVida(), 0.01);
    }

    @Test
    public void causarDanoAoSaintValor100() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        saga.perderVida(100);

        assertEquals(0, saga.getVida(), 0.01);
    }

    @Test(expected=InvalidParameterException.class)
    public void causarDanoAoSaintComValorMenos1000() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        saga.perderVida(-1000);
    }

    @Test
    public void causarDanoAoSaintValor1000() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        saga.perderVida(1000);

        assertEquals(0, saga.getVida(), 0.01);
    }

    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint1() throws Exception {
        Saint manigold = new GoldSaint("Manigold", "Câncer");
        Categoria saint1 = manigold.getArmadura().getCategoria();

        assertEquals(saint1, Categoria.OURO);      
    }

    @Test
    public void aoIniciarBatalhaVerificaCategoriaSaint2() throws Exception {       
        Saint asmita = new GoldSaint("Asmita", "Virgem");
        Categoria saint2 = asmita.getArmadura().getCategoria();

        assertEquals(saint2, Categoria.OURO);        
    }

    @Test
    public void criarSaintNasceComCincoSentidosDespertados() throws Exception {
        Saint shun = new BronzeSaint("Shun", "Andrômeda");

        assertEquals(5, shun.getQtdSentidosDespertados(), 0.01);
    }

    @Test
    public void criarSaintPrataNasceComSeisSentidosDespertados() throws Exception {
        Saint marin = new SilverSaint("Marin", "Águia");

        assertEquals(6, marin.getQtdSentidosDespertados(), 0.01);    
    }

    @Test
    public void criarSaintPrataNasceComSeteSentidosDespertados() throws Exception {
        Saint aiolos = new GoldSaint("Aiolos", "Sagitário");

        assertEquals(7, aiolos.getQtdSentidosDespertados(), 0.01);    
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", "Café");
    }

    @Test
    public void saintCriadoRecebe100DeDanoEAlteraStatusParaMorto() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.perderVida(100);

        assertEquals(Status.MORTO, seiya.getStatus());
    }

    @Test
    public void saintComStatusMortoNaoPodeLevarDanoEDeveLancarErro() throws Exception {
        Saint milo = new GoldSaint("Milo", "Escorpião");
        milo.perderVida(100);
        assertEquals(0, milo.getVida(), 0.01);
        milo.perderVida(100);
    }

    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint milo = new GoldSaint("Milo", "Escorpião");
        Golpe agulhaEscarlate = new Golpe("Agulha Escarlate", 25);
        milo.aprenderGolpe(agulhaEscarlate);
        ArrayList<Golpe> golpes = milo.getGolpes();

        assertEquals(agulhaEscarlate, golpes.get(0));
        assertEquals(1, golpes.size());
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint milo = new GoldSaint("Milo", "Escorpião");
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
        Saint asmita = new GoldSaint("Asmita", "Virgem");
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
        Saint asmita = new GoldSaint("Asmita", "Virgem");
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
        Saint milo = new GoldSaint("Milo", "Escorpião");
        Golpe agulhaEscarlate = new Golpe("Agulha Escarlate", 25);
        milo.aprenderGolpe(agulhaEscarlate);

        assertEquals(agulhaEscarlate, milo.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint milo = new GoldSaint("Milo", "Escorpião");
        Golpe agulhaEscarlate = new Golpe("Agulha Escarlate", 25);
        Golpe agulhaEscarlateAntares = new Golpe("Agulha Escarlate de Antares", 50);
        milo.aprenderGolpe(agulhaEscarlate);
        milo.aprenderGolpe(agulhaEscarlateAntares);    

        assertEquals(agulhaEscarlate, milo.getProximoGolpe());
        assertEquals(agulhaEscarlateAntares, milo.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint asmita = new GoldSaint("Asmita", "Virgem");
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
        Saint asmita = new GoldSaint("Asmita", "Virgem");
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

    @Test(expected=Exception.class)
    public void getCSVComConstelacaoNulaEArmaduraVestida() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        String csvEsperado = "Dohko,10.0,,OURO,VIVO,NAO_INFORMADO,true";
        
        assertEquals(csvEsperado, dohko.getCSV());
    }
    
    @Test
    public void getCDVComGeneroFeminino() throws Exception {
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String csvEsperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        
        assertEquals(csvEsperado, june.getCSV());
    }
    
    @Test
    public void adicionarMovimentoComNenhumMovimento() throws Exception {
        Saint tenma = new BronzeSaint("Tenma", "Pégaso");
        ArrayList<Movimento> movimentos = tenma.getMovimentos();
        
        assertEquals(true, movimentos.isEmpty());
    }
    
    @Test
    public void adicionarMovimentoComUmMovimento() throws Exception {
        Saint tenma = new BronzeSaint("Tenma", "Pégaso");
        Movimento vestirArmadura = new VestirArmadura(tenma);
        tenma.adicionarMovimento(vestirArmadura);
        ArrayList<Movimento> movimentos = tenma.getMovimentos();
        
        assertEquals(vestirArmadura, movimentos.get(0));
    }
    
    @Test(expected=Exception.class)
    public void getProximoMovimentoComListaVazia() throws Exception {
        Saint tenma = new BronzeSaint("Tenma", "Pégaso");       
        tenma.getProximoMovimento();
    }
    
    @Test
    public void getProximoMovimentoComDoisMovimentosNaLista() throws Exception {
        Saint tenma = new BronzeSaint("Tenma", "Pégaso");
        Golpe meteoroDePegaso = new Golpe("Meteoro de Pégaso", 5);
        tenma.aprenderGolpe(meteoroDePegaso);
        
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        
        Movimento vestirArmadura = new VestirArmadura(tenma);
        Movimento golpear = new Golpear(tenma, seiya);
        tenma.adicionarMovimento(vestirArmadura);
        tenma.adicionarMovimento(golpear);
        
        assertEquals(vestirArmadura, tenma.getProximoMovimento());
        assertEquals(golpear, tenma.getProximoMovimento());
    }
    
    @Test
    public void golpearDeveAdicionarMovimentoGolpear() throws Exception {
    
    }

    @Test
    public void criarTresSaintsGetQtdSaintsDeveSerUmAMais() throws Exception {
        Saint milo = new GoldSaint("Milo", "Escorpião");
        
        assertEquals(1, Saint.getQtdSaints());
    }
    
    @Test
    public void criarTresSaintsGetQtdSaintsDeveSerTres() throws Exception {
        Saint milo = new GoldSaint("Milo", "Escorpião");
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        
        assertEquals(3, Saint.getQtdSaints());
    }
    
    @Test
    public void criarDuzentosSaintsQtdDeveTerDuzentosAMais() throws Exception {
        for (int i = 0; i < 200; i++) {
            new BronzeSaint("Bronze" + i, "Constelação" + 1);
        }
        
        assertEquals(200, Saint.getQtdSaints());
    }
}