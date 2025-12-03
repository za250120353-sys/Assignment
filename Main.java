public class Main {
    public static void main(String[] args) {

        // ---------------------------------------------
        // REGRESIÓN LINEAL
        // ---------------------------------------------
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 6, 8, 10};

        RegresionLineal regresion = new RegresionLineal();
        regresion.calcularCoeficientes(x, y);
        regresion.imprimirEcuacion();

        double b0 = regresion.getB0();
        double b1 = regresion.getB1();

        double[] nuevosX = {20, 35, 45, 60, 70};

        Prediccion pred = new Prediccion(b0, b1);
        pred.mostrarPredicciones(nuevosX);

        // ---------------------------------------------
        // TABLA DE FRECUENCIA NO AGRUPADA
        // ---------------------------------------------
        String[] clases = {"Carro", "Avion", "Tren", "Barco"};
        int[] frecuencia = {15, 13, 4, 8};

        TablaFrecuencia tabla = new TablaFrecuencia(clases, frecuencia);
        tabla.imprimirTabla();

        // ---------------------------------------------
        // TABLA DE FRECUENCIA AGRUPADA
        // ---------------------------------------------
        double[] datos = {
                25, 33, 31, 42, 38, 45, 47, 50, 56, 52,
                61, 69, 65, 70, 78, 40, 29, 30, 34, 36,
                55, 58, 62, 67, 73, 74, 28, 26, 32, 41
        };

        TablaFrecuenciaAgrupada tablaAgrupada = new TablaFrecuenciaAgrupada(datos);
        tablaAgrupada.imprimirTabla();
    }
}
