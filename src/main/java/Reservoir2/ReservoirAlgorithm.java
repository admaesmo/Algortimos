package Reservoir2;
import java.util.Random;

public class ReservoirAlgorithm {

    public static void main(String[] args) {
        int m = 10; // Tamaño del subconjunto
        int n = 20; // Tamaño total del flujo
        double[] stream = generateRandomStream(n);

        double[] reservoir = reservoirAlgorithm(stream, m);

        // Imprimir el subconjunto seleccionado
        System.out.println("Subconjunto seleccionado:");
        for (double value : reservoir) {
            System.out.print(value + " ");
        }
    }

    // Algoritmo de Reservoir
    private static double[] reservoirAlgorithm(double[] stream, int m) {
        double[] reservoir = new double[m];
        Random random = new Random();

        // Llenar el reservorio con los primeros m elementos del flujo
        for (int i = 0; i < m; i++) {
            reservoir[i] = stream[i];
        }

        // Procesar el resto del flujo
        for (int i = m; i < stream.length; i++) {
            int j = random.nextInt(i + 1);

            // Reemplazar un elemento en el reservorio con probabilidad m/i
            if (j < m) {
                reservoir[j] = stream[i];
            }
        }

        return reservoir;
    }

    // Generar un flujo de números aleatorios entre -10 y 10
    private static double[] generateRandomStream(int n) {
        double[] stream = new double[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            stream[i] = -10 + (20 * random.nextDouble()); // Números aleatorios entre -10 y 10
        }

        return stream;
    }
}
