package principal;

import modelos.MonedaRecord;
import servicio.ConsultaApi;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        int opcion = 0;

        String menu = """
                ****************************************
                                Bienvenido/a al Conversor de Monedas
                
                                1) Dólar (USD) a Peso Argentino (ARS)
                                2) Peso Argentino (ARS) a Dólar (USD)
                                3) Dólar (USD) a Real Brasileño (BRL)
                                4) Real Brasileño (BRL) a Dólar (USD)
                                5) Dólar (USD) a Peso Colombiano (COP)
                                6) Peso Colombiano (COP) a Dólar (USD)
                                7) Salir
                
                                Seleccione una opción:
                                ****************************************""";

        while (opcion != 7) {
            System.out.println(menu);

            try {
                opcion = Integer.valueOf(teclado.nextLine());

                if (opcion < 1 || opcion > 7) {
                    System.out.println("Opción no válida. Por favor ingrese un número del 1 al 7.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada inválida. Ingrese solo el número de la opción.");
                continue;
            }

            if (opcion == 7) {
                System.out.println("¡Gracias por usar el Conversor de Monedas! Finalizando ...");
                break;
            }

            String monedaBase = "";
            String monedaTarget = "";

            switch (opcion) {
                case 1: monedaBase = "USD"; monedaTarget = "ARS"; break;
                case 2: monedaBase = "ARS"; monedaTarget = "USD"; break;
                case 3: monedaBase = "USD"; monedaTarget = "BRL"; break;
                case 4: monedaBase = "BRL"; monedaTarget = "USD"; break;
                case 5: monedaBase = "USD"; monedaTarget = "COP"; break;
                case 6: monedaBase = "COP"; monedaTarget = "USD"; break;
            }

            System.out.println("\nIngrese la cantidad que desea convertir:");
            double cantidad = 0;
            try {
                cantidad = Double.valueOf(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Cantidad inválida. Ingrese solo números.");
                continue;
            }

            MonedaRecord datosTasa = consulta.buscarTasas(monedaBase);

            if (datosTasa.conversion_rates().containsKey(monedaTarget)) {
                double tasa = datosTasa.conversion_rates().get(monedaTarget);
                double resultado = cantidad * tasa;

                System.out.printf("\n========================================\n");
                System.out.printf("El valor de %.2f [%s] corresponde al valor final de %.2f [%s]%n", cantidad, monedaBase, resultado, monedaTarget);
                System.out.printf("========================================\n");
            } else {
                System.err.println("\nNo se pudo realizar la consulta. Verifique la clave API o la conexión.");
            }

            System.out.println("\nPresione Enter para continuar al menú...");
            teclado.nextLine();
        }

        teclado.close();

    }
}
