import java.util.ArrayList;
import java.util.*;

public class ListaSaints {
    private ArrayList<Saint> listaSaints = new ArrayList<>();
    
    public void adicionarSaint(Saint saint) {
        this.listaSaints.add(saint);
    }
    
    public Saint getSaint(int indice) {
        return this.listaSaints.get(indice);
    }
    
    public ArrayList<Saint> getTodos() {
        return this.listaSaints;
    }
    
    public void removerSaint(int indice) {
        this.listaSaints.remove(indice);
    }
    
    public Saint buscarPorNome(String nome) {
        for(Saint saint : this.listaSaints) {
            if (saint.getNome().equals(nome)) {
                return saint;
            }
        }
        return null;
        
        // Only JAVA 8
        /*return this.listaSaints.stream()
            .filter(s -> s.getNome().equals(nome)
            .findFirst()
            .orElse(null);*/
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        ArrayList<Saint> subLista = new ArrayList<>();
        for(Saint saint : this.listaSaints) {
            if (saint.getArmadura().getCategoria() == categoria) {
                subLista.add(saint);
            }
        }
        return subLista;
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status) {
        ArrayList<Saint> subLista = new ArrayList<>();
        for(Saint saint : this.listaSaints) {
            if (saint.getStatus() == status) {
                subLista.add(saint);
            }
        }
        return subLista;
    }
    
    // TODO
    /*
    public Saint getSaintMaiorVida()
    {
        double aux = 0;
        for(Saint saint : this.listaSaints)
        {
            if (saint.getVida() > aux)
            {
                aux = saint.getVida();
            }
        }
    }
    
    public Saint getSaintMenorVida()
    {
        double aux = 0;
        for(Saint saint : this.listaSaints)
        {
            if (saint.getVida() > aux)
            {
                aux = saint.getVida();
            }
        }
    }
    
    public void ordenarSaints()
    {
        Collections.sort(listaSaints);
    }
    */
}