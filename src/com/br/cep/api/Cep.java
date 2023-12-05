package com.br.cep.api;

import java.io.IOException;
import java.util.Scanner;

public class Cep {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner search = new Scanner(System.in);
        System.out.println("Digite um cep: ");
        String cep = search.nextLine();
        CepConnection cepConnection = new CepConnection();
        cepConnection.buildAndSendCepRequest(cep);
    }
}
