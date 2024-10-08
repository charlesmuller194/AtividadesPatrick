package entidades;

// Classe Funcionario
public class Funcionario {
    public String nome;
    public int id;
    public String cargo; // Garçom, Cozinheiro, Gerente
    public int totalPedidos; // Total de pedidos realizados (para garçons)
    public double totalVendas; // Valor total vendido (para garçons)

    public Funcionario(String nome, int id, String cargo) {
        this.nome = nome;
        this.id = id;
        this.cargo = cargo;
        this.totalPedidos = 0;
        this.totalVendas = 0.0;
    }
}