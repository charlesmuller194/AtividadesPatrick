import entidades.Funcionario;
import entidades.ItemCardapio;
import entidades.Mesa;
import entidades.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaRestaurante {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Mesa> mesas = new ArrayList<>();
    private List<ItemCardapio> cardapio = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private double faturamentoDiario = 0.0;

    public static void main(String[] args) {
        SistemaRestaurante sistema = new SistemaRestaurante();
        sistema.preencherDadosFicticios();
        sistema.executar();
    }

    public void preencherDadosFicticios() {
        // Funcionários
        funcionarios.add(new Funcionario("Carlos Silva", 1, "Garçom"));
        funcionarios.add(new Funcionario("Ana Souza", 2, "Garçom"));
        funcionarios.add(new Funcionario("Mariana Oliveira", 3, "Cozinheiro"));
        funcionarios.add(new Funcionario("Roberto Costa", 4, "Gerente"));

        // Mesas
        mesas.add(new Mesa(1, 4));
        mesas.add(new Mesa(2, 2));
        mesas.add(new Mesa(3, 6));
        mesas.add(new Mesa(4, 4));
        mesas.add(new Mesa(5, 2));

        // Itens do Cardápio
        cardapio.add(new ItemCardapio("Picanha na Chapa", 101, 49.90, true));
        cardapio.add(new ItemCardapio("Espaguete à Bolonhesa", 102, 29.90, true));
        cardapio.add(new ItemCardapio("Caesar Salad", 103, 19.90, true));
        cardapio.add(new ItemCardapio("Suco de Laranja", 201, 7.50, true));
        cardapio.add(new ItemCardapio("Refrigerante", 202, 5.00, true));
        cardapio.add(new ItemCardapio("Água Mineral", 203, 3.00, true));
        cardapio.add(new ItemCardapio("Torta de Chocolate", 301, 12.00, true));
        cardapio.add(new ItemCardapio("Sorvete", 302, 8.00, true));
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("=== Sistema de Gerenciamento de Restaurante ===");
            System.out.println("1. Cadastro de Funcionário");
            System.out.println("2. Gerenciamento de Cardápio");
            System.out.println("3. Cadastro de Mesa");
            System.out.println("4. Registro de Pedido");
            System.out.println("5. Fechamento de Conta");
            System.out.println("6. Relatório de Vendas por Funcionário");
            System.out.println("7. Relatório de Faturamento Diário");
            System.out.println("0. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scanner);
                    break;
                case 2:
                    gerenciarCardapio(scanner);
                    break;
                case 3:
                    cadastrarMesa(scanner);
                    break;
                case 4:
                    registrarPedido(scanner);
                    break;
                case 5:
                    fecharConta(scanner);
                    break;
                case 6:
                    relatorioVendasPorFuncionario();
                    break;
                case 7:
                    relatorioFaturamentoDiario();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private void cadastrarFuncionario(Scanner scanner) {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Digite o cargo (Garçom, Cozinheiro, Gerente): ");
        String cargo = scanner.nextLine();
        Funcionario funcionario = new Funcionario(nome, id, cargo);
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso.");
    }

    private void gerenciarCardapio(Scanner scanner) {
        int opcao;
        do {
            System.out.println("=== Gerenciamento de Cardápio ===");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Atualizar Disponibilidade");
            System.out.println("4. Visualizar Cardápio");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            switch (opcao) {
                case 1:
                    adicionarItemCardapio(scanner);
                    break;
                case 2:
                    removerItemCardapio(scanner);
                    break;
                case 3:
                    atualizarDisponibilidadeItem(scanner);
                    break;
                case 4:
                    visualizarCardapio();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void adicionarItemCardapio(Scanner scanner) {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código do item: ");
        int codigo = scanner.nextInt();
        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        System.out.print("O item está disponível? (true/false): ");
        boolean disponibilidade = scanner.nextBoolean();
        ItemCardapio item = new ItemCardapio(nome, codigo, preco, disponibilidade);
        cardapio.add(item);
        System.out.println("Item adicionado com sucesso.");
    }

    private void removerItemCardapio(Scanner scanner) {
        System.out.print("Digite o código do item a ser removido: ");
        int codigo = scanner.nextInt();
        ItemCardapio itemRemover = null;
        for (ItemCardapio item : cardapio) {
            if (item.codigo == codigo) {
                itemRemover = item;
                break;
            }
        }
        if (itemRemover != null) {
            cardapio.remove(itemRemover);
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private void atualizarDisponibilidadeItem(Scanner scanner) {
        System.out.print("Digite o código do item: ");
        int codigo = scanner.nextInt();
        ItemCardapio itemAtualizar = null;
        for (ItemCardapio item : cardapio) {
            if (item.codigo == codigo) {
                itemAtualizar = item;
                break;
            }
        }
        if (itemAtualizar != null) {
            System.out.print("O item está disponível? (true/false): ");
            boolean disponibilidade = scanner.nextBoolean();
            itemAtualizar.disponibilidade = disponibilidade;
            System.out.println("Disponibilidade atualizada com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private void visualizarCardapio() {
        System.out.println("=== Itens do Cardápio ===");
        for (ItemCardapio item : cardapio) {
            System.out.println("Nome: " + item.nome + ", Código: " + item.codigo + ", Preço: R$" + item.preco + ", Disponível: " + item.disponibilidade);
        }
    }

    private void cadastrarMesa(Scanner scanner) {
        System.out.print("Digite o número da mesa: ");
        int numeroMesa = scanner.nextInt();
        System.out.print("Digite a capacidade da mesa: ");
        int capacidade = scanner.nextInt();
        Mesa mesa = new Mesa(numeroMesa, capacidade);
        mesas.add(mesa);
        System.out.println("Mesa cadastrada com sucesso.");
    }

    private void registrarPedido(Scanner scanner) {
        System.out.print("Digite o número da mesa: ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        Mesa mesa = null;
        for (Mesa m : mesas) {
            if (m.numeroMesa == numeroMesa) {
                mesa = m;
                break;
            }
        }
        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }
        if (mesa.status.equals("Ocupada")) {
            System.out.println("Mesa já está ocupada.");
            return;
        }
        System.out.print("Digite o ID do garçom: ");
        int idGarcom = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        Funcionario garcom = null;
        for (Funcionario f : funcionarios) {
            if (f.id == idGarcom && f.cargo.equalsIgnoreCase("Garçom")) {
                garcom = f;
                break;
            }
        }
        if (garcom == null) {
            System.out.println("Garçom não encontrado.");
            return;
        }
        Pedido pedido = new Pedido(numeroMesa, garcom);
        boolean adicionandoItens = true;
        while (adicionandoItens) {
            System.out.print("Digite o código do item a adicionar (ou -1 para finalizar): ");
            int codigoItem = scanner.nextInt();
            if (codigoItem == -1) {
                adicionandoItens = false;
                break;
            }
            ItemCardapio item = null;
            for (ItemCardapio i : cardapio) {
                if (i.codigo == codigoItem) {
                    item = i;
                    break;
                }
            }
            if (item == null) {
                System.out.println("Item não encontrado.");
            } else if (!item.disponibilidade) {
                System.out.println("Item indisponível.");
            } else {
                pedido.adicionarItem(item);
                System.out.println("Item adicionado ao pedido.");
            }
        }
        pedidos.add(pedido);
        mesa.status = "Ocupada";
        System.out.println("Pedido registrado com sucesso.");
    }

    private void fecharConta(Scanner scanner) {
        System.out.print("Digite o número da mesa: ");
        int numeroMesa = scanner.nextInt();
        Pedido pedidoFechar = null;
        for (Pedido p : pedidos) {
            if (p.numeroMesa == numeroMesa && !p.fechado) {
                pedidoFechar = p;
                break;
            }
        }
        if (pedidoFechar == null) {
            System.out.println("Não há pedidos abertos para esta mesa.");
            return;
        }
        System.out.println("Valor total: R$" + pedidoFechar.valorTotal);
        System.out.print("Digite o valor pago: ");
        String valorPagoStr = scanner.next().replace('.', ',');
        double valorPago = Double.parseDouble(valorPagoStr);
        if (valorPago >= pedidoFechar.valorTotal) {
            double troco = valorPago - pedidoFechar.valorTotal;
            System.out.println("Pagamento realizado com sucesso. Troco: R$" + troco);
            pedidoFechar.fechado = true;
            faturamentoDiario += pedidoFechar.valorTotal;
            pedidoFechar.garcom.totalPedidos++;
            pedidoFechar.garcom.totalVendas += pedidoFechar.valorTotal;
            // Liberar a mesa
            for (Mesa m : mesas) {
                if (m.numeroMesa == numeroMesa) {
                    m.status = "Disponível";
                    break;
                }
            }
            System.out.println("Mesa liberada.");
        } else {
            System.out.println("Valor insuficiente. Operação cancelada.");
        }
    }

    private void relatorioVendasPorFuncionario() {
        System.out.println("=== Relatório de Vendas por Funcionário ===");
        for (Funcionario f : funcionarios) {
            if (f.cargo.equalsIgnoreCase("Garçom")) {
                System.out.println("Nome: " + f.nome + ", Total de Pedidos: " + f.totalPedidos + ", Total Vendido: R$" + f.totalVendas);
            }
        }
    }

    private void relatorioFaturamentoDiario() {
        System.out.println("=== Relatório de Faturamento Diário ===");
        System.out.println("Total de Vendas: R$" + faturamentoDiario);

        System.out.println("--- Vendas por Mesa ---");
        for (Mesa m : mesas) {
            double vendasMesa = 0.0;
            for (Pedido p : pedidos) {
                if (p.numeroMesa == m.numeroMesa && p.fechado) {
                    vendasMesa += p.valorTotal;
                }
            }
            System.out.println("Mesa " + m.numeroMesa + ": R$" + vendasMesa);
        }

        System.out.println("--- Vendas por Funcionário ---");
        for (Funcionario f : funcionarios) {
            if (f.cargo.equalsIgnoreCase("Garçom")) {
                System.out.println("Nome: " + f.nome + ", Total Vendido: R$" + f.totalVendas);
            }
        }
    }
}
