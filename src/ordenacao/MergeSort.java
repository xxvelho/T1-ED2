package ordenacao;
import armazenamento.Dados;

public class MergeSort<T extends Comparable<T>> {

    public void sort(Dados<T>[] array) {
        if (array.length <= 1) {
            return;
        }

        int meio = array.length / 2;
        Dados<T>[] metadeEsquerda = new Dados[meio];
        Dados<T>[] metadeDireita = new Dados[array.length - meio];

        System.arraycopy(array, 0, metadeEsquerda, 0, meio);
        System.arraycopy(array, meio, metadeDireita, 0, array.length - meio);

        sort(metadeEsquerda);
        sort(metadeDireita);

        merge(array, metadeEsquerda, metadeDireita);
    }

    private void merge(Dados<T>[] resultado, Dados<T>[] esquerda, Dados<T>[] direita) {
        int indiceEsquerda = 0;
        int indiceDireita = 0;
        int indiceResultado = 0;

        while (indiceEsquerda < esquerda.length && indiceDireita < direita.length) {
            if (esquerda[indiceEsquerda].compareTo(direita[indiceDireita]) <= 0) {
                resultado[indiceResultado] = esquerda[indiceEsquerda];
                indiceEsquerda++;
            } else {
                resultado[indiceResultado] = direita[indiceDireita];
                indiceDireita++;
            }
            indiceResultado++;
        }

        // Copia os elementos restantes, se houver, dos arrays de esquerda e direita para o resultado
        System.arraycopy(esquerda, indiceEsquerda, resultado, indiceResultado, esquerda.length - indiceEsquerda);
        System.arraycopy(direita, indiceDireita, resultado, indiceResultado, direita.length - indiceDireita);
    }
}
