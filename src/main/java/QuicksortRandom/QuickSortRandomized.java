package QuicksortRandom;

/*Ejercicicio hashMap de medición de tiempo de ejeución
* Realizado por: Adrian Espinosa
* Para curo de Algortimos 3
* Desarrolle un algoritmo que se ejecute 100 veces y utilice un mapa hash para insertar 100 000 números aleatorios como cadenas y mida:
    cuánto tiempo se tarda en agregar todas las claves, cuánto tiempo en nanosegundos se tardará en obtener uno de los números generados
    cuántos buckets se necesitaban

* */
import java.util.Arrays;
import java.util.Random;

public class QuickSortRandomized {

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7,13,52, 3, 1, 15};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }

    // Función principal de QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partición alrededor del pivote aleatorio
            int pivotIndex = partition(arr, low, high);

            // Llamadas recursivas a QuickSort para las submatrices izquierda y derecha del pivote
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Función para realizar la partición alrededor del pivote aleatorio
    public static int partition(int[] arr, int low, int high) {
        // Selecciona el índice del pivote de manera aleatoria
        int randomIndex = getRandomIndex(low, high);

        // Intercambia el elemento aleatorio con el elemento en el extremo derecho (similar al último elemento)
        swap(arr, randomIndex, high);

        int pivot = arr[high];
        int i = low - 1;

        // Recorre la submatriz y coloca elementos menores que el pivote a la izquierda
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Coloca el pivote en su posición final
        swap(arr, i + 1, high);

        // Retorna el índice del pivote después de la partición
        return i + 1;
    }

    // Función para intercambiar dos elementos en la matriz
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Función para obtener un índice aleatorio dentro del rango [low, high]
    public static int getRandomIndex(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
}
