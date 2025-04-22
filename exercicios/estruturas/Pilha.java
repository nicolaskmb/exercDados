package estruturas;

public class Pilha {
    private String[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new String[capacidade];
        topo = -1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == elementos.length - 1;
    }

    public void empilhar(String elemento) {
        if (!estaCheia()) {
            elementos[++topo] = elemento;
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public String desempilhar() {
        if (!estaVazia()) {
            return elementos[topo--];
        }
        return null;
    }

    public String topo() {
        return estaVazia() ? null : elementos[topo];
    }

    public int capacidade() {
        return elementos.length;
    }
}
