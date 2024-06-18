public class Alimento extends Doacao {
  private String tipo;
  private String validade;

  public Alimento(String tipo, String validade) {
      this.tipo = tipo;
      this.validade = validade;
  }

  // Getters e Setters
  public String getTipo() { return tipo; }
  public void setTipo(String tipo) { this.tipo = tipo; }

  public String getValidade() { return validade; }
  public void setValidade(String validade) { this.validade = validade; }

  @Override
  public String toString() {
      return "Alimento{" +
              "tipo='" + tipo + '\'' +
              ", validade='" + validade + '\'' +
              '}';
  }
}
