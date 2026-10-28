
package dif_e_Integracion;

public class TrapecioCompuesto {

    // Funcion de prueba: f(x) = x^2
    public static double funcion(double x) {
        return x * x;
    }

    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    private static double calcularTrapecio(
            double a, double b, int n) {

        double h = calcularH(a, b, n);
        double suma = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            suma += funcion(xk);
        }

        return (h / 2) *
                (funcion(a) + 2 * suma + funcion(b));
    }

    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        if (!Double.isFinite(tolerancia) || tolerancia <= 0) {
            throw new IllegalArgumentException(
                "La tolerancia debe ser positiva y finita.");
        }

        int n = 1;
        int iteraciones = 0;

        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = Double.MAX_VALUE;

        while (errorAbsoluto > tolerancia) {

            if (n > Integer.MAX_VALUE / 2) {
                throw new IllegalStateException(
                    "Se excedio el limite de subintervalos.");
            }

            n *= 2;
            iteraciones++;

            double integralNueva =
                    calcularTrapecio(a, b, n);

            errorAbsoluto = Math.abs(
                    integralNueva - integralAnterior);

            integralAnterior = integralNueva;
        }

        System.out.println("Iteraciones: " + iteraciones);
        System.out.println("Subintervalos (n): " + n);
        System.out.printf(
                "Error estimado: %.12f%n", errorAbsoluto);

        return integralAnterior;
    }
}

