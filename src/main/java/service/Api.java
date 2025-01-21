package service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    public void searchApi(int opcao1, int opcao2, double valor) throws IOException, InterruptedException {

        String apiKey = "d1c37f276903b7400a52019b";
        String moeda1 = "";
        String moeda2 = "";


        switch (opcao1) {
            case 1:
                moeda1 = "BRL";

                break;
            case 2:
                moeda1 = "USD";

                break;
            case 3:
                moeda1 = "EUR";

                break;
            case 4:
                moeda1 = "GBP";
                break;
            case 5:
                moeda1 = "JPY";
                break;
            case 6:
                moeda1 = "AUD";
                break;
            case 7:
                moeda1 = "TWD";
                break;

        }

        switch (opcao2) {
            case 1:
                moeda2 = "BRL";

                break;
            case 2:
                moeda2 = "USD";

                break;
            case 3:
                moeda2 = "EUR";

                break;
            case 4:
                moeda2 = "GBP";
                break;
            case 5:
                moeda2 = "JPY";
                break;
            case 6:
                moeda2 = "AUD";
                break;
            case 7:
                moeda2 = "TWD";
                break;
        }

        String apiAddress = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moeda1 + "/" + moeda2;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiAddress)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            String moedaBase = jsonObject.get("base_code").getAsString();
            String moedaFinal = jsonObject.get("target_code").getAsString();
            double taxaConversao = jsonObject.get("conversion_rate").getAsDouble();

            double valorConvertido = valor * taxaConversao;
            double resultado = Math.round(valorConvertido * 100.0) / 100.0;

            System.out.println("Convertido de " + moedaBase);
            System.out.println("Para " + moedaFinal);
            System.out.println("Taxa de conversão: " + taxaConversao);

            System.out.println("Resultado da conversão: " + resultado);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
