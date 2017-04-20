import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void buscarSaintExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        listaSaints.adicionarSaint(regulus);

        assertEquals(regulus, listaSaints.buscarPorNome("Regulus"));
    }

    @Test
    public void buscarSaintInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint sisifos = new GoldSaint("Sísifos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);      
        listaSaints.buscarPorNome("Degel");

        assertNull(listaSaints.buscarPorNome("Degel"));
    }

    @Test
    public void buscarSaintExistenteComRepeticaoDeNomes() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus2 = new GoldSaint("Regulus2", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        listaSaints.adicionarSaint(regulus2);
        listaSaints.adicionarSaint(regulus);

        assertEquals(regulus2, listaSaints.buscarPorNome("Regulus2"));
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
        Saint ikki = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
        listaSaints.adicionarSaint(ikki);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.OURO);

        assertEquals(new ArrayList<Saint>(), resultadoBusca);    
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        Saint shun = new BronzeSaint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
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
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        Saint shun = new BronzeSaint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
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
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint sisifos = new GoldSaint("Sísifos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
        Saint degel = new GoldSaint("Dégel", new Armadura(new Constelacao("Aquário"), Categoria.OURO));
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
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint sisifos = new GoldSaint("Sísifos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
        Saint degel = new GoldSaint("Dégel", new Armadura(new Constelacao("Aquário"), Categoria.OURO));
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
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint sisifos = new GoldSaint("Sísifos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
        Saint degel = new GoldSaint("Dégel", new Armadura(new Constelacao("Aquário"), Categoria.OURO));
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
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        listaSaints.adicionarSaint(regulus);

        assertEquals(regulus, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasDois() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint sisifos = new GoldSaint("Sísifos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
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
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        listaSaints.adicionarSaint(shiryu);

        assertEquals(shiryu, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComApenasDois() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
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
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
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
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(seiya);
        listaSaints.adicionarSaint(hyoga);
        shiryu.perderVida(10);
        seiya.perderVida(20);
        hyoga.perderVida(30);
        listaSaints.ordenar(TipoEnumeracao.ASCENDENTE);
        ArrayList<Saint> resultadoOrdenacao = listaSaints.getTodos();
        
        assertEquals(hyoga, resultadoOrdenacao.get(0));
        assertEquals(seiya, resultadoOrdenacao.get(1));
        assertEquals(shiryu, resultadoOrdenacao.get(2));
    }

    @Test
    public void ordenarListaEmModoDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(seiya);
        listaSaints.adicionarSaint(hyoga);
        shiryu.perderVida(10);
        seiya.perderVida(20);
        hyoga.perderVida(30);
        listaSaints.ordenar(TipoEnumeracao.DESCENDENTE);
        ArrayList<Saint> resultadoOrdenacao = listaSaints.getTodos();
        
        assertEquals(shiryu, resultadoOrdenacao.get(0));
        assertEquals(seiya, resultadoOrdenacao.get(1));
        assertEquals(hyoga, resultadoOrdenacao.get(2));
    }
    
    @Test
    public void unirDuasListasDeSaints() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint sisifos = new GoldSaint("Sísifos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
        Saint degel = new GoldSaint("Dégel", new Armadura(new Constelacao("Aquário"), Categoria.OURO));
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);
        
        ListaSaints novaLista = new ListaSaints();
        Saint aldebaran = new GoldSaint("Andebaran", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint shura = new GoldSaint("Shura", new Armadura(new Constelacao("Capricórnio"), Categoria.OURO));
        Saint mascaraDaMorte = new GoldSaint("Máscara da Morte", new Armadura(new Constelacao("Câncer"), Categoria.OURO));
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
    
    // TODO
    /*
    @Test
    public void diffDuasListasComUmSaintIgualEmDuasListas() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint regulus = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint sisifos = new GoldSaint("Sísifos", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
        Saint degel = new GoldSaint("Dégel", new Armadura(new Constelacao("Aquário"), Categoria.OURO));
        listaSaints.adicionarSaint(regulus);
        listaSaints.adicionarSaint(sisifos);
        listaSaints.adicionarSaint(degel);
        
        ArrayList<Saint> novaLista = new ArrayList<>();
        Saint aldebaran = new GoldSaint("Andebaran", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint shura = new GoldSaint("Shura", new Armadura(new Constelacao("Capricórnio"), Categoria.OURO));
        Saint mascaraDaMorte = new GoldSaint("Máscara da Morte", new Armadura(new Constelacao("Câncer"), Categoria.OURO));
        Saint regulus2 = new GoldSaint("Regulus", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        novaLista.add(aldebaran);
        novaLista.add(shura);
        novaLista.add(mascaraDaMorte);
        novaLista.add(regulus2);
        
        ArrayList<Saint> resultadoNovaLista = listaSaints.diff(novaLista);
        
        assertEquals(sisifos, resultadoNovaLista.get(0));
        assertEquals(degel, resultadoNovaLista.get(2));
    }
    */
   
    @Test
    public void getCSVComUmSaint() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        listaSaints.adicionarSaint(shiryu);
        listaSaints.getCSV();
    }
    
    @Test
    public void getCSVComTresSaints() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        listaSaints.adicionarSaint(shiryu);
        listaSaints.adicionarSaint(seiya);
        listaSaints.adicionarSaint(hyoga);
        listaSaints.getCSV();
    }
}
