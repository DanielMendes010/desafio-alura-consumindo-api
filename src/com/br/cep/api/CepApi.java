package com.br.cep.api;

public class CepApi {
    private final static String CEP_URI = "https://viacep.com.br/ws/%s/json/";

    public static String putCepNumber(String cep){
        return String.format(CEP_URI, cep);
    }

}
