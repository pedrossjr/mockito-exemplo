package br.com.github.pedrossjr;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/*
* Segunda opção
* */

public class CadastrarPessoaTeste2 {

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private ApiDosCorreios apiDosCorreios = Mockito.mock(ApiDosCorreios.class);
}
