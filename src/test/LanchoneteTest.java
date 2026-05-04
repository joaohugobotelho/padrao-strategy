package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import main.strategy.Pedido;
import main.strategy.DescontoFidelidade;
import main.strategy.SemDesconto;
import main.strategy.DescontoPromocional;
public class LanchoneteTest {

    @Test
    public void testSemDesconto() {
        Pedido pedido = new Pedido(50.0, new SemDesconto()); // nao aplica desconto no pedido
        assertEquals(50.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void testDescontoFidelidade() {
        // 10% de 100 deve retornar 90
        Pedido pedido = new Pedido(100.0, new DescontoFidelidade());
        assertEquals(90.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void testDescontoPromocionalValido() {
        // Acima de 30 reais, desconta 5 reais
        Pedido pedido = new Pedido(40.0, new DescontoPromocional());
        assertEquals(35.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void testDescontoPromocionalAbaixoDoLimite() {
        // 20 reais não deve ganhar desconto
        Pedido pedido = new Pedido(20.0, new DescontoPromocional());
        assertEquals(20.0, pedido.calcularTotal(), 0.001);
    }
    
    @Test
    public void testTrocaDeEstrategiaDinamica() {
        Pedido pedido = new Pedido(100.0, new SemDesconto());
        assertEquals(100.0, pedido.calcularTotal());

        // troca a estrategia aplicando um desconto promocional
        pedido.setEstrategia(new DescontoFidelidade());
        assertEquals(90.0, pedido.calcularTotal());
    }
}