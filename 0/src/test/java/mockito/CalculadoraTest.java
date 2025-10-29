package test.java.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class CalculadoraTest {

    @Mock
    private ServicoMatematico servicoMatematico = mock(ServicoMatematico.class);

    public CalculadoraTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void somaTest(){
        when(servicoMatematico.somar(2,3)).thenReturn(5);

        Calculadora calculadora = new Calculadora(servicoMatematico);
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
        verify(servicoMatematico).somar(2,3);
    }
}