public class Roupa extends Doacao {
  private String tipo;
  private String tamanho;

  public Roupa(String tipo, String tamanho) {
      this.tipo = tipo;
      this.tamanho = tamanho;
  }

  // Getters e Setters
  public String getTipo() { return tipo; }
  public void setTipo(String tipo) { this.tipo = tipo; }

  public String getTamanho() { return tamanho; }
  public void setTamanho(String tamanho) { this.tamanho = tamanho; }

  @Override
  public String toString() {
      return "Roupa{" +
              "tipo='" + tipo + '\'' +
              ", tamanho='" + tamanho + '\'' +
              '}';
  }
}
