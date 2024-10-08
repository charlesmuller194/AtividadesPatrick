package entidades;

import java.util.ArrayList;
import java.util.List;

// Classe Pedido
public class Pedido {
    public int numeroMesa;
    public Funcionario garcom;
    public List<ItemCardapio> itens;
    public double valorTotal;
    public boolean fechado;

    public Pedido(int numeroMesa, Funcionario garcom) {
        this.numeroMesa = numeroMesa;
        this.garcom = garcom;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.fechado = false;
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
        valorTotal += item.preco;
    }
}
