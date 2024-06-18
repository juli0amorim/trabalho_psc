public class Dinheiro extends Doacao {
  private double valor;

  public Dinheiro(double valor) {
      this.valor = valor;
  }

  // Getters e Setters
  public double getValor() { return valor; }
  public void setValor(double valor) { this.valor = valor; }

  @Override
  public String toString() {
      return "Dinheiro{" +
              "valor=" + valor +
              '}';
  }
}
