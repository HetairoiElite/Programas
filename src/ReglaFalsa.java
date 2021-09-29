import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * * @author Luis Angel Bolaños Santiago * @HetairoiElite
 */
public class ReglaFalsa {

        public static void main(String[] args) {
                double f1;
                double fu;
                double F;
                double x1 = 0;
                double xu = 0;
                double xr1;
                double xr2;
                double Ea;
                double error = 0;
                // int p = -1;
                boolean bandera = true;
                int contador = 0;
                boolean continuar = true;

                Scanner consola = new Scanner(System.in);
                try {
                        FileWriter fw = new FileWriter("Salida-ReglaFalsa.txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        // paso 1

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

                        bw.write("\n" + "x1 = " + x1);
                        System.out.println("x1 = " + x1);
                        bw.write("\n" + "xu = " + xu);
                        System.out.println("xu = " + xu);
                        // paso 2

                        // f1=-4* Math.pow(x1, 6)+5* Math.pow(x1, 5)-7* Math.pow(x1, 4)+13* Math.pow(x1,
                        // 3)+10* Math.pow(x1, 2)+10*x1+1;
                        // fu=-4* Math.pow(xu, 6)+5* Math.pow(xu, 5)-7* Math.pow(xu, 4)+13* Math.pow(xu,
                        // 3)+10* Math.pow(xu, 2)+10*xu+1;

                        // f1 = 7 * Math.pow(x1, p) - 2.15;
                        // fu = 7 * Math.pow(xu, p) - 2.15;

                        f1 = Funcion.CicloFuncion(valores, x1);
                        fu = Funcion.CicloFuncion(valores, xu);
                        // System.out.println(f1);
                        // f1 = Math.log(x1);

                        // fu = Math.log(xu);

                        xr1 = xu - ((fu * (x1 - xu)) / (f1 - fu));

                        bw.write("\n" + "xr =  " + String.format("%.6f", xu) + "  __  " + "  ("
                                        + String.format("%.6f", fu) + ")(" + String.format("%.6f", x1) + "-"
                                        + String.format("%.6f", xu) + ")");
                        System.out.println("xr =  " + String.format("%.6f", xu) + "  __  " + "  ("
                                        + String.format("%.6f", fu) + ")(" + String.format("%.6f", x1) + "-"
                                        + String.format("%.6f", xu) + ")");

                        bw.write("\n" + "\t\t      ------------------------------");
                        System.out.println("\t\t      ------------------------------");
                        bw.write("\n" + "\t\t            " + String.format("%.6f", f1) + "  - "
                                        + String.format("%.6f", fu));
                        System.out.println("\t\t            " + String.format("%.6f", f1) + "  - "
                                        + String.format("%.6f", fu));

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
                                bw.write("\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                                contador++;
                                // fu = Math.log(xr1);
                                // fu = 7 * Math.pow(xr1, p) - 2.15;

                                bw.write("\n" + "iteraciones = " + contador);
                                System.out.println("iteraciones = " + contador);

                                fu = Funcion.CicloFuncion(valores, xr1);
                                bw.write("\n" + "  x1 = " + String.format("%.6f", x1) + "\t");
                                System.out.print("  x1 = " + String.format("%.6f", x1) + "\t");
                                bw.write("\n" + "  xr = " + String.format("%.6f", xr1));
                                System.out.println("  xr = " + String.format("%.6f", xr1));

                                bw.write("\n" + "f(x1)= " + String.format("%.6f", f1) + "\t");
                                System.out.print("f(x1)= " + String.format("%.6f", f1) + "\t");
                                bw.write("\n" + "f(xr) = " + String.format("%.6f", fu));
                                System.out.println("f(xr) = " + String.format("%.6f", fu));

                                F = f1 * fu;

                                bw.write("\n" + "f(x1) * f(xr) = " + String.format("%.10f", F));
                                System.out.println("f(x1) * f(xr) = " + String.format("%.10f", F));

                                if (F < 0) {
                                        bw.write("\n" + String.format("%.10f", F) + " < Es menor a 0");
                                        System.out.println(String.format("%.10f", F) + " < Es menor a 0");
                                        bw.write("[x1,xr],xu= xr \t");
                                        System.out.print("[x1,xr],xu= xr \t");
                                        xu = xr1;
                                        // fu = 7 * Math.pow(xu, p) - 2.15;
                                        fu = Funcion.CicloFuncion(valores, xu);
                                        // fu = Math.log(xu);
                                        bw.write("\n" + "xu = " + String.format("%.6f", xu));
                                        System.out.println("xu = " + String.format("%.6f", xu));
                                        bw.write("\n" + "el subintervalo esta  [" + String.format("%.6f", x1) + ","
                                                        + String.format("%.6f", xr1) + "] \n");
                                        System.out.println("el subintervalo esta  [" + String.format("%.6f", x1) + ","
                                                        + String.format("%.6f", xr1) + "] \n");
                                } else if (F > 0) {
                                        bw.write("\n" + String.format("%.10f", F) + " > Es mallor a 0");
                                        System.out.println(String.format("%.10f", F) + " > Es mallor a 0");
                                        bw.write("\n" + "[xr,xu],x1=xr \t");
                                        System.out.print("[xr,xu],x1=xr \t");
                                        x1 = xr1;
                                        f1 = Funcion.CicloFuncion(valores, x1);
                                        // f1 = 7 * Math.pow(x1, p) - 2.15;
                                        // f1 = Math.log(x1);

                                        bw.write("\n" + "x1 = " + String.format("%.6f", x1));
                                        System.out.println("x1 = " + String.format("%.6f", x1));
                                        bw.write("\n" + "el subintervalo esta  [" + String.format("%.6f", xr1) + ","
                                                        + String.format("%.6f", xu) + "] \n");
                                        System.out.println("el subintervalo esta  [" + String.format("%.6f", xr1) + ","
                                                        + String.format("%.6f", xu) + "] \n");
                                } else if (F == 0) {
                                        bw.write("\n" + "el subintervalo esta xr " + String.format("%.6f", xr1));
                                        System.out.println("el subintervalo esta xr " + String.format("%.6f", xr1));
                                }

                                xr2 = xu - ((fu * (x1 - xu)) / (f1 - fu));
                                bw.write("\n" + "xr =  " + String.format("%.6f", xu) + "  __  " + "  ("
                                                + String.format("%.6f", fu) + ")(" + String.format("%.6f", x1) + "-"
                                                + String.format("%.6f", xu) + ")");
                                System.out.println("xr =  " + String.format("%.6f", xu) + "  __  " + "  ("
                                                + String.format("%.6f", fu) + ")(" + String.format("%.6f", x1) + "-"
                                                + String.format("%.6f", xu) + ")");
                                bw.write("\n" + "\t\t      ------------------------------");
                                System.out.println("\t\t      ------------------------------");
                                bw.write("\n" + "\t\t            " + String.format("%.6f", f1) + "  - "
                                                + String.format("%.6f", fu));
                                System.out.println("\t\t            " + String.format("%.6f", f1) + "  - "
                                                + String.format("%.6f", fu));

                                bw.write("\n" + "xr = " + String.format("%.6f", xr2) + "\n");
                                System.out.println("xr = " + String.format("%.6f", xr2) + "\n");

                                bw.write("\n" + "Ea = |(" + String.format("%.6f", xr2) + " - "
                                                + String.format("%.6f", xr1) + "  / " + String.format("%.6f", xr2)
                                                + " )|* " + " 100");
                                System.out.println("Ea = |(" + String.format("%.6f", xr2) + " - "
                                                + String.format("%.6f", xr1) + "  / " + String.format("%.6f", xr2)
                                                + " )|* " + " 100");

                                Ea = Math.abs((xr2 - xr1) / xr2) * 100;

                                bw.write("\n" + "Ea = " + String.format("%.6f", Ea) + " %");
                                System.out.println("Ea = " + String.format("%.6f", Ea) + " %");

                                if (Ea < error) {
                                        bw.write("\n" + String.format("%.6f", Ea) + "   es menor a " + error);
                                        System.out.println(String.format("%.6f", Ea) + "   es menor a" + error);

                                        bandera = false;
                                }

                                xr1 = xr2;
                                bw.write("\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n");
                        } while (bandera);

                        consola.close();
                        bw.close();
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }
}
