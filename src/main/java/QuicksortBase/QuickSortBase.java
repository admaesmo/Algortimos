package QuicksortBase;
import java.util.Arrays;
import java.util.Random;

public class QuickSortBase {

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7, 3, 1, 15};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }

    // Función principal de QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partición alrededor del pivote
            int pivotIndex = partition(arr, low, high);

            // Llamadas recursivas a QuickSort para las submatrices izquierda y derecha del pivote
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Función para realizar la partición alrededor del pivote
    public static int partition(int[] arr, int low, int high) {
        // Selecciona el pivote al extremo derecho
        int pivotIndex = high;
        int pivot = arr[pivotIndex];

        // Índice para seguir la posición del último elemento menor que el pivote
        int i = low - 1;

        // Recorre la submatriz y coloca elementos menores que el pivote a la izquierda
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Coloca el pivote en su posición final
        swap(arr, i + 1, pivotIndex);

        // Retorna el índice del pivote después de la partición
        return i + 1;
    }

    // Función para intercambiar dos elementos en la matriz
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
