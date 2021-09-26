
import java.util.Scanner;

/**
 * 
 * * @author Luis Angel Bolaños Santiago
 */
public class ReglaFalsa {
    public static void main(String[] args) {
        double f1;
        double fu;
        double F;
        double x1;
        double xu;
        double xr1;
        double xr2;
        double Ea;
        int p = -1;
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

        System.out.println("x1 = " + x1);
        System.out.println("xu = " + xu);
        // paso 2

        // f1=-4* Math.pow(x1, 6)+5* Math.pow(x1, 5)-7* Math.pow(x1, 4)+13* Math.pow(x1,
        // 3)+10* Math.pow(x1, 2)+10*x1+1;
        // fu=-4* Math.pow(xu, 6)+5* Math.pow(xu, 5)-7* Math.pow(xu, 4)+13* Math.pow(xu,
        // 3)+10* Math.pow(xu, 2)+10*xu+1;

        f1 = 7 * Math.pow(x1, p) - 2.15;
        fu = 7 * Math.pow(xu, p) - 2.15;
        // f1=Math.log(x1);
        // fu=Math.log(xu);

        xr1 = xu - ((fu * (x1 - xu)) / (f1 - fu));

        System.out.println("xr =  " + String.format("%.6f", xu) + "  __  " + "  (" + String.format("%.6f", fu) + ")("
                + String.format("%.6f", x1) + "-" + String.format("%.6f", xu) + ")");
        System.out.println("\t\t      ------------------------------");
        System.out.println("\t\t            " + String.format("%.6f", f1) + "  - " + String.format("%.6f", fu));

        // ejercicio 1
        // f1= 3 * Math.pow(x1, 2) - 17 * x1 + 20;
        // fu= 3 * Math.pow(xr1, 2) - 17 * xr1 + 20;

        // ejercicio 8
        // f1 = - 9 * Math.pow(x1,6) + 15 * Math.pow(x1, 5) - 7*Math.pow(x1, 4) - 5 *
        // Math.pow(x1, 3) + 9 * Math.pow(x1, 2) -2 * x1 - 3 ;
        // fu = - 9 * Math.pow(xr1,6) + 15 * Math.pow(xr1, 5) - 7*Math.pow(xr1, 4) - 5 *
        // Math.pow(xr1, 3) + 9 * Math.pow(xr1, 2) -2 * xr1 - 3 ;

        //// ejercicio 10
        // f1=4* Math.pow(x1, 6)+5* Math.pow(x1, 5)-7* Math.pow(x1, 4)+13* Math.pow(x1,
        //// 3)+10* Math.pow(x1, 2)+10*x1+1;
        // fu=4* Math.pow(xr1, 6)+5* Math.pow(xr1, 5)-7* Math.pow(xr1, 4)+13*
        //// Math.pow(xr1, 3)+10* Math.pow(xr1, 2)+10*xr1+1;
        //
        // ejercicio 11

        // paso3
        do {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
            contador++;
            // fu=Math.log(xr1);
            fu = 7 * Math.pow(xr1, p) - 2.15;
            System.out.println("iteracioines = " + contador);
            System.out.print("  x1 = " + String.format("%.6f", x1) + "\t");
            System.out.println("  xr = " + String.format("%.6f", xr1));

            System.out.print("f(x1)= " + String.format("%.6f", f1) + "\t");
            System.out.println("f(xr) = " + String.format("%.6f", fu));

            F = f1 * fu;

            System.out.println("f(x1) * f(xr) = " + String.format("%.10f", F));

            if (F < 0) {

                System.out.println(String.format("%.10f", F) + " < Es menor a 0");
                System.out.print("[x1,xr],xu= xr \t");
                xu = xr1;
                fu = 7 * Math.pow(xu, p) - 2.15;

                // fu=Math.log(xu);
                System.out.println("xu = " + String.format("%.6f", xu));
                System.out.println("el subintervalo esta  [" + String.format("%.6f", x1) + ","
                        + String.format("%.6f", xr1) + "] \n");

            } else if (F > 0) {

                System.out.println(String.format("%.10f", F) + " > Es mallor a 0");
                System.out.print("[xr,xu],x1=xr \t");
                x1 = xr1;
                f1 = 7 * Math.pow(x1, p) - 2.15;
                // f1=Math.log(x1);

                System.out.println("x1 = " + String.format("%.6f", x1));
                System.out.println("el subintervalo esta  [" + String.format("%.6f", xr1) + ","
                        + String.format("%.6f", xu) + "] \n");

            } else if (F == 0) {
                System.out.println("el subintervalo esta xr " + String.format("%.6f", xr1));

            }

            xr2 = xu - ((fu * (x1 - xu)) / (f1 - fu));
            System.out.println("xr =  " + String.format("%.6f", xu) + "  __  " + "  (" + String.format("%.6f", fu)
                    + ")(" + String.format("%.6f", x1) + "-" + String.format("%.6f", xu) + ")");
            System.out.println("\t\t      ------------------------------");
            System.out.println("\t\t            " + String.format("%.6f", f1) + "  - " + String.format("%.6f", fu));

            System.out.println("xr = " + String.format("%.6f", xr2) + "\n");

            System.out.println("Ea = |(" + String.format("%.6f", xr2) + " - " + String.format("%.6f", xr1) + "  / "
                    + String.format("%.6f", xr2) + " )|* " + " 100");

            Ea = Math.abs((xr2 - xr1) / xr2) * 100;

            System.out.println("Ea = " + String.format("%.6f", Ea) + " %");

            if (Ea < .0001) {

                System.out.println(String.format("%.6f", Ea) + "   es menor a .001%");

                bandera = false;

            }

            xr1 = xr2;
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");

        } while (bandera);

        consola.close();

    }

}
