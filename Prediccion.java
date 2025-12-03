public class Prediccion {

    private double b0;
    private double b1;

    public Prediccion(double b0, double b1) {
        this.b0 = b0;
        this.b1 = b1;
    }

    public double predecir(double x) {
        return b0 + b1 * x;
    }

    public void mostrarPredicciones(double[] nuevosX) {
        System.out.println("\nPredicciones:");
        for (double val : nuevosX) {
            double pred = predecir(val);
            System.out.printf("X = %.2f -> Y estimado: %.2f%n", val, pred);
        }
    }
}
