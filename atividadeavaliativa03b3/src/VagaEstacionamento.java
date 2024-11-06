public class VagaEstacionamento {
    private int numeroVaga;
    private String tamanho; // pequeno, médio, grande
    private boolean disponivel;
    private Veiculo veiculoEstacionado;

    public VagaEstacionamento(int numeroVaga, String tamanho) {
        this.numeroVaga = numeroVaga;
        this.tamanho = tamanho.toLowerCase();
        this.disponivel = true;
    }

    // Getters e setters
    public int getNumeroVaga() {
        return numeroVaga;
    }

    public String getTamanho() {
        return tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Veiculo getVeiculoEstacionado() {
        return veiculoEstacionado;
    }

    public void setVeiculoEstacionado(Veiculo veiculoEstacionado) {
        this.veiculoEstacionado = veiculoEstacionado;
    }
}
