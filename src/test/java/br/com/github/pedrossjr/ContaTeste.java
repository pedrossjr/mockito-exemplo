package br.com.github.pedrossjr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/* Espiando Objetos */
@ExtendWith(MockitoExtension.class)
public class ContaTeste {

    @Spy
    private Conta conta = new Conta(1000);

    @Test
    void vaidarordemDeChamadas1() {

        conta.pagaBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);
        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviaCreditoParaEmissor(300);
    }

    @Test
    void vaidarordemDeChamadas2() {

        conta.pagaBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);
        inOrder.verify(conta).pagaBoleto(ArgumentMatchers.anyInt());
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviaCreditoParaEmissor(300);
    }

    @Test
    void validarQuantidadeDeChamadas(){
        conta.validaSaldo(300);
        conta.validaSaldo(500);
        conta.validaSaldo(600);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
    }

    /* Manipulando retornos */
    @Test
    void retornarTureParaQualquerValorNaValidacaoDeSaldo() {
        Mockito.doNothing().when(conta).validaSaldo(ArgumentMatchers.anyInt());
        conta.validaSaldo(3500);

    }
}
