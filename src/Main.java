import armazenamento.Dados;
import java.util.Arrays;
import ordenacao.MergeSort;

public class Main {
    //QUESTÃO 01
    public static Dados<?>[] kthLargestElements(Dados<?>[] V1, int[] P) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(V1); //Ordenando vetor com mergeSort - O(n log n)

        Dados<?>[] result = new Dados[P.length];

        for (int i = 0; i < P.length; i++) {
            int k = P[i] - 1;
            if (k >= 0 && k < V1.length){
                result[i] = V1[k];
            }else{
                result[i] = null;
            }
        }
        return result;
    }

    //QUESTÃO 02
    public static Dados<?>[] encontrarMediana(Dados<?>[] V1, Dados<?>[] V2) {
        // Combina os dois vetores em um único vetor
        Dados<?>[] vetorCombinado = new Dados[V1.length + V2.length];
        System.arraycopy(V1, 0, vetorCombinado, 0, V1.length);
        System.arraycopy(V2, 0, vetorCombinado, V1.length, V2.length);

        // Ordena o vetor combinado
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(vetorCombinado); //Ordenando vetor com mergeSort - O(n log n)

        int tamanho = vetorCombinado.length;
        Dados<?>[] mediana = new Dados[2];
        // Encontra a mediana do vetor combinado
        if (tamanho % 2 == 0) {
            // Se o tamanho do vetor for par, a mediana é a média dos dois elementos do meio
            mediana[0] = vetorCombinado[tamanho / 2 - 1];
            mediana[1] = vetorCombinado[tamanho / 2];
        } else {
            // Se o tamanho do vetor for ímpar, a mediana é o elemento do meio
            mediana[0] = vetorCombinado[tamanho / 2];
        }
        return mediana;
    }

    //QUESTÃO 03 A)
    public static boolean DistanciaTEntreElementosA(Dados<?>[] V1, int T) {
        for (int i = 0; i < V1.length; i++) {
            for (int j = i + 1; j < V1.length; j++) {
                if (V1[i].getValue() instanceof Number && V1[j].getValue() instanceof Number) {
                    // Verifica se V1[i] e V1[j] são números (para realizar a diferença)
                    double diff = Math.abs(((Number) V1[i].getValue()).doubleValue() - ((Number) V1[j].getValue()).doubleValue());
                    if (diff == T) {
                        return true;
                    }
                } else if (V1[i].getValue() instanceof String && V1[j].getValue() instanceof String) {
                    // Verifica se V1[i] e V1[j] são caracteres (para calcular a diferença ASCII)
                    int diff = Math.abs(((String) V1[i].getValue()).compareTo((String) V1[j].getValue()));
                    if (diff == T) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //QUESTAO 03 B)
    public static boolean DistanciaTEntreElementosB(Dados<?>[] vetor, int T) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(vetor); //Ordenando vetor com mergeSort - O(n log n)

        int esquerda = 0;
        int direita = 1;

        double diferenca = 0;
        while (direita < vetor.length) {

            if (vetor[esquerda].getValue() instanceof Number && vetor[direita].getValue() instanceof Number) {
                // Verifica se V1[i] e V1[j] são números (para realizar a diferença)
                diferenca = Math.abs(((Number) vetor[esquerda].getValue()).doubleValue() - ((Number) vetor[direita].getValue()).doubleValue());

            } else if (vetor[esquerda].getValue() instanceof String && vetor[direita].getValue() instanceof String) {
                // Verifica se V1[i] e V1[j] são caracteres (para calcular a diferença ASCII)
                diferenca = Math.abs(((String) vetor[esquerda].getValue()).compareTo((String) vetor[direita].getValue()));
            }

            if (diferenca == T) {
                return true;
            }else if (diferenca < T) {
                direita++;
            }else {
                esquerda++;
                if (esquerda == direita) {
                    direita++;
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        Q1();
        System.out.println();
        Q2Numeros();
        System.out.println();
        Q2Strings();
        System.out.println();
        Q3();
    }
    public  static void Q1(){
        Dados<Double>[] V1 = new Dados[]{
                new Dados<>(21.0),
                new Dados<>(19.0),
                new Dados<>(16.0),
                new Dados<>(13.0),
                new Dados<>(8.0),
                new Dados<>(5.3),
                new Dados<>(20.0)
        };
        int[] P = {2, 5};

        Dados<?>[] resposta = kthLargestElements(V1, P);

        //Impressão dos resultados
        for (Dados<?> dado : resposta) {
            System.out.println(dado);
        }
    }

    public static void Q2Numeros(){
        // Teste com números inteiros
        Dados<Integer>[] V1 = new Dados[] {
                new Dados<>(1),
                new Dados<>(3),
                new Dados<>(7),
                new Dados<>(5) };
        Dados<Integer>[] V2 = new Dados[] {
                new Dados<>(2),
                new Dados<>(40),
                new Dados<>(6) };

        Dados<?>[] mediana = encontrarMediana(V1, V2);


        for (Object m: mediana) {
            if(m != null){
                System.out.println(m);
            }
        }
    }

    public static void Q2Strings(){
        // Teste com strings
        Dados<String>[] V1 = new Dados[] {
                new Dados<>("apple"),
                new Dados<>("banana"),
                new Dados<>("watermelon"),
                new Dados<>("orange") };

        Dados<String>[] V2 = new Dados[] {
                new Dados<>("grape"),
                new Dados<>("kiwi"),
                new Dados<>("mango") };


        Dados<?>[] mediana = encontrarMediana(V1, V2);

        for (Object m: mediana) {
            if(m != null){
                System.out.println(m);
            }
        }
    }


    public static void Q3(){
        // Exemplo de uso
        Dados<Integer>[] V1 = new Dados[] {
                new Dados<>(1),
                new Dados<>(2),
                new Dados<>(3),
                new Dados<>(4),
                new Dados<>(50) };
        Dados<Integer>[] V2 = new Dados[] {
                new Dados<>("a"),
                new Dados<>("z"),
                new Dados<>("e"),
                new Dados<>("z"),
                new Dados<>("d") };

        boolean resultadoIntA= DistanciaTEntreElementosA(V1, 46);
        boolean resultadoStrA= DistanciaTEntreElementosA(V2, 2);

        System.out.println("Para o array de inteiros: " + resultadoIntA);
        System.out.println("Para o array de strings: " + resultadoStrA);

        boolean resultadoIntB = DistanciaTEntreElementosB(V1, 46);
        boolean resultadoStrB = DistanciaTEntreElementosB(V2, 2);

        System.out.println("Para o array de inteiros: " + resultadoIntB);
        System.out.println("Para o array de strings: " + resultadoStrB);
    }

}