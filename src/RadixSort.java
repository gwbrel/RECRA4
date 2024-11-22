public class RadixSort {
    // metodo principal para implementar o algoritmo Radix Sort
    public static ExecutionStats radixSort(int[] array) {
        // criacao de um objeto para armazenar as estatísticas de execução do algoritmo
        ExecutionStats stats = new ExecutionStats();

        // calcula o tamanho do array utilizando o método auxiliar calcularTamanho
        int n = Util.calcularTamanho(array);

        // encontra o valor maximo no array e determina o número de dígitos
        int max = getMax(array, n);

        // laco que aplica o Counting Sort para cada dígito, começando pelas unidades
        for (int exp = 1; max / exp > 0; exp *= 10) {
            // uncrementa o numero de iteracoes, uma vez para cada dígito processado
            stats.numeroIteracoes++;

            // executa o Counting Sort baseado no dígito atual e acumula o numero de trocas
            stats.numeroTrocas += countingSort(array, n, exp);
        }
        // retorna o objeto de estatísticas apos a execucao do Radix Sort
        return stats;
    }

    // metodo auxiliar que encontra o valor maximo em um array
    private static int getMax(int[] array, int n) {
        // inicializa o valor maximo como o primeiro elemento do array
        int max = array[0];

        // percorre o array para encontrar o valor máximo
        for (int i = 1; i < n; i++) {
            // atualiza o valor maximo se um elemento maior for encontrado
            if (array[i] > max) max = array[i];
        }
        // retorna o valor máximo do array
        return max;
    }

    // metodo para ordenar com base no dígito exp atual
    private static int countingSort(int[] array, int n, int exp) {
        // cria um array para armazenar o resultado ordenado temporariamente
        int[] output = new int[n];

        // cria um array de contagem para armazenar a contagem dos dígitos de 0 a 9
        int[] count = new int[10];

        // variável para contar o número de trocas feitas durante o processo
        int trocas = 0;

        // conta a ocorrencia de cada dígito (array[i] / exp) % 10 em todo o array
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // modifica o array de contagem para armazenar as posicoes finais dos elementos
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // construtor do array de saída processando os elementos do array original em ordem inversa
        for (int i = n - 1; i >= 0; i--) {
            // coloca cada elemento na posicao correta no array de saída
            output[count[(array[i] / exp) % 10] - 1] = array[i];

            // atualiza a contagem para o dígito específico, pois ele foi usado
            count[(array[i] / exp) % 10]--;

            // incrementa o número de trocas a cada vez que um elemento eh colocado no array de saída
            trocas++;
        }

        // copia o array de saída para o array original, atualizando-o com a ordem parcial
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }

        // retorna o numero de trocas feitas durante essa execucao de counting sort
        return trocas;
    }
}
