import estruturas.*;


public class App {

    public static void main(String[] args) {
        Lista lista = new Lista();
        
        lista.adicionarAoInicio(54);
        lista.adicionarAoInicio(42);
        lista.adicionarAoInicio(33);
        lista.adicionarAoInicio(27);
        lista.adicionarAoInicio(21);
        lista.adicionarAoInicio(16);
        lista.adicionarAoInicio(12);
        lista.adicionarAoInicio(9);
        lista.adicionarAoInicio(7);
        lista.adicionarAoInicio(2);

        Vetor vetor = new Vetor(10);

        vetor.adicionarVetor(2);
        vetor.adicionarVetor(7);
        vetor.adicionarVetor(9);
        vetor.adicionarVetor(12);
        vetor.adicionarVetor(16);
        vetor.adicionarVetor(21);
        vetor.adicionarVetor(27);
        vetor.adicionarVetor(33);
        vetor.adicionarVetor(42);
        vetor.adicionarVetor(54);

        vetor.mostrarElementos();
        lista.mostrarNos();

        vetor.buscaBinaria(33);
        vetor.adicionarAoInicio(25);

        lista.adicionarAoFinal(22);
        lista.inserirApos(12,5);

        lista.getIterador().inserirAposAtual(3);
        lista.getIterador().removerAposAtual();
        lista.getIterador().inserirAposAtual(3);
        lista.getIterador().removerAposAtual();

        vetor.mostrarElementos();
        lista.mostrarNos();
        lista.numeroDeNos();

        EditorTexto editor = new EditorTexto(10);
        editor.inserirTexto("Olá, ");
        editor.mostrarTexto();
        editor.inserirTexto("mundo!");
        editor.mostrarTexto();
        editor.desfazer();
        editor.mostrarTexto();
        editor.refazer();
        editor.mostrarTexto();
        editor.inserirTexto(" Como vai?");
        editor.mostrarTexto();
        editor.desfazer();
        editor.desfazer();
        editor.mostrarTexto();

        Fila fila = new Fila(5);
        fila.enfileirar(new Documento("Documento1.pdf", 120));
        fila.enfileirar(new Documento("Relatorio.docx", 85));
        fila.enfileirar(new Documento("Foto.png", 300));
        fila.mostrarFila();

        System.out.println("Imprimindo: " + fila.desenfileirar().getNome());
        fila.mostrarFila();
    }
}