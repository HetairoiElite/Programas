
import java.util.Scanner;

public class Secante {
    public static void main(String[] args) {
        double x1;
        double xu;
        double n1;

        double f1;
        double fu;
        double fx;
        double Ea;

        boolean bandera = true;
        int contador = 0;
        Scanner consola = new Scanner(System.in);
        // paso 1
        System.out.println("inserte el valor de x1");
        // double x = 1.420990;
        x1 = consola.nextDouble();
        System.out.println("inserte el valor de xu");
        // double x = 1.420990;
        xu = consola.nextDouble();

        do {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
            // f1= Math.pow(x1, 5)+Math.pow(x1, 3)+3;
            // fu= Math.pow(xu, 5)+Math.pow(xu, 3)+3;
            f1 = Math.log(x1);
            fu = Math.log(xu);
            contador++;
            System.out.println("iteracioines = " + contador);
            System.out.println("  x1 = " + String.format("%.6f", x1));
            System.out.println("  xu = " + String.format("%.6f", xu));
            System.out.println("  f1 = " + String.format("%.6f", f1));
            System.out.println("  fu = " + String.format("%.6f", fu));
            n1 = xu - ((xu - x1) / (fu - f1)) * fu;
            fx = Math.log(n1);
            // fx= Math.pow(n1, 5)+Math.pow(n1, 3)+3;

            System.out.println("  n1 = " + String.format("%.6f", n1));
            System.out.println("  fx = " + String.format("%.6f", fx));

            Ea = Math.abs((n1 - xu) / n1) * 100;
            System.out.println("Ea = " + String.format("%.6f", Ea) + "%");

            x1 = xu;
            xu = n1;

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
            if (Ea < .0001) {

                bandera = false;
            }

        } while (bandera);
        consola.close();

    }
}
