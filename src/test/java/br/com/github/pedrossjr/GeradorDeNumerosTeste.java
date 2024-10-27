package br.com.github.pedrossjr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GeradorDeNumerosTeste {

    @Test
    void testaGeracaoComNumeroDefinido() {

        MockedStatic<GeradorDeNumeros> mokedStatic = Mockito.mockStatic(GeradorDeNumeros.class);
    }
}
