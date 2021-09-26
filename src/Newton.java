
import java.util.Scanner;


public class Newton {

    public static void main(String[] args) {

        double f;
        double f1;
        double x;
        double xr;
        double Ea;
        boolean bandera = true;
        int contador = 0;

        Scanner consola = new Scanner(System.in);
        do {

            contador++;

            System.out.println("iteracioines = " + contador);

            System.out.println("inserte el valor de x");
            // double x = 1.420990;
            x = consola.nextDouble();

            // f = 3 * Math.pow(x, 2) - 17 * x + 20;
            f = Math.log(x);

            // System.out.println("fd = " + fd);
            // f = Math.round(fd*10000000d) / 10000000d;

            // f1 = 6 * x - 17;
            f1 = 1 / x;

            System.out.println("f = " + String.format("%.8f", f));
            System.out.println("f1 = " + String.format("%.8f", f1));

            xr = x - (f / f1);

            System.out.println("xr = " + String.format("%.8f", xr));

            Ea = Math.abs((xr - x) / xr) * 100;
            System.out.println("Ea = " + String.format("%.10f", Ea) + " %");

            if (Ea < .0001) {

                bandera = false;

            }

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");

        } while (bandera);

        consola.close();

    }

}
