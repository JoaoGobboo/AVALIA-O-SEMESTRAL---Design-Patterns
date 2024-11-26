package clientes;

public class Encomenda {
    private double peso;
    private double dimensao;

    public Encomenda(double peso, double dimensao) {
        this.peso = peso;
        this.dimensao = dimensao;
    }

    public double getPeso() {
        return peso;
    }

    public double getDimensao() {
        return dimensao;
    }
}
