package br.com.github.pedrossjr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

/* Capturando Argumentos */
@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servico;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaPlataforma(){
        String enderecoDeEmail = "usuario@teste.com.br";
        String mensagem = "Olá mundo teste mensagem";
        boolean ehEmailFormatoHtml = true;

        servico.enviaEmail(enderecoDeEmail, mensagem, ehEmailFormatoHtml);

        Mockito.verify(plataforma).enviaEmail(captor.capture());

        Email emailCapturado = captor.getValue();

        Assertions.assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.HTML, emailCapturado.getFormato());
    }
}
