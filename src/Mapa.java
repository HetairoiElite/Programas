//

public class Mapa {

  int exponente;
  double valor;

  public Mapa(int exponente, double valor) {
    this.exponente = exponente;
    this.valor = valor;
  }

  public void setExponente(int exponente) {
    this.exponente = exponente;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public int getExponente() {
    return exponente;
  }

  public double getValor() {
    return valor;
  }
}
