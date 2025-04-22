package estruturas;

public class Fila {
    private Documento[] elementos;
    private int inicio, fim, tamanho;

    public Fila(int capacidade) {
        elementos = new Documento[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == elementos.length;
    }

    public void enfileirar(Documento doc) {
        if (!estaCheia()) {
            fim = (fim + 1) % elementos.length;
            elementos[fim] = doc;
            tamanho++;
        } else {
            System.out.println("Fila cheia!");
        }
    }

    public Documento desenfileirar() {
        if (!estaVazia()) {
            Documento removido = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return removido;
        }
        return null;
    }

    public void mostrarFila() {
        System.out.println("Fila de Impressao:");
        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % elementos.length;
            Documento doc = elementos[pos];
            System.out.println("- " + doc.getNome() + " (" + doc.getTamanho() + " KB)");
        }
    }
}