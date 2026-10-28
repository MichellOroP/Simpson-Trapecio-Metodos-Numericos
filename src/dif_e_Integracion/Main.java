
package dif_e_Integracion;

public class Main {

    public static void main(String[] args) {

        // Intervalo de integracion
        double a = 0.0;
        double b = 2.0;

        // Misma tolerancia para ambos metodos
        double tolerancia = 0.000001;

        System.out.println("====================================");
        System.out.println("     METODOS DE INTEGRACION");
        System.out.println("====================================");

        System.out.println("Funcion: f(x) = x^2");
        System.out.println("Intervalo: [" + a + ", " + b + "]");
        System.out.println("Tolerancia: " + tolerancia);

        System.out.println("\n--- TRAPECIO COMPUESTO ---");

        double resultadoTrapecio =
                TrapecioCompuesto.integrarConTolerancia(
                        a, b, tolerancia);

        System.out.printf(
                "Resultado: %.10f%n", resultadoTrapecio);

        System.out.println("\n--- SIMPSON 1/3 COMPUESTO ---");

        double resultadoSimpson =
                SimpsonCompuesto.integrarConTolerancia(
                        a, b, tolerancia);

        System.out.printf(
                "Resultado: %.10f%n", resultadoSimpson);

        // Valor exacto de la integral de x^2 entre 0 y 2
        double valorExacto = 8.0 / 3.0;

        System.out.println("\n--- ANALISIS COMPARATIVO ---");

        System.out.printf(
                "Valor exacto: %.10f%n", valorExacto);

        System.out.printf(
                "Error absoluto Trapecio: %.10f%n",
                Math.abs(valorExacto - resultadoTrapecio));

        System.out.printf(
                "Error absoluto Simpson: %.10f%n",
                Math.abs(valorExacto - resultadoSimpson));

        System.out.println("\nComparacion finalizada.");
    }
}
