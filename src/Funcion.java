import java.util.InputMismatchException;
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
        if (tam < 0) {
          throw new Exception("No se admiten valores negativos.");
        }
        continuar = false;
      } catch (InputMismatchException e) {
        System.out.println("Error: Tipo de dato incorrecto.");
        consola.nextLine();
      } catch (Exception e) {
        System.out.println(e.getMessage());
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

  public static Mapa[] Derivada(Mapa[] valores) {
    for (int i = 0; i < valores.length; i++) {
      if (valores[i].getExponente() == 0) {
        valores[i].setValor(0);
      } else {
        //valores

        //Hash
      }
    }

    return valores;
  }

  public static Mapa[] PedirFuncionNewton() {
    boolean continuar = true;
    Mapa[] valores;

    int tam = 0;
    do {
      try {
        System.out.println("Inserte el grado de la funcion => ");
        tam = consola.nextInt();
        if (tam < 0) {
          throw new Exception("No se admiten valores negativos.");
        }
        continuar = false;
      } catch (InputMismatchException e) {
        System.out.println("Error: Tipo de dato incorrecto.");
        consola.nextLine();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } while (continuar);
    continuar = true;

    valores = new Mapa[tam + 1];

    for (int i = valores.length - 1; 0 <= i; i--) {
      do {
        try {
          System.out.println("Digite el valor para x^" + i);
          double valor = consola.nextDouble();
          continuar = false;
          valores[i] = new Mapa(i, valor);
        } catch (Exception e) {
          System.out.println("Error: Tipo de dato incorrecto.");
        }
      } while (continuar);
      continuar = true;
    }

    return valores;
  }

  public static double CicloFuncionNewton(Mapa[] valores, double x) {
    double resultado = 0;

    for (int i = 0; i < valores.length; i++) {
      System.out.print(valores[i] + "*" + x + "^" + i + "+");
      double val = Math.pow(x, valores[i].getExponente());
      val *= valores[i].getValor();
      resultado += val;
    }

    return resultado;
  }
}
