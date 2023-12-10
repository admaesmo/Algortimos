/*Ejercicicio hashMap de medición de tiempo de ejeución
* Realizado por: Adrian Espinosa
* Para curo de Algortimos 3
* Desarrolle un algoritmo que se ejecute 100 veces y utilice un mapa hash para insertar 100 000 números aleatorios como cadenas y mida:
    cuánto tiempo se tarda en agregar todas las claves, cuánto tiempo en nanosegundos se tardará en obtener uno de los números generados
    cuántos buckets se necesitaban

* */
package HashMap;


import java.util.HashMap;
import java.util.Random;

public class hashmapEjercicio {

    public static void main(String[] args) {
        // Generamos 100 000 números aleatorios
        Random random = new Random();
        String[] numbers = new String[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = String.valueOf(random.nextInt());
        }

        // Creamos el hashmap
        HashMap<String, Integer> hashmap = new HashMap<>();

        // Medimos el tiempo que tarda en agregar todas las claves
        long start = System.nanoTime();
        for (String number : numbers) {
            hashmap.put(number, 0);
        }
        long end = System.nanoTime();
        System.out.println("Tiempo de inserción: " + (end - start) / 1000000 + " milisegundos");

        // Medimos el tiempo que tarda en obtener uno de los números generados
        start = System.nanoTime();
        hashmap.get(numbers[0]);
        end = System.nanoTime();
        System.out.println("Tiempo de búsqueda: " + (end - start) + " nanosegundos");

        // Medimos el número de buckets necesarios
        System.out.println("Número de buckets: " + hashmap.size());
    }
}
