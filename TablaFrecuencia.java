public class TablaFrecuencia {

    private String[] categorias;
    private int[] frecuenciaAbsoluta;
    private double[] frecuenciaRelativa;
    private double[] porcentajeFr;

    public TablaFrecuencia(String[] categorias, int[] frecuenciaAbsoluta) {
        this.categorias = categorias;
        this.frecuenciaAbsoluta = frecuenciaAbsoluta;
        this.frecuenciaRelativa = new double[categorias.length];
        this.porcentajeFr = new double[categorias.length];

        calcularFrecuencias();
    }

    private void calcularFrecuencias() {
        int total = 0;

        for (int f : frecuenciaAbsoluta) {
            total += f;
        }

        for (int i = 0; i < frecuenciaAbsoluta.length; i++) {
            frecuenciaRelativa[i] = (double) frecuenciaAbsoluta[i] / total;
            porcentajeFr[i] = frecuenciaRelativa[i] * 100;
        }
    }

    public void imprimirTabla() {
        System.out.println("\n=== TABLA DE FRECUENCIAS ===");
        System.out.printf("%-10s %-10s %-15s %-10s%n",
                "Clase", "f", "fr", "% fr");

        for (int i = 0; i < categorias.length; i++) {
            System.out.printf("%-10s %-10d %-15.4f %-10.2f%n",
                    categorias[i],
                    frecuenciaAbsoluta[i],
                    frecuenciaRelativa[i],
                    porcentajeFr[i]);
        }
    }
}
