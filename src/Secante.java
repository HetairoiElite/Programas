
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.InputMismatchException;

public class Secante {
    public static void main(String[] args) {
        double x1 = 0;
        double xu = 0;
        double n1;

        double f1;
        double fu;
        double fx;
        double Ea;

        double error = 0;

        boolean continuar = true;
        boolean bandera = true;
        int contador = 0;
        Scanner consola = new Scanner(System.in);
        // paso 1
        try {
            FileWriter fw = new FileWriter("Salida-Newton.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            do {
                try {
                    System.out.println("inserte el valor de x1: ");
                    // double x = 1.420990;
                    x1 = consola.nextDouble();
                    continuar = false;
                } catch (Exception e) {
                    System.out.println("Tipo de dato incorrecto: " + e.getMessage());
                    consola.nextLine();
                }
            } while (continuar);
            continuar = true;

            do {
                try {
                    System.out.println("inserte el valor de xu: ");
                    // double x = 1.420990;
                    xu = consola.nextDouble();
                    continuar = false;
                } catch (Exception e) {
                    System.out.println("Tipo de dato incorrecto: " + e.getMessage());
                    consola.nextLine();
                }
            } while (continuar);
            continuar = true;

            do {
                try {
                    System.out.println("Inser el rango de error: ");
                    error = consola.nextDouble();
                    if (error < 0) {
                        throw new Exception("No se admiten valores negativos.");
                    }
                    continuar = false;
                } catch (InputMismatchException e) {
                    System.out.println("Tipo de dato incorrecto: " + e.getMessage());
                    consola.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (continuar);
            continuar = true;

            double[] valores = Funcion.PedirFuncion();
            do {
                bw.write("\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                // f1= Math.pow(x1, 5)+Math.pow(x1, 3)+3;
                // fu= Math.pow(xu, 5)+Math.pow(xu, 3)+3;
                // f1 = Math.log(x1);
                // fu = Math.log(xu);
                f1 = Funcion.CicloFuncion(valores, x1);
                fu = Funcion.CicloFuncion(valores, xu);
                contador++;
                System.out.println();
                bw.write("\n" + "iteraciones = " + contador);
                System.out.println("iteraciones = " + contador);
                bw.write("\n" + "  x1 = " + String.format("%.6f", x1));
                System.out.println("  x1 = " + String.format("%.6f", x1));
                bw.write("\n" + "  xu = " + String.format("%.6f", xu));
                System.out.println("  xu = " + String.format("%.6f", xu));
                bw.write("\n" + "  f1 = " + String.format("%.6f", f1));
                System.out.println("  f1 = " + String.format("%.6f", f1));
                bw.write("\n" + "  fu = " + String.format("%.6f", fu));
                System.out.println("  fu = " + String.format("%.6f", fu));
                n1 = xu - ((xu - x1) / (fu - f1)) * fu;
                // fx = Math.log(n1);
                fx = Funcion.CicloFuncion(valores, n1);
                // fx= Math.pow(n1, 5)+Math.pow(n1, 3)+3;

                bw.write("\n" + "  n1 = " + String.format("%.6f", n1));
                System.out.println("  n1 = " + String.format("%.6f", n1));
                bw.write("\n" + "  fx = " + String.format("%.6f", fx));
                System.out.println("  fx = " + String.format("%.6f", fx));

                Ea = Math.abs((n1 - xu) / n1) * 100;
                bw.write("\n" + "Ea = " + String.format("%.6f", Ea) + "%");
                System.out.println("Ea = " + String.format("%.6f", Ea) + "%");

                x1 = xu;
                xu = n1;

                bw.write("\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                if (Ea < error) {

                    bandera = false;
                }

            } while (bandera);
            consola.close();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
