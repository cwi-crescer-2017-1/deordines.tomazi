import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest {
    @Test
    public void buscarSaintExistentePorNome() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        listaSaints.adicionarSaint(regulus);

        assertEquals(regulus, listaSaints.buscarPorNome("Regulus"));
    }

    @Test
    public void buscarSaintInexistentePorNome() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);

        assertNull(listaSaints.buscarPorNome("Degel"));
    }

    @Test
    public void buscarSaintExistenteComRepeticaoDeNomes() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint regulus2 = new GoldSaint("Regulus", "Leão");
        listaSaints.adicionarSaint(regulus2);
        listaSaints.adicionarSaint(regulus);

        assertEquals(regulus2, listaSaints.buscarPorNome("Regulus"));
    }

    @Test
    public void buscarSaintComListaVazia() {
        assertNull(new ListaSaints().buscarPorNome("Seiya"));
    }

    @Test
    public void buscarPorCategoriaListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);

        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        listaSaints.adicionarSaint(ikki);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.OURO);

        assertEquals(new ArrayList<Saint>(), resultadoBusca);    
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        listaSaints.adicionarSaint(hyoga);
        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);

        assertEquals(hyoga, resultadoBusca.get(0));
        assertEquals(shun, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(hyoga);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);

        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(hyoga, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void buscarSaintPeloStatusVivo() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        Saint degel = new GoldSaint("Dégel", "Aquário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);

        assertEquals(regulus, listaSaints.buscarPorStatus(Status.VIVO).get(0));
        assertEquals(sisifos, listaSaints.buscarPorStatus(Status.VIVO).get(1));
        assertEquals(degel, listaSaints.buscarPorStatus(Status.VIVO).get(2));
    }

    @Test
    public void buscarSaintPeloStatusMorto() throws Exception {
        ListaSaints listaSaints = new ListaSaints();  
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        Saint degel = new GoldSaint("Dégel", "Aquário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);
        regulus.perderVida(100);
        sisifos.perderVida(100);
        listaSaints.buscarPorStatus(Status.MORTO);

        assertEquals(regulus, listaSaints.buscarPorStatus(Status.MORTO).get(0));
        assertEquals(sisifos, listaSaints.buscarPorStatus(Status.MORTO).get(1));
    }

    @Test
    public void buscarSaintPeloStatusVivoEMorto() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        Saint degel = new GoldSaint("Dégel", "Aquário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);
        regulus.perderVida(100);
        sisifos.perderVida(100);
        listaSaints.buscarPorStatus(Status.VIVO);
        listaSaints.buscarPorStatus(Status.MORTO);

        assertEquals(degel, listaSaints.buscarPorStatus(Status.VIVO).get(0));
        assertEquals(regulus, listaSaints.buscarPorStatus(Status.MORTO).get(0));
        assertEquals(sisifos, listaSaints.buscarPorStatus(Status.MORTO).get(1));
    }

    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        listaSaints.adicionarSaint(regulus);

        assertEquals(regulus, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasDois() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        regulus.perderVida(10);

        assertEquals(sisifos, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();

        assertNull(maiorVida);
    }

    @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        listaSaints.adicionarSaint(shiryu);

        assertEquals(shiryu, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComApenasDois() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(seiya);

        seiya.perderVida(25);

        assertEquals(seiya, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint menorVida = listaSaints.getSaintMenorVida();

        assertNull(menorVida);
    }

    @Test
    public void ordenarComListaDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(seiya);
        listaSaints.adicionarSaint(hyoga);
        shiryu.perderVida(10);
        seiya.perderVida(20);
        hyoga.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultadoOrdenacao = listaSaints.getTodos();

        assertEquals(hyoga, resultadoOrdenacao.get(0));
        assertEquals(seiya, resultadoOrdenacao.get(1));
        assertEquals(shiryu, resultadoOrdenacao.get(2));
    }

    @Test
    public void ordenarComListaOrdenada() throws Exception {

    }

    @Test
    public void ordenarComListaVazia() throws Exception {
    }

    @Test
    public void ordenarComListaApenasUm() throws Exception {
    }

    @Test
    public void ordenarListaEmModoAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(seiya);
        listaSaints.adicionarSaint(hyoga);
        shiryu.perderVida(10);
        seiya.perderVida(20);
        hyoga.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultadoOrdenacao = listaSaints.getTodos();
        
        assertEquals(hyoga, resultadoOrdenacao.get(0));
        assertEquals(seiya, resultadoOrdenacao.get(1));
        assertEquals(shiryu, resultadoOrdenacao.get(2));
    }

    @Test
    public void ordenarListaEmModoDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(seiya);
        listaSaints.adicionarSaint(hyoga);
        shiryu.perderVida(10);
        seiya.perderVida(20);
        hyoga.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultadoOrdenacao = listaSaints.getTodos();
        
        assertEquals(shiryu, resultadoOrdenacao.get(0));
        assertEquals(seiya, resultadoOrdenacao.get(1));
        assertEquals(hyoga, resultadoOrdenacao.get(2));
    }

    @Test
    public void unirDuasListasDeSaints() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        Saint degel = new GoldSaint("Dégel", "Aquário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);
        
        ListaSaints novaLista = new ListaSaints();
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        Saint mascaraDaMorte = new GoldSaint("Máscara da Morte", "Câncer");
        novaLista.adicionarSaint(aldebaran);
        novaLista.adicionarSaint(shura);
        novaLista.adicionarSaint(mascaraDaMorte);
        
        ArrayList<Saint> resultadoNovaLista = listaSaints.unir(novaLista);
        
        assertEquals(regulus, resultadoNovaLista.get(0));
        assertEquals(sisifos, resultadoNovaLista.get(1));
        assertEquals(degel, resultadoNovaLista.get(2));
        assertEquals(aldebaran, resultadoNovaLista.get(3));
        assertEquals(shura, resultadoNovaLista.get(4));
        assertEquals(mascaraDaMorte, resultadoNovaLista.get(5));
    }
    
    @Test
    public void diffDuasListasComUmSaintIgualEmDuasListas() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        Saint degel = new GoldSaint("Dégel", "Aquário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);
        
        ListaSaints novaLista = new ListaSaints();
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        Saint mascaraDaMorte = new GoldSaint("Máscara da Morte", "Câncer");
        Saint regulus2 = new GoldSaint("Regulus", "Leão");
        novaLista.adicionarSaint(aldebaran);
        novaLista.adicionarSaint(shura);
        novaLista.adicionarSaint(mascaraDaMorte);
        novaLista.adicionarSaint(regulus2);
        
        ListaSaints resultadoNovaLista = listaSaints.diff(novaLista);
        
        assertEquals(sisifos, resultadoNovaLista.getSaint(0));
        assertEquals(degel, resultadoNovaLista.getSaint(1));
    }
    
    @Test
    public void intersecDuasListasComUmSaintIguaisEmDuasListas() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", "Leão");
        Saint sisifos = new GoldSaint("Sísifos", "Sagitário");
        Saint degel = new GoldSaint("Dégel", "Aquário");
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);
        
        ListaSaints novaLista = new ListaSaints();
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        Saint mascaraDaMorte = new GoldSaint("Máscara da Morte", "Câncer");
        Saint regulus2 = new GoldSaint("Regulus", "Leão");
        novaLista.adicionarSaint(aldebaran);
        novaLista.adicionarSaint(shura);
        novaLista.adicionarSaint(mascaraDaMorte);
        novaLista.adicionarSaint(regulus2);
        
        ListaSaints resultadoNovaLista = listaSaints.intersec(novaLista);
        
        assertEquals(regulus, resultadoNovaLista.getSaint(0));
    }
    
    @Test
    public void getCSVComUmSaint() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        listaSaints.adicionarSaint(shiryu);
        String separador = System.getProperty("line.separator");
        String csvEsperado = "Shiryu,100.0,Dragão,BRONZE,VIVO,NAO_INFORMADO,false"+separador;
    
        assertEquals(csvEsperado, listaSaints.getCSV());
    }
    
    @Test
    public void getCSVComTresSaints() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(ikki);
        listaSaints.adicionarSaint(seiya);
        seiya.perderVida(30);
        seiya.vestirArmadura();
        String separador = System.getProperty("line.separator");
        String csvEsperado = "Shiryu,100.0,Dragão,BRONZE,VIVO,NAO_INFORMADO,false"+separador+
            "Ikki,100.0,Fênix,BRONZE,VIVO,NAO_INFORMADO,false"+separador+
            "Seiya,70.0,Pégaso,BRONZE,VIVO,NAO_INFORMADO,true"+separador;
        
        assertEquals(csvEsperado, listaSaints.getCSV());
    }
}
