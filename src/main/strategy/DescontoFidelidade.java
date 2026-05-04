package main.strategy;

public class DescontoFidelidade implements Descontos {
    @Override
    public double calcular(double valorTotal) {
        return valorTotal * 0.90;
    }
}
