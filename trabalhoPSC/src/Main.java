import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static final String ARQUIVO_DADOS = "doadores.txt";

    public static void main(String[] args) {
        DoadorService doadorService = new DoadorService();
        Scanner scanner = new Scanner(System.in);

        // Carregar dados ao iniciar o programa
        try {
            doadorService.carregarDados(ARQUIVO_DADOS);
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Nenhum dado existente encontrado. Iniciando com base de dados vazia.");
        }

        while (true) {
            System.out.println("\n====================================");
            System.out.println("           MENU DE DOAÇÕES          ");
            System.out.println("====================================");
            System.out.println("1. Adicionar Doador");
            System.out.println("2. Listar Doadores");
            System.out.println("3. Buscar Doador por CPF");
            System.out.println("4. Remover Doador");
            System.out.println("5. Adicionar Doação");
            System.out.println("6. Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Adicionar Doador ---");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Doador doador = new Doador(nome, cpf, dataNascimento, email);
                    doadorService.adicionarDoador(doador);
                    System.out.println("Doador adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Listar Doadores ---");
                    for (Doador d : doadorService.listarDoadores()) {
                        System.out.println(d);
                    }
                    break;

                case 3:
                    System.out.println("\n--- Buscar Doador por CPF ---");
                    System.out.print("CPF: ");
                    String cpfBusca = scanner.nextLine();
                    Doador doadorEncontrado = doadorService.buscarDoadorPorCpf(cpfBusca);
                    if (doadorEncontrado != null) {
                        System.out.println(doadorEncontrado);
                    } else {
                        System.out.println("Doador não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Remover Doador ---");
                    System.out.print("CPF: ");
                    String cpfRemover = scanner.nextLine();
                    boolean removido = doadorService.removerDoador(cpfRemover);
                    if (removido) {
                        System.out.println("Doador removido com sucesso.");
                    } else {
                        System.out.println("Doador não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Adicionar Doação ---");
                    System.out.print("CPF do Doador: ");
                    String cpfDoacao = scanner.nextLine();
                    System.out.println("\n--- Tipo de Doação: ---");
                    System.out.println("1. Roupa");
                    System.out.println("2. Alimento");
                    System.out.println("3. Dinheiro");
                    System.out.print("Escolha uma opção: ");
                    int tipoDoacao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Doacao doacao = null;
                    switch (tipoDoacao) {
                        case 1:
                            System.out.println("\n--- Adicionar Roupa ---");
                            System.out.print("Tipo de Roupa: ");
                            String tipoRoupa = scanner.nextLine();
                            System.out.print("Tamanho: ");
                            String tamanho = scanner.nextLine();
                            doacao = new Roupa(tipoRoupa, tamanho);
                            break;

                        case 2:
                            System.out.println("\n--- Adicionar Alimento ---");
                            System.out.print("Tipo de Alimento: ");
                            String tipoAlimento = scanner.nextLine();
                            System.out.print("Validade: ");
                            String validade = scanner.nextLine();
                            doacao = new Alimento(tipoAlimento, validade);
                            break;

                        case 3:
                            System.out.println("\n--- Adicionar Dinheiro ---");
                            System.out.print("Valor: ");
                            double valor = scanner.nextDouble();
                            scanner.nextLine(); // Limpar o buffer
                            doacao = new Dinheiro(valor);
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }

                    if (doacao != null) {
                        doadorService.adicionarDoacao(cpfDoacao, doacao);
                        System.out.println("Doação adicionada com sucesso!");
                    }
                    break;

                case 6:
                    System.out.println("Salvando dados e saindo...");
                    // Salvar dados ao sair do programa
                    try {
                        doadorService.salvarDados(ARQUIVO_DADOS);
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
