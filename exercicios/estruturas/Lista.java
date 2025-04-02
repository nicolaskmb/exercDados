package estruturas;

public class Lista {

    public No inicio;
    public int tamanho;

    public void lista() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adicionarAoInicio(int valor) {
        tamanho++;
        No no = new No(valor);

        if (this.inicio == null) {
            this.inicio = no;
            return;
        }

        this.inicio.anterior = no;

        no.proximo = this.inicio;
        this.inicio = no;
    }

    public void adicionarAoFinal(int valor) {
        tamanho++;
        Iterador iterador = this.getIterador();
        No no = new No(valor);

        while (iterador.getAtual() != null) {
            
            if (!iterador.haProximo()) {
                iterador.atual.proximo = no;
                no.anterior = iterador.atual;
                return;
            }
            else {
                iterador.proximo();
            }
        }
    }

    public void mostrarNos() {
        Iterador iterador = this.getIterador();
        
        while (iterador.getAtual() != null) {
            iterador.display();
        }
    }

    public void numeroDeNos() {
        Iterador iterador = this.getIterador();
        int num = 0;
        
        while (iterador.getAtual() != null) {
            num++;
            iterador.proximo();
        }
        System.out.println("Numero de Nos: "+num);
    }

    public void remover(int valor) {
        No noAux = this.inicio;

        while (noAux != null && noAux.dado != valor) {
            noAux = noAux.proximo;
        }

        if (noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        noAux.anterior.proximo = noAux.proximo;
        noAux.proximo.anterior = noAux.anterior;
        tamanho--;
    }

    public void inserirApos(int valorPosicao, int valorInserido) {
        No noAux = this.inicio;
        No no = new No(valorInserido);

        while (noAux != null && noAux.dado != valorPosicao) {
            noAux = noAux.proximo;
        }

        if (noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        no.anterior = noAux;
        
        if (noAux.proximo != null) {
            no.proximo = noAux.proximo;
            no.proximo.anterior = no;
        }
        
        noAux.proximo = no;
        tamanho++;
    }

    public Iterador getIterador() {
        return new Iterador(this, this.inicio);
    }
}
