package main.strategy;


public class Pedido {
    private double valor;
    private Descontos estrategia;

    public Pedido( double valor , Descontos estrategia) {
        this.valor = valor;
        this.estrategia = estrategia;
    }

    public void setEstrategia(Descontos estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularTotal() {
        return estrategia.calcular(this.valor);
    }
}
