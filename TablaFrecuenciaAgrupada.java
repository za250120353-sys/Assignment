import java.util.Arrays;

public class TablaFrecuenciaAgrupada {

    private double[] datos;
    private int numeroClases;
    private double anchoClase;

    private int[] frecuenciaAbsoluta;
    private int[] frecuenciaAcumulada;
    private double[] frecuenciaRelativa;
    private double[] frecuenciaRelativaAcumulada;

    private double[] limitesInferiores;
    private double[] limitesSuperiores;
    private double[] puntoMedio;

    public TablaFrecuenciaAgrupada(double[] datos) {
        this.datos = datos;
        Arrays.sort(this.datos);

        calcularNumeroClases();
        calcularAnchoClase();
        generarClases();
        calcularFrecuencias();
    }

    private void calcularNumeroClases() {
        // Regla de Sturges
        numeroClases = (int) Math.ceil(1 + 3.322 * Math.log10(datos.length));
    }

    private void calcularAnchoClase() {
        double rango = datos[datos.length - 1] - datos[0];
        anchoClase = Math.ceil(rango / numeroClases);
    }

    private void generarClases() {
        limitesInferiores = new double[numeroClases];
        limitesSuperiores = new double[numeroClases];
        puntoMedio = new double[numeroClases];

        double inicio = datos[0];

        for (int i = 0; i < numeroClases; i++) {
            limitesInferiores[i] = inicio + i * anchoClase;
            limitesSuperiores[i] = limitesInferiores[i] + anchoClase - 1;
            puntoMedio[i] = (limitesInferiores[i] + limitesSuperiores[i]) / 2;
        }
    }

    private void calcularFrecuencias() {
        frecuenciaAbsoluta = new int[numeroClases];
        frecuenciaAcumulada = new int[numeroClases];
        frecuenciaRelativa = new double[numeroClases];
        frecuenciaRelativaAcumulada = new double[numeroClases];

        int total = datos.length;

        // Frecuencia absoluta
        for (double v : datos) {
            for (int i = 0; i < numeroClases; i++) {
                if (v >= limitesInferiores[i] && v <= limitesSuperiores[i]) {
                    frecuenciaAbsoluta[i]++;
                    break;
                }
            }
        }

        // Calcular acumuladas y relativas
        int acumulado = 0;
        double acumuladoFr = 0;

        for (int i = 0; i < numeroClases; i++) {
            acumulado += frecuenciaAbsoluta[i];
            frecuenciaAcumulada[i] = acumulado;

            frecuenciaRelativa[i] = (double) frecuenciaAbsoluta[i] / total;

            acumuladoFr += frecuenciaRelativa[i];
            frecuenciaRelativaAcumulada[i] = acumuladoFr;
        }
    }

    public void imprimirTabla() {
        System.out.println("\n=========== TABLA DE FRECUENCIAS AGRUPADAS ===========");
        System.out.printf("%-7s %-12s %-12s %-10s %-10s %-10s %-10s%n",
                "Clase", "Límite Inf", "Límite Sup", "f", "Fa", "fr", "fra");

        for (int i = 0; i < numeroClases; i++) {
            System.out.printf("%-7d %-12.0f %-12.0f %-10d %-10d %-10.2f %-10.2f%n",
                    (i + 1),
                    limitesInferiores[i],
                    limitesSuperiores[i],
                    frecuenciaAbsoluta[i],
                    frecuenciaAcumulada[i],
                    frecuenciaRelativa[i],
                    frecuenciaRelativaAcumulada[i]
            );
        }

        System.out.println("=======================================================");
        System.out.println("Total datos = " + datos.length);
        System.out.println("Número de clases = " + numeroClases);
    }

    public int getTotalDatos() {
        return 0;
    }

    public int getNumeroClases() {
    }
}
