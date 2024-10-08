package entidades;

// Classe Mesa
public class Mesa {
    public int numeroMesa;
    public int capacidade;
    public String status; // "Ocupada" ou "Disponível"

    public Mesa(int numeroMesa, int capacidade) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.status = "Disponível";
    }
}
