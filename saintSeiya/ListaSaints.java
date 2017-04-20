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
    
    public void ordenar() {
        this.ordenar(TipoOrdenacao.ASCENDENTE);    
    }
    
    public void ordenar(TipoOrdenacao tipoOrdenacao) {
        boolean ascendente = tipoOrdenacao == tipoOrdenacao.ASCENDENTE;
        boolean posicoesSendoTrocadas = false;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);

                boolean precisaTrocar =
                    ascendente ? atual.getVida() > proximo.getVida() :
                    atual.getVida() < proximo.getVida();

                if (precisaTrocar) {
                    Saint troca = atual;
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, troca);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
    }

    public ArrayList<Saint> unir(ListaSaints outraLista) {
        ArrayList<Saint> novaLista = new ArrayList<>();
        ArrayList<Saint> auxOutraLista = outraLista.getTodos();
        novaLista.addAll(listaSaints);

        for (int i = 0; i < auxOutraLista.size(); i++) {
            novaLista.add(auxOutraLista.get(i));
        }
        return novaLista;
    }

    // TODO
    /*public ArrayList<Saint> diff(ArrayList<Saint> outraLista) {
    ArrayList<Saint> novaLista = new ArrayList<>();

    for (int i = 0; i < this.listaSaints.size(); i++) {
    for (int j = 0; i < outraLista.size(); i++) {
    if (!this.listaSaints.get(i).getNome().equals(outraLista.get(j).getNome())) {
    novaLista.add(this.listaSaints.get(i));
    }
    }
    }
    return novaLista;
    }*/
    
    public void getCSV() {
        for (Saint saint : this.listaSaints) {
            System.out.println(saint.getCSV());
        }
    }
}