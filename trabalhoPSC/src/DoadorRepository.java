import java.util.ArrayList;
import java.util.List;

public class DoadorRepository {
    private List<Doador> doadores;

    public DoadorRepository() {
        this.doadores = new ArrayList<>();
    }

    public void adicionarDoador(Doador doador) {
        doadores.add(doador);
    }

    public List<Doador> listarDoadores() {
        return new ArrayList<>(doadores);
    }

    public Doador buscarDoadorPorCpf(String cpf) {
        for (Doador doador : doadores) {
            if (doador.getCpf().equals(cpf)) {
                return doador;
            }
        }
        return null;
    }

    public boolean removerDoador(String cpf) {
        Doador doador = buscarDoadorPorCpf(cpf);
        if (doador != null) {
            doadores.remove(doador);
            return true;
        }
        return false;
    }
}
