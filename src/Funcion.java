import java.util.Scanner;

public class Funcion {

    public static Scanner consola = new Scanner(System.in);

    public static double[] PedirFuncion() {
        boolean continuar = true;
        double valores[];
        int tam = 0;
        do {
            try {

                System.out.println("Inserte el grado de la funcion => ");
                tam = consola.nextInt();
                continuar = false;

            } catch (Exception e) {
                System.out.println("Error: Tipo de dato incorrecto.");
                consola.nextLine();
            }
        } while (continuar);
        continuar = true;

        valores = new double[tam + 1];

        for (int i = valores.length - 1; 0 <= i; i--) {
            do {
                try {

                    System.out.println("Digite el valor para x^" + i);
                    valores[i] = consola.nextDouble();
                    continuar = false;

                } catch (Exception e) {
                    System.out.println("Error: Tipo de dato incorrecto.");
                }
            } while (continuar);
            continuar = true;
        }

        return valores;

    }

    public static double CicloFuncion(double[] valores, double x) {
        double resultado = 0;

        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + "*" + x + "^" + i + "+");
            double val = Math.pow(x, i);
            val *= valores[i];
            resultado += val;

        }

        return resultado;
    }
}
