package estruturas;

public class Vetor {

    public Integer[] elementos; // 3fc -> 4fd
    private int tamanho;
    private int capacidade;

    public Vetor(int capacidade) {
        this.elementos = new Integer[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
    }

    public void adicionarVetor(Integer valor) {

        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }

        this.elementos[this.tamanho] = valor;
        this.tamanho++;
    }

    public void adicionarAoInicio(Integer valor) {

        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }

        Integer[] novosElementos = new Integer[this.capacidade];

        for (int i =0; i<this.tamanho; i++) {
            novosElementos[i+1] = this.elementos[i];
        }

        this.elementos = novosElementos;
        this.elementos[0] = valor;
        this.tamanho++;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = this.capacidade + (this.capacidade/2);
        Integer[] novosElementos = new Integer[novaCapacidade];

        for (int i =0; i<this.tamanho; i++) {
            novosElementos[i] = this.elementos[i];
        }

        this.elementos = novosElementos;
        this.capacidade = novaCapacidade;
    }

    public void mostrarElementos() {
        System.out.println("-----");
        System.out.println("Elementos no vetor");

        for (int i=0; i < tamanho; i++) {
            System.out.println(this.elementos[i]);
        }
        System.out.println("-----");
    }

    public void contem(Integer valor) {

        for (int i=0; i < tamanho; i++) {
            if (this.elementos[i] == valor) {
                System.out.println("Valor encontrado");
                return;
            }
        }

        System.out.println("Valor não encontrado");
    }

    public void remover(int posicao) {

        if (posicao > this.tamanho) {
            System.out.println("Posição informada é inválida");
            return;
        }

        for (int i = posicao; i < this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }

        this.elementos[this.tamanho-1] = null;
        this.tamanho--;
    }

    public void removerPorValor(Integer valor) {

        for (int i=0; i<this.tamanho; i++) {
            if (this.elementos[i] == valor) {
                this.remover(i);
                System.out.println("Item removido");
                return;
            }
        }

        System.out.println("Item não encontrado");
    }

    public Integer buscaBinaria(Integer valor) {
        int min = 0;
        int max = tamanho-1;
        int numeroAlvo = (min + max) / 2;
        
        while (this.elementos[numeroAlvo] != valor) {
            System.out.println(min + " + " + max + " / 2 = " + numeroAlvo);
            int numeroAntigo = numeroAlvo;

            if (this.elementos[numeroAlvo] > valor){
                max = numeroAlvo;
            }
            else {
                min = numeroAlvo;
            }
            numeroAlvo = (min + max) / 2;

            if (numeroAntigo == numeroAlvo) {             
                if (this.elementos[numeroAlvo + 1] == valor) {
                    numeroAlvo += 1;
                    break;
                }

                System.out.println("Item nao encontrado!");
                return null;
            }
        }

        System.out.println(min + " + " + max + " / 2 = " + numeroAlvo);
        System.out.println("Item encontrado!");
        System.out.println("Local na lista: "+ numeroAlvo);
        return numeroAlvo;
    }
}