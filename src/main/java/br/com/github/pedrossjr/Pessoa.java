package br.com.github.pedrossjr;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {

    private String nome;

    private String documentos;

    private LocalDate nascimento;

    private DadosLocalizacao endereco;

    public Pessoa(final String nome, final String documentos, final LocalDate nascimento) {
        this.nome = nome;
        this.documentos = documentos;
        this.nascimento = nascimento;
    }

    public void adicionarDadosDeEndereco( DadosLocalizacao dadosLocalizacao ) {
        this.endereco = dadosLocalizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumentos() {
        return documentos;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public DadosLocalizacao getEndereco() {
        return endereco;
    }
}
