
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Luis Angel Bolaños Santiago
 */
public class Biseccion {

    static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        double f1;
        double fu;
        double F;
        double x1;
        double xu;
        double xr1;
        double xr2;
        double Ea;
        boolean bandera = true;
        int contador = 0;

        double[] valores = PedirFuncion();

        try {
            FileWriter fw = new FileWriter("Salida-biseccion.txt");
            BufferedWriter bw = new BufferedWriter(fw);

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
            xr1 = (x1 + xu) / 2;
            System.out.println("xr1 = " + xr1);

            // paso3
            do {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                bw.write("\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                contador++;

                System.out.println("iteracioines = " + contador);
                bw.write("\n" + "iteraciones = " + contador);
                System.out.print("  x1 = " + String.format("%.6f", x1) + "\t");
                bw.write("\n" + " x1 = " + String.format("%.6f", x1) + "\t");
                System.out.println("  xr = " + String.format("%.6f", xr1));
                bw.write("\n" + " xr = " + String.format("%.6f", xr1));

                // ejercicio 1
                // f1 = 3 * Math.pow(x1, 2) - 17 * x1 + 20;
                // fu = 3 * Math.pow(xr1, 2) - 17 * xr1 + 20;

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
                // f1=-4* Math.pow(x1, 6)+5* Math.pow(x1, 5)-7* Math.pow(x1, 4)+13* Math.pow(x1,
                //// 3)+10* Math.pow(x1, 2)+10*x1+1;
                // fu=-4* Math.pow(xr1, 6)+5* Math.pow(xr1, 5)-7* Math.pow(xr1, 4)+13*
                //// Math.pow(xr1, 3)+10* Math.pow(xr1, 2)+10*xr1+1;
                //
                // f1 = Math.log(x1);
                // fu = Math.log(xr1);
                f1 = CicloFuncion(valores, x1);
                System.out.println();
                fu = CicloFuncion(valores, xr1);

                System.out.print("f(x1)= " + String.format("%.6f", f1) + "\t");
                bw.write("\n" + "f(x1)= " + String.format("%.6f", f1) + "\t");
                System.out.println("f(xr) = " + String.format("%.6f", fu));
                bw.write("\n" + "f(xr) = " + String.format("%.6f", fu));
                F = f1 * fu;

                System.out.println("f(x1) * f(xr) = " + String.format("%.10f", F));
                bw.write("\n" + "f(x1)= " + String.format("%.10f", F));

                if (F < 0) {

                    System.out.println(String.format("%.10f", F) + " < Es menor a 0");
                    bw.write("\n" + String.format("%.10f", F) + "< Es menor a 0");
                    System.out.print("[x1,xr],xu= xr \t");
                    bw.write("\n" + "[x1,xr],xu= xr \t");
                    xu = xr1;
                    System.out.println("xu = " + String.format("%.6f", xu));
                    bw.write("\n" + "xu = " + String.format("%.6f", xu));
                    System.out.println("el subintervalo esta  [" + String.format("%.6f", x1) + ","
                            + String.format("%.6f", xr1) + "] \n");
                    bw.write("\n" + "el subintervalo esta [" + String.format("%.6f", x1) + ","
                            + String.format("%.6f", xr1) + "] \n");

                } else if (F > 0) {

                    System.out.println(String.format("%.10f", F) + " > Es mayor a 0");
                    bw.write("\n" + String.format("%.10f", F) + " > Es mayor a 0");
                    System.out.print("[xr,xu],x1=xr \t");
                    bw.write("\n" + "[xr,xu],x1=xr \t");
                    x1 = xr1;
                    System.out.println("x1 = " + String.format("%.6f", x1));
                    bw.write("\n" + "x1 = " + String.format("%.6f", x1));
                    System.out.println("el subintervalo esta  [" + String.format("%.6f", xr1) + ","
                            + String.format("%.6f", xu) + "] \n");

                    bw.write("\n" + "el subintervalo esta  [" + String.format("%.6f", xr1) + ","
                            + String.format("%.6f", xu) + "] \n");

                } else if (F == 0) {
                    System.out.println("el subintervalo esta xr " + String.format("%.6f", xr1));
                    bw.write("\n" + "el subintervalo esta xr " + String.format("%.6", xr1));

                }

                xr2 = (x1 + xu) / 2;
                System.out.println("xr =" + "(" + String.format("%.8f", x1) + "+" + String.format("%.8f", xu) + ")/2");
                bw.write("\n" + "xr =" + "(" + String.format("%.8f", xr1) + "+" + String.format("%.8f", xu) + ")/2");

                System.out.println("xr = " + String.format("%.6f", xr2) + "\n");
                bw.write("\n" + "xr = " + String.format("%.6f", xr2) + "\n");

                System.out.println("Ea = (|" + String.format("%.6f", xr2) + " - " + String.format("%.6f", xr1) + " | / "
                        + String.format("%.6f", xr2) + " )* " + " 100");
                bw.write("\n" + "Ea = (|" + String.format("%.6f", xr2) + " - " + String.format("%.6f", xr1) + " | / "
                        + String.format("%.6f", xr2) + " )* " + " 100");

                Ea = Math.abs((xr2 - xr1) / xr2) * 100;

                System.out.println("Ea = " + String.format("%.6f", Ea) + " %");
                bw.write("\n" + "Ea = " + String.format("%.6f", Ea) + " %");

                if (Ea < .001) {

                    System.out.println(String.format("%.6f", Ea) + "   es menor a .001%");
                    bw.write("\n" + String.format("%.6f", Ea) + " es menor a .001%");

                    bandera = false;

                }

                xr1 = xr2;
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                bw.write("\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");

            } while (bandera);

            consola.close();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

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
