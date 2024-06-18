import java.util.ArrayList;
import java.util.List;

public class Doador {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private List<Doacao> doacoes;

    public Doador(String nome, String cpf, String dataNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.doacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Doacao> getDoacoes() { return doacoes; }
    public void addDoacao(Doacao doacao) { this.doacoes.add(doacao); }

    @Override
    public String toString() {
        return "Doador{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", email='" + email + '\'' +
                ", doacoes=" + doacoes +
                '}';
    }
}
