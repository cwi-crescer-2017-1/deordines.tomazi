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
    //Testar categoria
    
    
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
}
