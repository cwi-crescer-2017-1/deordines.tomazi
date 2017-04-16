public class Batalha
{
    public void Iniciar(Saint saint1, Saint saint2)
    {
        System.out.println(saint1.getNome() + " de " + saint1.getArmadura().getNome() + " vs " + saint2.getNome() + " de " + saint2.getArmadura().getNome());
        
        Saint a = DefineQuemRecebeDano(saint1, saint2);
        
        a.perdeVida(10);
        
        System.out.println(a.getNome() + " tem " + a.getVida());
        
        /*while(true)
        {
            if (saint1.getVida() == 0 || saint2.getVida() == 0)
                break;
                
            a.perdeVida(10);
        }*/
    }
    
    public Saint DefineQuemRecebeDano(Saint saint1, Saint saint2)
    {
        int categoria1 = saint1.getCategoria().getValor();
        int categoria2 = saint2.getCategoria().getValor();
        
        if (categoria1 > categoria2)
            return saint2;
        else if (categoria1 < categoria2)
            return saint1;
        else
            return saint2;
    }

        
  
}