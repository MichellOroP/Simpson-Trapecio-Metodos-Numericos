
package dif_e_Integracion;

public class TrapecioCompuesto {

    // Funcion de ejemplo: f(x) = x^2
    public static double funcion(double x) {
        return x * x;
    }

    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    private static double calcularTrapecio(double a, double b, int n) {
        double h = calcularH(a, b, n);
        double suma = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            suma += funcion(xk);
        }

        return (h / 2) * (funcion(a) + 2 * suma + funcion(b));
    }

    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        if (tolerancia <= 0) {
            throw new IllegalArgumentException(
                "La tolerancia debe ser positiva.");
        }

        int n = 1;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = Double.MAX_VALUE;

        while (errorAbsoluto > tolerancia) {
            n *= 2;

            double integralNueva = calcularTrapecio(a, b, n);
            errorAbsoluto = Math.abs(
                integralNueva - integralAnterior);

            integralAnterior = integralNueva;
        }

        return integralAnterior;
    }
}
