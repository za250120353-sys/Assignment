#include <iostream>
#include <vector>
using namespace std;

int main() {
    // Dataset del caso Benetton (Advertising y Sales)
    vector<double> x = {23, 26, 30, 34, 43, 48, 52, 57, 58};
    vector<double> y = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};

    int n = x.size();
    double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

    for (int i = 0; i < n; i++) {
        sumX += x[i];
        sumY += y[i];
        sumXY += x[i] * y[i];
        sumX2 += x[i] * x[i];
    }

    // Cálculo de B1 y B0
    double b1 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
    double b0 = (sumY - b1 * sumX) / n;

    cout << "Ecuacion de regresion: y = " << b0 << " + " << b1 << "x" << endl;

    // Predicciones con 5 valores de Advertising
    vector<double> nuevosX = {20, 35, 45, 60, 70};
    cout << "\nPredicciones de Sales:\n";
    for (double val : nuevosX) {
        double pred = b0 + b1 * val;
        cout << "Advertising: " << val << " -> Sales estimado: " << pred << endl;
    }

    return 0;
}
