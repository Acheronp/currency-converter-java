package com.currencyconverter.main;

import java.util.Map;
import java.util.Scanner;

import com.currencyconverter.services.APIQuery;
import com.currencyconverter.services.Converter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        APIQuery request = new APIQuery();
        Converter converter = new Converter();
        String message = """
                *****************************************************
                ⡎⠑ ⡇⢸ ⣏⡱ ⣏⡱ ⣏⡉ ⡷⣸ ⡎⠑ ⢇⢸   ⡎⠑ ⡎⢱ ⡷⣸ ⡇⢸ ⣏⡉ ⣏⡱ ⢹⠁ ⣏⡉ ⣏⡱
                ⠣⠔ ⠣⠜ ⠇⠱ ⠇⠱ ⠧⠤ ⠇⠹ ⠣⠔  ⠇   ⠣⠔ ⠣⠜ ⠇⠹ ⠸⠃ ⠧⠤ ⠇⠱ ⠸  ⠧⠤ ⠇⠱
                *****************************************************

                1.  Dólar            ==> Peso colombiano
                2.  Dólar            ==> Real brasileño
                3.  Dólar            ==> Soles
                4.  Dolar            ==> Peso chileno
                5.  Peso colombiano  ==> Dólar
                6.  Real brasileño   ==> Dólar
                7.  Soles            ==> Dólar
                8.  Peso chileno     ==> Dolar
                9.  Salir

                Elija una opción válida:
                *****************************************************
                """;

        Map<Integer, String[]> options = Map.of(
                1, new String[] { "USD", "COP" },
                2, new String[] { "USD", "BRL" },
                3, new String[] { "USD", "PEN" },
                4, new String[] { "USD", "CLP" },
                5, new String[] { "COP", "USD" },
                6, new String[] { "BRL", "USD" },
                7, new String[] { "PEN", "USD" },
                8, new String[] { "CLP", "USD" });

        while (true) {
            try {

                System.out.println(message);

                if (!scanner.hasNextInt()) {
                    System.out.println("Error: Por favor, ingrese un número entero.");
                    scanner.nextLine();
                    continue;
                }

                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 9) {
                    break;
                }
                if (!options.containsKey(option)) {
                    System.out.println("Opción no válida, intente de nuevo.");
                    continue;
                }

                System.out.println("Ingrese el valor que desea convertir: ");

                if (!scanner.hasNextDouble()) {
                    System.out.println("Error: El valor debe ser un número.");
                    scanner.nextLine();
                    continue;
                }

                Double amount = scanner.nextDouble();
                scanner.nextLine();

                String[] currencies = options.get(option);
                String baseCurrency = currencies[0];
                String targetCurrency = currencies[1];

                double finalAmount = converter.convert(amount, targetCurrency,
                        request.fetchExchangeRates(baseCurrency));

                System.out.printf("El valor %.2f [%s] corresponde al valor de %.2f [%s]%n \n",
                        amount,
                        baseCurrency,
                        finalAmount,
                        targetCurrency);
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}