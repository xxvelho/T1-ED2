import armazenamento.Dados;

public class BHSI_Sort {

    public static <T extends Comparable<T>> void buildHeap(Dados<T>[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static <T extends Comparable<T>> void heapify(Dados<T>[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild].compareTo(arr[largest]) > 0) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild].compareTo(arr[largest]) > 0) {
            largest = rightChild;
        }

        if (largest != i) {
            Dados<T> temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static <T extends Comparable<T>> void selectionSort(Dados<T>[] arr, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < end; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Dados<T> temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(Dados<T>[] arr, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            Dados<T> key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Dados<Integer>[] arrNum = new Dados[]{
                new Dados<>(12),
                new Dados<>(11),
                new Dados<>(13),
                new Dados<>(5),
                new Dados<>(6),
                new Dados<>(7),
                new Dados<>(10),
                new Dados<>(8),
                new Dados<>(15),
                new Dados<>(14)
        };

        Dados<String>[] arrStr = new Dados[] {
                new Dados<>("kiwi"),
                new Dados<>("banana"),
                new Dados<>("watermelon"),
                new Dados<>("orange"),
                new Dados<>("grape"),
                new Dados<>("apple"),
                new Dados<>("mango"),
                new Dados<>("cherry"),
                new Dados<>("strawberry"),
                new Dados<>("avocado") };

        int m = arrNum.length;
        int n = arrStr.length;
        double E = 0.3;

        int endIndexNum = (int) (m * (1 - E));
        int endIndexStr = (int) (n * (1 - E));

        buildHeap(arrNum);
        selectionSort(arrNum, 0, endIndexNum);
        insertionSort(arrNum, endIndexNum, m);

        buildHeap(arrStr);
        selectionSort(arrStr, 0, endIndexStr);
        insertionSort(arrStr, endIndexStr, n);

        System.out.println("ArrayNum ordenado: ");
        for (Dados<Integer> dados : arrNum) {
            System.out.print(dados.getValue() + " ");
        }

        System.out.printf("\n\n");

        System.out.println("ArrayStr ordenado: ");
        for (Dados<String> dados : arrStr) {
            System.out.print(dados.getValue() + " ");
        }
    }
}
