package estruturas;

public class Iterador {
    
    Lista lista;
    No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean haProximo() {
        return this.atual.proximo != null;
    }

    public Boolean haAnterior() {
        return this.atual.anterior != null;
    }

    public void proximo() {
        this.atual = atual.proximo;
    }

    public int getDadoAnterior() {
        return this.atual.anterior.dado;
    }

    public int getDadoProximo() {
        return this.atual.proximo.dado;
    }

    public int getDado() {
        return this.atual.dado;
    }

    public No getAtual() {
        return this.atual;
    }

    public void resetar() {
        this.atual = this.lista.inicio;
    }

    public void display() {
        if (this.haAnterior()) {
            System.out.print("Anterior -> " + this.getDadoAnterior() + " | ");
        }

        System.out.print("No " + this.getDado());
        
        if (this.haProximo()) {
            System.out.println(" | Proximo -> " + this.getDadoProximo());
        }
        System.out.println("");
        this.proximo();
    }

    public void inserirAposAtual(int valor) {
        No noAux = this.atual.proximo;
        No no = new No(valor);
        
        no.anterior = this.atual;

        if (noAux != null) {
            no.proximo = noAux;
            noAux.anterior = no;
        }

        this.atual.proximo = no;
        this.lista.tamanho++;
    }

    public void removerAposAtual() {
        No noAux = this.atual.proximo;

        if (noAux == null) {
            System.out.println("Nao ha nenhum no apos este!");
            return;
        }

        this.atual.proximo = noAux.proximo;
        noAux.proximo.anterior = this.atual;
        this.lista.tamanho--;
    }

    public void inserirAntesAtual(int valor) {
        No noAux = this.atual.anterior;
        No no = new No(valor);
        
        no.anterior = this.atual;

        if (noAux != null) {
            no.anterior = noAux;
            noAux.proximo = no;
        }

        this.atual.anterior = no;
        this.lista.tamanho++;
    }
    
    public void removerAntesAtual() {
        No noAux = this.atual.anterior;

        if (noAux == null) {
            System.out.println("Nao ha nenhum no antes deste!");
            return;
        }

        this.atual.anterior = noAux.anterior;
        noAux.anterior.proximo = this.atual;
        this.lista.tamanho--;
    }
}
