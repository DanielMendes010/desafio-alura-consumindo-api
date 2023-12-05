package com.br.cep.modelo;

public record EnderecoDto(String cep, String logradouro, String complemento,
                          String bairro, String localidade) {
}
