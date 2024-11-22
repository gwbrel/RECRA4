public class Util {

    // metodo para calcular o tamanho de um array de int
    public static int calcularTamanho(int[] array) {
        // Inicializa um contador para armazenar o tamanho do array
        int count = 0;

        // bloco try para capturar excecoes quando o índice estiver fora dos limites
        try {
            // laco infinito que vai tentar acessar os elementos do array ate que ocorra uma excecao
            while (true) {
                // acessa o elemento na posicao atual e incrementa o contador
                int temp = array[count];
                count++;
            }
        } catch (Exception e) {
            // captura a exececao quando o índice ultrapassa o tamanho do array,
            // indicando que o array foi totalmente percorrido
        }

        // retorna o contador, que agora representa o tamanho total do array
        return count;
    }

    // metodo para calcular o tamanho de um array bidimensional de int
    public static int calcularTamanho(int[][] array) {
        // inicializa um contador para armazenar o número de sub-arrays no array bidimensional
        int count = 0;

        // bloco try para capturar excecoes quando o índice estiver fora dos limites
        try {
            // laco infinito que tentara acessar os sub-arrays ate que ocorra uma excecao
            while (true) {
                // acessa o sub-array na posicao atual e incrementa o contador
                int[] temp = array[count];
                count++;
            }
        } catch (Exception e) {
            // captura a excecao quando o índice ultrapassa o numero de sub-arrays
        }

        // retorna o contador, que agora representa o numero de sub-arrays no array bidimensional
        return count;
    }
}
