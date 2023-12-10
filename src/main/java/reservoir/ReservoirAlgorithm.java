
/***
 * Ejecicio algoritmo de reservorio.
 * Adrian Epinosa
 * Algortimos 3
 * */
package reservoir;

import java.util.Random;

public class ReservoirAlgorithm {

    private int m; // Tamaño del subconjunto
    private int n; // Tamaño total del flujo
    private int[] reservoir; // Subconjunto de números
    private Random random; // Generador de números aleatorios

    public ReservoirAlgorithm(int m, int n) {
        this.m = m;
        this.n = n;
        this.reservoir = new int[m];
        this.random = new Random();
    }

    public void add(int x) {
        // Si el subconjunto está lleno, reemplazamos un elemento aleatorio con el nuevo elemento.
        if (reservoir.length == m) {
            int index = random.nextInt(m);
            reservoir[index] = x;
        } else {
            // Si el subconjunto no está lleno, agregamos el nuevo elemento al final.
            reservoir[reservoir.length - 1] = x;
        }
    }

    public int[] getReservoir() {
        return reservoir;
    }

    public static void main(String[] args) {
        // Creamos un objeto del algoritmo de reservorio con m = 10 y n = 20.
        ReservoirAlgorithm algorithm = new ReservoirAlgorithm(10, 20);

        // Generamos un flujo de números reales entre -10 y 10.
        int[] stream = new int[20];
        for (int i = 0; i < stream.length; i++) {
            stream[i] = (int) (random.nextDouble() * 20) - 10;
        }

        // Agregamos los elementos del flujo al subconjunto.
        for (int x : stream) {
            algorithm.add(x);
        }

        // Imprimimos el subconjunto.
        System.out.println(algorithm.getReservoir());
    }
}
