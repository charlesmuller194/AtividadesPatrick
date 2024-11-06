import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Historico {
    Veiculo veiculo;
    private Duration tempoPermanencia;
    private double valorPago;

    public Historico(Veiculo veiculo, Duration tempoPermanencia, double valorPago) {
        this.veiculo = veiculo;
        this.tempoPermanencia = tempoPermanencia;
        this.valorPago = valorPago;
    }

    public void exibirHistorico() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Hora de Entrada: " + veiculo.getHoraEntrada().format(formatter));
        System.out.println("Hora de Saída: " + veiculo.getHoraSaida().format(formatter));
        System.out.println("Tempo de Permanência: " + tempoPermanencia.toHoursPart() + " horas e " + tempoPermanencia.toMinutesPart() + " minutos");
        System.out.println("Valor Pago: R$ " + valorPago);
        System.out.println("-------------------------------------");
    }
}