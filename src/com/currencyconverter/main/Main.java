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
                9.  Exit

                Choose a valid option:
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
                    System.out.println("Please enter an integer.");
                    scanner.nextLine();
                    continue;
                }

                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 9) {
                    break;
                }
                if (!options.containsKey(option)) {
                    System.out.println("Invalid option, please try again.");
                    continue;
                }

                System.out.println("Enter the value you want to convert: ");

                if (!scanner.hasNextDouble()) {
                    System.out.println("The value must be a number.");
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

                System.out.printf("The value %.2f [%s] corresponds to the value of %.2f [%s]%n \n",
                        amount,
                        baseCurrency,
                        finalAmount,
                        targetCurrency);
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}