
package dif_e_Integracion;

public class SimpsonCompuesto {

    private static double calcularSimpson(
            double a, double b, int n) {

        if (n <= 0 || n % 2 != 0) {
            throw new IllegalArgumentException(
                "El numero de subintervalos debe ser par y positivo.");
        }

        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            // Indices impares: coeficiente 4
            if (k % 2 != 0) {
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                // Indices pares: coeficiente 2
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        double sumaTotal =
                TrapecioCompuesto.funcion(a)
                + 4 * sumaImpares
                + 2 * sumaPares
                + TrapecioCompuesto.funcion(b);

        return (h / 3) * sumaTotal;
    }

    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        if (!Double.isFinite(tolerancia) || tolerancia <= 0) {
            throw new IllegalArgumentException(
                "La tolerancia debe ser positiva y finita.");
        }

        int n = 2;
        int iteraciones = 0;

        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = Double.MAX_VALUE;

        while (errorAbsoluto > tolerancia) {

            if (n > Integer.MAX_VALUE / 2) {
                throw new IllegalStateException(
                    "Se excedio el limite de subintervalos.");
            }

            n *= 2;
            iteraciones++;

            double integralNueva =
                    calcularSimpson(a, b, n);

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
