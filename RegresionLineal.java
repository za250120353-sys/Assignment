public class RegresionLineal {

    private double b0;
    private double b1;

    public void calcularCoeficientes(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        b1 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        b0 = (sumY - b1 * sumX) / n;
    }

    public double getB0() {
        return b0;
    }

    public double getB1() {
        return b1;
    }

    public void imprimirEcuacion() {
        System.out.printf("Ecuación de regresión: y = %.4f + %.4fx%n", b0, b1);
    }
}
