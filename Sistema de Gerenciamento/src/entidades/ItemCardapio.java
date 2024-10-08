package entidades;

// Classe ItemCardapio
public class ItemCardapio {
    public String nome;
    public int codigo;
    public double preco;
    public boolean disponibilidade; // true se disponível, false se esgotado

    public ItemCardapio(String nome, int codigo, double preco, boolean disponibilidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }
}
