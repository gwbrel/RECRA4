public class QuickSortIterativo {
    // metodo para implementar o algoritmo de QuickSort de maneira iterativa
    public static ExecutionStats quickSort(int[] array) {
        // cria de um objeto para armazenar os dados da execução do algoritmo
        ExecutionStats stats = new ExecutionStats();

        // calcula o tamanho do array utilizando o método calcularTamanho
        int n = Util.calcularTamanho(array);

        // criamos uma pilha (stack) para armazenar os indices de subarrays a serem processados
        int[] stack = new int[n];

        // inicializa o topo da pilha como -1 (pra indicar que esta vazia)
        int top = -1;

        // coloca os índices iniciais (0 e n-1) na pilha para iniciar a divisão do array
        stack[++top] = 0;
        stack[++top] = n - 1;

        // enquanto houver elementos na pilha continua processando os subarrays
        while (top >= 0) {
            // pega o índice final (end) do subarray que vai ser processado
            int end = stack[top--];
            // pega o índice inicial (start) do subarray que vai ser processado
            int start = stack[top--];

            // incrementa o número de iterações realizadas
            stats.numeroIteracoes++;

            // chama o método partition para dividir o array em dois subarrays, e retorna o índice da partição
            int p = partition(array, start, end, stats);

            // se houver elementos na esquerda da partição, adiciona o subarray na pilha
            if (p - 1 > start) {
                stack[++top] = start;   // adiciona o índice inicial na pilha
                stack[++top] = p - 1;   // adiciona o índice final da parte esquerda na pilha
            }

            // se houver elementos na direita da particao, adiciona o subarray na pilha
            if (p + 1 < end) {
                stack[++top] = p + 1;   // adiciona o índice inicial da parte direita na pilha
                stack[++top] = end;     // adiciona o índice final à pilha
            }
        }
        // retorna o objeto de estatísticas apos a execução do QuickSort
        return stats;
    }

    // metodo de particionamento do array, que organiza os elementos menores que na esquerda e os maiores à direita
    private static int partition(int[] array, int start, int end, ExecutionStats stats) {
        // a funcao pivot é o último elemento do subarray
        int pivot = array[end];
        // i é o índice do menor elemento
        int i = start - 1;

        // vamos percorre todos os elementos do subarray (exceto o pivot)
        for (int j = start; j < end; j++) {
            // se o elemento atual for menor ou igual ao pivot, realiza a troca
            if (array[j] <= pivot) {
                i++; // incrementa o índice do menor elemento
                // troca os elementos de índice i e j
                swap(array, i, j);
                // incrementa o número de trocas realizadas
                stats.numeroTrocas++;
            }
        }

        // apos a iteracao, coloca o pivot no lugar correto
        swap(array, i + 1, end);
        // incrementa o numero de trocas
        stats.numeroTrocas++;

        // retorna o índice da partição
        return i + 1;
    }

    // metodo para trocar dois elementos no array
    private static void swap(int[] array, int i, int j) {
        // armazena temporariamente o valor do elemento na posicao i
        int temp = array[i];
        // substitui o valor na posição i pela posicao j
        array[i] = array[j];
        // substitui o valor na posição j pela posicao i
        array[j] = temp;
    }
}
