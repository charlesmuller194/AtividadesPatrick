import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<VagaEstacionamento> vagas;
    private List<Historico> historicos;

    public Estacionamento() {
        vagas = new ArrayList<>();
        historicos = new ArrayList<>();
    }

    // Métodos para gerenciar vagas
    public void adicionarVaga(VagaEstacionamento vaga) {
        vagas.add(vaga);
    }

    public VagaEstacionamento encontrarVagaDisponivel(String tamanho) {
        for (VagaEstacionamento vaga : vagas) {
            if (vaga.isDisponivel() && tamanhoCompatível(tamanho, vaga.getTamanho())) {
                return vaga;
            }
        }
        return null;
    }

    private boolean tamanhoCompatível(String tamanhoVeiculo, String tamanhoVaga) {
        List<String> tamanhos = List.of("pequeno", "médio", "grande");
        int indiceVeiculo = tamanhos.indexOf(tamanhoVeiculo);
        int indiceVaga = tamanhos.indexOf(tamanhoVaga);
        return indiceVeiculo <= indiceVaga;
    }

    // Métodos de check-in e check-out
    public boolean registrarEntrada(Veiculo veiculo) {
        VagaEstacionamento vaga = encontrarVagaDisponivel(veiculo.getTamanho());
        if (vaga != null) {
            vaga.setDisponivel(false);
            vaga.setVeiculoEstacionado(veiculo);
            veiculo.setHoraEntrada(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public double registrarSaida(String placa) {
        for (VagaEstacionamento vaga : vagas) {
            Veiculo veiculo = vaga.getVeiculoEstacionado();
            if (veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculo.setHoraSaida(LocalDateTime.now());
                Duration duracao = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida());
                double valor = calcularValor(duracao);
                vaga.setDisponivel(true);
                vaga.setVeiculoEstacionado(null);
                historicos.add(new Historico(veiculo, duracao, valor));
                return valor;
            }
        }
        return -1; // Veículo não encontrado
    }

    private double calcularValor(Duration duracao) {
        long minutos = duracao.toMinutes();
        if (minutos <= 60) {
            return 5.0;
        } else if (minutos <= 180) {
            return 10.0;
        } else {
            return 15.0;
        }
    }

    // Relatórios
    public void exibirVagasOcupadas() {
        System.out.println("Vagas Ocupadas no Momento:");
        for (VagaEstacionamento vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga Número: " + vaga.getNumeroVaga());
                System.out.println("Tamanho da Vaga: " + vaga.getTamanho());
                System.out.println("Placa do Veículo: " + vaga.getVeiculoEstacionado().getPlaca());
                System.out.println("-------------------------------------");
            }
        }
    }

    public void exibirHistoricoVeiculo(String placa) {
        System.out.println("Histórico do Veículo - Placa: " + placa);
        for (Historico hist : historicos) {
            if (hist.veiculo.getPlaca().equalsIgnoreCase(placa)) {
                hist.exibirHistorico();
            }
        }
    }
}
