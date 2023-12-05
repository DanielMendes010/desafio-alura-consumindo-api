package com.br.cep.modelo;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String estado;

    public Endereco(String cep, String logradouro, String complemento, String bairro, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Endereco(EnderecoDto enderecoDto) {
        this.cep = enderecoDto.cep();
        this.logradouro = enderecoDto.logradouro();
        this.complemento = enderecoDto.complemento();
        this.bairro = enderecoDto.bairro();
        this.estado = enderecoDto.localidade();

    }

    @Override
    public String toString() {
        return "cep : " + cep
                + "\nlogradouro : " + logradouro
                + "\ncomplemento : " + complemento
                + "\nbairro : " + bairro
                + "\nestado : " + estado;
    }
}
