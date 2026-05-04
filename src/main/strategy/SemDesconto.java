package main.strategy;
public class SemDesconto implements Descontos{
    @Override
    public double calcular(double valorTotal) {
        return valorTotal;
    }
}
