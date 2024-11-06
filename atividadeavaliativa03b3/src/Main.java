import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Adicionando algumas vagas de exemplo
        estacionamento.adicionarVaga(new VagaEstacionamento(1, "pequeno"));
        estacionamento.adicionarVaga(new VagaEstacionamento(2, "médio"));
        estacionamento.adicionarVaga(new VagaEstacionamento(3, "grande"));

        while (opcao != 6) {
            System.out.println("Sistema de Gerenciamento de Estacionamento");
            System.out.println("1. Registrar Entrada de Veículo");
            System.out.println("2. Registrar Saída de Veículo");
            System.out.println("3. Exibir Vagas Ocupadas");
            System.out.println("4. Exibir Histórico de Veículo");
            System.out.println("5. Adicionar Vaga");
            System.out.println("6. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Placa: ");
                    String placaEntrada = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tamanho do Veículo (pequeno, médio, grande): ");
                    String tamanhoVeiculo = scanner.nextLine();

                    Veiculo veiculo = new Veiculo(placaEntrada, modelo, tamanhoVeiculo);
                    if (estacionamento.registrarEntrada(veiculo)) {
                        System.out.println("Veículo registrado com sucesso!");
                    } else {
                        System.out.println("Não há vagas disponíveis para o tamanho do veículo.");
                    }
                    break;

                case 2:
                    System.out.print("Placa do Veículo para Saída: ");
                    String placaSaida = scanner.nextLine();
                    double valor = estacionamento.registrarSaida(placaSaida);
                    if (valor >= 0) {
                        System.out.println("Saída registrada. Valor a pagar: R$ " + valor);
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;

                case 3:
                    estacionamento.exibirVagasOcupadas();
                    break;

                case 4:
                    System.out.print("Placa do Veículo: ");
                    String placaHistorico = scanner.nextLine();
                    estacionamento.exibirHistoricoVeiculo(placaHistorico);
                    break;

                case 5:
                    System.out.print("Número da Vaga: ");
                    int numeroVaga = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Tamanho da Vaga (pequeno, médio, grande): ");
                    String tamanhoVaga = scanner.nextLine();
                    estacionamento.adicionarVaga(new VagaEstacionamento(numeroVaga, tamanhoVaga));
                    System.out.println("Vaga adicionada com sucesso!");
                    break;

                case 6:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }
}
