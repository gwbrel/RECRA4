public class Main {
    public static void main(String[] args) {
        // definicao dos array de datasets sugeridos pelo professor, cada um representando um conjuto de dado que irá ser ordenado
        int[][] datasets = {
                {1, 100, 2, 99, 3, 98, 4, 97, 5, 96, 6, 95, 7, 94, 8, 93, 9, 92, 10, 91, 11, 90, 12, 89, 13, 88, 14, 87, 15, 86, 16, 85, 17, 84, 18, 83, 19, 82, 20, 81, 21, 80, 22, 79, 23, 78, 24, 77, 25, 76},
                {1, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52},
                {50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
        };

        // aqui vamos itera sobre todos os datasets, realizando uma orndecao para cada um
        for (int i = 0; i < Util.calcularTamanho(datasets); i++) {
            // printar qual dataset esta sendo processado
            System.out.println("Dataset " + (i + 1) + ":");

            // criar uma copia do dataset atual para evitar alterações no original
            int[] data1 = manualCopy(datasets[i]);
            // calcular o inicio da execucao
            long start = System.nanoTime();
            // executa o merge sort no array copiado e armazena seus dados
            ExecutionStats statsMerge = MergeSortIterativo.mergeSort(data1);
            // calcular o tempo da execucao do merge sort
            statsMerge.tempoExecucao = System.nanoTime() - start;
            // imprimir os dados do merge sort
            statsMerge.printStats("Merge Sort Iterativo");

            // criar uma copia do dataset atual do radix para evitar alterações no original
            int[] data2 = manualCopy(datasets[i]);
            // calcular o inicio da execucao
            start = System.nanoTime();
            // executa o radix sort no array copiado e armazena seus dados
            ExecutionStats statsRadix = RadixSort.radixSort(data2);
            //  calcular o tempo da execucao do radix sort
            statsRadix.tempoExecucao = System.nanoTime() - start;
            // imprimir os dados do radix sort
            statsRadix.printStats("Radix Sort");

            // Cria uma nova cópia para o Quick Sort Iterativo
            int[] data3 = manualCopy(datasets[i]);
            // Marca o tempo de início para o Quick Sort Iterativo
            start = System.nanoTime();
            // Executa o Quick Sort Iterativo no array copiado e armazena as estatísticas
            ExecutionStats statsQuick = QuickSortIterativo.quickSort(data3);
            // Calcula o tempo de execução do Quick Sort
            statsQuick.tempoExecucao = System.nanoTime() - start;
            // Imprime as estatísticas do Quick Sort Iterativo
            statsQuick.printStats("Quick Sort Iterativo");

            // Imprime uma linha em branco para separar os resultados dos datasets
            System.out.println();
        }
    }

    // metodo que faz copia manual do array passado como parametro
    private static int[] manualCopy(int[] source) {
        // obtem o tamanho do array usando a função de utilidade
        int n = Util.calcularTamanho(source);
        // cria um novo array do mesmo tamanho do original
        int[] copy = new int[n];
        // copia elemento por elemento do array de origem para o novo array
        for (int i = 0; i < n; i++) {
            copy[i] = source[i];
        }
        // retorna a copia do array
        return copy;
    }
}
