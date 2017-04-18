

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
    @Test
    public void criaUmSaintComConstelacao() throws Exception
    {
        Saint dohko = new Saint("Dohko", new Armadura(new Constelacao("Libra", new Golpe[]{new Golpe("Cóleta dos Cem Dragões", 25), new Golpe("Último Dragão", 50)}), Categoria.OURO));
    }
    
    @Test(expected=Exception.class)
    public void aoAdicionarUmTerceiroGolpeDeveDarErro() throws Exception
    {
       Golpe golpe1 = new Golpe("Cápsula do Poder", 25);
       Golpe golpe2 = new Golpe("Relâmpago de Plasma", 50);
       Golpe golpe3 = new Golpe("Fotóns", 75);
       Constelacao leao = new Constelacao("Leão");
       leao.adicionarGolpe(golpe1);
       leao.adicionarGolpe(golpe2);
       leao.adicionarGolpe(golpe3);
       Armadura ouroLeao = new Armadura(leao, Categoria.OURO);
       Saint regulus = new Saint("Regulus", ouroLeao);
    }
}
