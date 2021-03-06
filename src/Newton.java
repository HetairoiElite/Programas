import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Newton {

    public static void main(String[] args) {
        double f;
        double f1;
        double x = 0;
        double xr = 0;
        double error = 0;
        double Ea;
        boolean continuar = true;
        boolean bandera = true;
        int contador = 0;

        Scanner consola = new Scanner(System.in);

        Mapa[] valores = Funcion.PedirFuncionNewton();

        Mapa[] valoresD = Funcion.Derivada(valores);
        try {
            FileWriter fw = new FileWriter("Salida-Newton.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            do {
                try {
                    System.out.println("inserte el valor de x");
                    // double x = 1.420990;
                    x = consola.nextDouble();
                    continuar = false;
                } catch (InputMismatchException e) {
                    System.out.println("Tipo de dato incorrecto: " + e.getMessage());
                    consola.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
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
            do {
                contador++;

                bw.write("\n" + "iteraciones = " + contador);
                System.out.println("iteraciones = " + contador);
                // f = 3 * Math.pow(x, 2) - 17 * x + 20;
                // f = Math.log(x);
                f = Funcion.CicloFuncionNewton(valores, x);

                // System.out.println("fd = " + fd);
                // f = Math.round(fd*10000000d) / 10000000d;

                // f1 = 6 * x - 17;
                // f1 = 1 / x;
                f1 = Funcion.CicloFuncionNewton(valoresD, x);

                bw.write("\n" + "f = " + String.format("%.8f", f));
                System.out.println("f = " + String.format("%.8f", f));
                bw.write("\n" + "f1 = " + String.format("%.8f", f1));
                System.out.println("f1 = " + String.format("%.8f", f1));

                xr = x - (f / f1);

                bw.write("\n" + "xr = " + String.format("%.8f", xr));
                System.out.println("xr = " + String.format("%.8f", xr));

                Ea = Math.abs((xr - x) / xr) * 100;

                bw.write("\n" + "Ea = " + String.format("%.10f", Ea) + " %");
                System.out.println("Ea = " + String.format("%.10f", Ea) + " %");

                if (Ea < error) {
                    bandera = false;
                }

                x = xr;
                bw.close();
                consola.close();

                bw.write("\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
            } while (bandera);
        } catch (Exception e) {
            System.out.println();
        }

    }
}
