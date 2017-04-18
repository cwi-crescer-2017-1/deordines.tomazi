

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
}
