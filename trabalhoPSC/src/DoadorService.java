import java.io.*;
import java.util.List;

public class DoadorService {
    private DoadorRepository doadorRepository;

    public DoadorService() {
        this.doadorRepository = new DoadorRepository();
    }

    public void adicionarDoador(Doador doador) {
        doadorRepository.adicionarDoador(doador);
    }

    public List<Doador> listarDoadores() {
        return doadorRepository.listarDoadores();
    }

    public Doador buscarDoadorPorCpf(String cpf) {
        return doadorRepository.buscarDoadorPorCpf(cpf);
    }

    public boolean removerDoador(String cpf) {
        return doadorRepository.removerDoador(cpf);
    }

    public void adicionarDoacao(String cpf, Doacao doacao) {
        Doador doador = doadorRepository.buscarDoadorPorCpf(cpf);
        if (doador != null) {
            doador.addDoacao(doacao);
        }
    }

    public void salvarDados(String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Doador doador : doadorRepository.listarDoadores()) {
                writer.write(doador.getNome() + ";" + doador.getCpf() + ";" + doador.getDataNascimento() + ";" + doador.getEmail());
                writer.newLine();
                for (Doacao doacao : doador.getDoacoes()) {
                    if (doacao instanceof Roupa) {
                        Roupa roupa = (Roupa) doacao;
                        writer.write("Roupa;" + roupa.getTipo() + ";" + roupa.getTamanho());
                    } else if (doacao instanceof Alimento) {
                        Alimento alimento = (Alimento) doacao;
                        writer.write("Alimento;" + alimento.getTipo() + ";" + alimento.getValidade());
                    } else if (doacao instanceof Dinheiro) {
                        Dinheiro dinheiro = (Dinheiro) doacao;
                        writer.write("Dinheiro;" + dinheiro.getValor());
                    }
                    writer.newLine();
                }
                writer.write("END_DONATIONS");
                writer.newLine();
            }
        }
    }

    public void carregarDados(String caminhoArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            Doador doador = null;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    doador = new Doador(partes[0], partes[1], partes[2], partes[3]);
                    doadorRepository.adicionarDoador(doador);
                } else if (partes.length == 3 && doador != null) {
                    if (partes[0].equals("Roupa")) {
                        doador.addDoacao(new Roupa(partes[1], partes[2]));
                    } else if (partes[0].equals("Alimento")) {
                        doador.addDoacao(new Alimento(partes[1], partes[2]));
                    }
                } else if (partes.length == 2 && doador != null) {
                    if (partes[0].equals("Dinheiro")) {
                        doador.addDoacao(new Dinheiro(Double.parseDouble(partes[1])));
                    }
                } else if (linha.equals("END_DONATIONS")) {
                    doador = null;
                }
            }
        }
    }
}
