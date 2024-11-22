public class ExecutionStats {
    // variavel de declaração que armazena informações sobre a execução do algoritmo
    public long tempoExecucao;  // variavel que armazena o tempo de execucao do algoritmo em nanossegundos
    public int numeroTrocas;    // Variavel que armazena o numero de trocas feitas durante a execucao
    public int numeroIteracoes; // variavel que armazena o numero de iteracoes feitas durante a execucao

    // cria classe, e inicializa as variaveis com valores padrao
    public ExecutionStats() {
        //  inicializa o tempo de execução para 0
        this.tempoExecucao = 0;
        // inicializa o número de trocas como 0
        this.numeroTrocas = 0;
        // inicializa o número de iterações como 0
        this.numeroIteracoes = 0;
    }

    // metodo para imprimir a lista de execucao do algoritmo
    public void printStats(String nomeAlgoritmo) {
        // imprime o nome do algoritimo junto com suas estatisticas
        System.out.println(nomeAlgoritmo + ":");
        // imprime o tempo da execucao em nanossegundos
        System.out.println("Tempo de execução: " + tempoExecucao + " ns");
        // imprime o numero das trocas realizadas
        System.out.println("Número de trocas: " + numeroTrocas);
        // imprime o numero de iteracoes realizadas
        System.out.println("Número de iterações: " + numeroIteracoes);
        // imprime uma linha em branco para separar os resultados
        System.out.println();
    }
}
