package estruturas;

public class EditorTexto {
    private Pilha pilhaDesfazer;
    private Pilha pilhaRefazer;
    private String textoAtual;

    public EditorTexto(int capacidade) {
        pilhaDesfazer = new Pilha(capacidade);
        pilhaRefazer = new Pilha(capacidade);
        textoAtual = "";
    }

    public void inserirTexto(String novoTexto) {
        pilhaDesfazer.empilhar(textoAtual);
        pilhaRefazer = new Pilha(pilhaRefazer.capacidade()); // limpa refazer
        textoAtual += novoTexto;
    }

    public void desfazer() {
        if (!pilhaDesfazer.estaVazia()) {
            pilhaRefazer.empilhar(textoAtual);
            textoAtual = pilhaDesfazer.desempilhar();
        }
    }

    public void refazer() {
        if (!pilhaRefazer.estaVazia()) {
            pilhaDesfazer.empilhar(textoAtual);
            textoAtual = pilhaRefazer.desempilhar();
        }
    }

    public void mostrarTexto() {
        System.out.println("Texto atual: " + textoAtual);
    }
}