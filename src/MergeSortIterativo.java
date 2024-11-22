public class MergeSortIterativo {
    // metodo para implementar o algoritmo de Merge Sort de maneira iterativa
    public static ExecutionStats mergeSort(int[] array) {
        // cria de um objeto para armazenar os dados da execução do algoritmo
        ExecutionStats stats = new ExecutionStats();

        // calcula o tamanho do array utilizando o método calcularTamanho
        int n = Util.calcularTamanho(array);

        // cria um array auxiliar para suportar o processo de mesclagem dos subarrays
        int[] aux = new int[n];

        // laco externo que controla o tamanho dos subarrays, iniciando em 1 e dobrando a cada iteracao
        for (int tamanho = 1; tamanho < n; tamanho *= 2) {
            // laço interno que percorre o array em blocos do tamanho definido, mesclando subarrays adjacentes
            for (int inicio = 0; inicio < n - tamanho; inicio += 2 * tamanho) {
                // calcula o meio do subarray atual
                int meio = inicio + tamanho - 1;

                // calcula o final do subarray atual, garantindo que nao ultrapasse o limite do array
                int fim = (inicio + 2 * tamanho - 1 < n) ? inicio + 2 * tamanho - 1 : n - 1;

                // incrementa o número de iterações realizadas
                stats.numeroIteracoes++;

                // chama o metodo merge para mesclar os subarrays, acumulando o numero de trocas
                stats.numeroTrocas += merge(array, aux, inicio, meio, fim);
            }
        }
        // retorna o objeto apos a execução do Merge Sort
        return stats;
    }

    // metodo para mesclar dois subarrays (definidos por inicio, meio e fim) de forma ordenada
    private static int merge(int[] array, int[] aux, int inicio, int meio, int fim) {
        // variavel que armazena o numero de trocas realizadas durante a mesclagem
        int trocas = 0;

        // copia os elementos do array original para o array auxiliar, no intervalo especificado
        for (int k = inicio; k <= fim; k++) {
            aux[k] = array[k];
        }

        // i e j para representar os índices iniciais das duas metades do subarray
        int i = inicio, j = meio + 1;

        // laço que percorre o intervalo [inicio, fim] e coloca os elementos em ordem
        for (int k = inicio; k <= fim; k++) {
            // se todos os elementos da primeira metade foram usados, vai copiar o restante da segunda metade
            if (i > meio) {
                array[k] = aux[j++];
            }
            // se todos os elementos da segunda metade foram usados, vai copiar o restante da primeira metade
            else if (j > fim) {
                array[k] = aux[i++];
            }
            // se o elemento atual da primeira metade eh menor ou igual ao da segunda, vai copiar para o array
            else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            }
            // se o elemento atual da segunda metade eh menor, vai copiar para o array e conta uma "troca"
            else {
                array[k] = aux[j++];
                trocas++;
            }
        }
        // retorna o numero de trocas realizadas durante a mesclagem do subarray atual
        return trocas;
    }
}
