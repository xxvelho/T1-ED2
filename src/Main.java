import armazenamento.Dados;
import java.util.Arrays;

public class Main {
    //QUESTÃO 01
    public static Dados<?>[] kthLargestElements(Dados<?>[] V1, int[] P) {
        Arrays.sort(V1);//mudar mengeSort
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

    public static void main(String[] args) {
        Q1();

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
}