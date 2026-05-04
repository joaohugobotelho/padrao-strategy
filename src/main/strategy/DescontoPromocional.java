package main.strategy;

public class DescontoPromocional implements Descontos{
    @Override
    public double calcular( double valorTotal) {
        return( valorTotal > 30.0) ? valorTotal - 5.0 : valorTotal;
    }
}
