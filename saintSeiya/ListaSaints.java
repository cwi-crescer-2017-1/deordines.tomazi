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
        boolean posicoesSendoTrocadas = false;

        do{
            posicoesSendoTrocadas = false;
            for(int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();

                if (precisaTrocar){
                    Saint troca = atual;
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, troca);
                    posicoesSendoTrocadas = true;
                }
            }
        } while(posicoesSendoTrocadas);        
    }

    public void ordenar(TipoEnumeracao tipo) {
        boolean posicoesSendoTrocadas = false;

        switch (tipo) {
            case ASCENDENTE: {
                do {
                    posicoesSendoTrocadas = false;
                    for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                        Saint atual = this.listaSaints.get(i);
                        Saint proximo = this.listaSaints.get(i + 1);
                        boolean precisaTrocar = atual.getVida() > proximo.getVida();

                        if (precisaTrocar) {
                            Saint troca = atual;
                            this.listaSaints.set(i, proximo);
                            this.listaSaints.set(i + 1, troca);
                            posicoesSendoTrocadas = true;
                        }
                    }
                }while (posicoesSendoTrocadas);
            } break;
            case DESCENDENTE: {
                do {
                    posicoesSendoTrocadas = false;
                    for(int i = 0; i < this.listaSaints.size() - 1; i++) {
                        Saint atual = this.listaSaints.get(i);
                        Saint proximo = this.listaSaints.get(i + 1);
                        boolean precisaTrocar = atual.getVida() < proximo.getVida();

                        if(precisaTrocar) {
                            Saint troca = atual;
                            this.listaSaints.set(i, proximo);
                            this.listaSaints.set(i + 1, troca);
                            posicoesSendoTrocadas = true;
                        }
                    }
                } while(posicoesSendoTrocadas);
            } break;    
        }
    }

    //public ArrayList<String> getCSV() {
    public void getCSV() {
        if (listaSaints.isEmpty()) {
            return;
        }
        ArrayList<String> csv = new ArrayList<>();
        for (Saint saint : this.listaSaints) {
            csv.add(saint.getNome() + "," +
                saint.getVida() + "," +
                saint.getArmadura().getConstelacao().getNome() + "," +
                saint.getArmadura().getCategoria() + "," +
                saint.getStatus() + "," +
                saint.getGenero() + "," +
                saint.getArmaduraVestida());             
            //return csv;
        }
        for (String s : csv)
            System.out.println(s);
        //return null;
    }
}