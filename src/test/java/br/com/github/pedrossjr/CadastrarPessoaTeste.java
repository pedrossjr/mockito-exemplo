package br.com.github.pedrossjr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RJ", "Mage", "Estrada Municipal Antonio Alem Bergara 959", "Casa 240", "Piabeta");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("25931890")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Pedro", "128587300", LocalDate.now(), "25931890");

        assertEquals("Pedro", pessoa.getNome());
        assertEquals("128587300", pessoa.getDocumentos());
        assertEquals("RJ", pessoa.getEndereco().getUf());
        assertEquals("Casa 240", pessoa.getEndereco().getComplemento());
    }

    @Test
    void cadastrarPessoa() {

        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta");

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(null);

        Pessoa jose = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");

        assertNull(jose.getEndereco());
    }

    @Test
    void lancarExceptionQuandoChamarApiCorreios1() {

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> cadastrarPessoa.cadastrarPessoa("Pedro", "128587300", LocalDate.of(1947,1, 15), "25931890")
        );
    }

    /* Manipulando retornos */
    @Test
    void lancarExceptionQuandoChamarApiCorreios2() {

        Mockito.doThrow(IllegalArgumentException.class)
            .when(apiDosCorreios)
            .buscaDadosComBaseNoCep(anyString());

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> cadastrarPessoa.cadastrarPessoa("Pedro", "128587300", LocalDate.of(1947,1, 15), "25931890")
        );
    }
}