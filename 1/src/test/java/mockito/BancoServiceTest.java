import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BancoServiceTest {

    @Mock
    ContaRepository contaRepository;

    public BancoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultarSaldo() {
        Conta conta = new Conta("10", 1000);
        when(contaRepository.buscarConta(any())).thenReturn(conta);

        BancoService service = new BancoService(contaRepository);
        double saldo = service.consultarSaldo("10");
        assertEquals(1000, saldo);

        verify(contaRepository).buscarConta("10");
    }


    @Test
    public void testDepositar() {
        Conta conta = new Conta("10", 1000);
        when(contaRepository.buscarConta(any())).thenReturn(conta);

        BancoService service = new BancoService(contaRepository);
        service.depositar("10", 1000);

        assertEquals(2000, conta.getSaldo());

        verify(contaRepository).buscarConta("10");
        verify(contaRepository).salvar(conta);
        verifyNoMoreInteractions(contaRepository);
    }
}