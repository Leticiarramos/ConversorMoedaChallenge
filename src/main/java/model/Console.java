package model;
import exception.InvalidCommandException;
import service.Api;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    Api api = new Api();
    private int opcao1;
    private int opcao2;
    private double valor;

    public int getOpcao1() {
        return opcao1;
    }

    public int getOpcao2() {
        return opcao2;
    }

    public double getValor() {
        return this.valor;
    }

    String text = """
            Bem-vindo(a) ao conversor de moedas! 
            Digite a opção para moeda a ser convertida:
            1 - Real
            2 - Dólar
            3 - Euro
            4 - Libra
            5 - Iene
            6 - Dólar Australiano
            7 - Dólar Taiwanes
            8 - Sair.
            """;

    public void callConsole() throws IOException, InterruptedException {
        while (opcao1 != 8 ) {
            System.out.println(text);
            System.out.println("Digite seu comando: ");
            opcao1 = scanner.nextInt();
            if (opcao1 > 8 || opcao1 <= 0) {
                throw new InvalidCommandException("Comando inválido, reinicie a aplicação.");
            } else if (opcao1 == 8) {
                break;
            }


            System.out.println("""
            Digite o número referente a conversão:
            1 - Real
            2 - Dólar
            3 - Euro
            4 - Libra
            5 - Iene
            6 - Dólar Australiano
            7 - Dólar Taiwanes
            8 - Finalizar.
            """);

            opcao2 = scanner.nextInt();
            if (opcao2 > 8 || opcao2 <= 0) {
                throw new InvalidCommandException("Comando inválido, reinicie a aplicação.");
            } else if (opcao2 == 8) {
                break;
            }

            System.out.println("Digite o valor a ser convertido");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor inválido.");
            } else {
                boolean validation = true;
                api.searchApi(primeiraOpcao(), segundaOpcao(), valorAConverter());

            }

        }

    }

    public int segundaOpcao() {
        return this.opcao2;
    }


    public int primeiraOpcao(){
        return this.opcao1;
    }

    public double valorAConverter(){
        return this.valor;
    }



}
