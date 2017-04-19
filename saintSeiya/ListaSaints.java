import java.util.ArrayList;
import java.util.stream.Collectors;

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
        /*for(Saint saint : this.listaSaints) {
            if (saint.getNome().equals(nome)) {
                return saint;
            }
        }
        return null;*/
        
        // Only JAVA 8
        return this.listaSaints.stream()
            .filter(s -> s.getNome().equals(nome))
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        /*ArrayList<Saint> subLista = new ArrayList<>();
        for(Saint saint : this.listaSaints) {
            if (saint.getArmadura().getCategoria().equals(categoria)) {
                subLista.add(saint);
            }
        }
        return subLista;*/
        return (ArrayList<Saint>)this.listaSaints.stream()
            .filter(s -> s.getArmadura().getCategoria().equals(categoria))
            .collect(Collectors.toList());
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
    
    public Saint getSaintMaiorVida() {
        if (listaSaints.isEmpty()) {
            return null;
        }
        
        Saint maiorVida = this.listaSaints.get(0);
        for(int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            boolean encontreiMaior = saint.getVida() > maiorVida.getVida();
            if (encontreiMaior) {
                maiorVida = saint;
            }            
        }
        return maiorVida;
    }
    
    public Saint getSaintMenorVida() {
        if (listaSaints.isEmpty()) {
            return null;
        }
        
        Saint menorVida = this.listaSaints.get(0);
        for(int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            boolean encontreiMenor = saint.getVida() < menorVida.getVida();
            if (encontreiMenor) {
                menorVida = saint;
            }            
        }
        return menorVida;
    }
       
    public void ordenar()
    {
        
    }
}