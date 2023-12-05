package com.br.cep.api;

import com.br.cep.exception.CepConversionException;
import com.br.cep.modelo.Endereco;
import com.br.cep.modelo.EnderecoDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepConnection {

    public void buildAndSendCepRequest(String cep) throws IOException, InterruptedException {
        String cepNumber = putCep(cep);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(cepNumber))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            deserializeResponseJson(response);

//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        } catch (CepConversionException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void deserializeResponseJson(HttpResponse<String> response) throws IOException {
        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        EnderecoDto enderecoDto = gson.fromJson(json, EnderecoDto.class);
        System.out.println(enderecoDto);

        Endereco endereco = new Endereco(enderecoDto);
        System.out.println(endereco);

        writeFile(json);
    }

    private String putCep(String cepApi) {
        final String url = CepApi.putCepNumber(cepApi);
        return url;
    }

    private static void writeFile(String input) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter writer = new FileWriter("endereços.json");
        writer.write(gson.toJson(input));
        writer.close();
    }
}
