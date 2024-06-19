package Modelos;
import Operaciones.ConsultarDivisas;
import Operaciones.HistorialConsultas;
import Operaciones.Monedas;
import Operaciones.CalculosOperaciones;
import java.io.IOException;
import java.util.Scanner;

public class ConvertirMonedas {
    private ConsultarDivisas tipoDeCambio;
    private CalculosOperaciones operaciones;
    public ConvertirMonedas() {
        this.tipoDeCambio = new ConsultarDivisas();
        this.operaciones = new CalculosOperaciones();
    }
    public void iniciar() throws IOException {
        Scanner lectura = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            String opcion = lectura.nextLine();
            if (opcion.equalsIgnoreCase("8")) {
                System.out.println("Cerrando el programa.....");
                break;
            }
            String precio = "";
            String venta = "";
            switch (opcion) {
                case "1":
                    precio = "USD";
                    venta = "MXN";
                    break;
                case "2":
                    precio = "MXN";
                    venta = "USD";
                    break;
                case "3":
                    precio = "BRL";
                    venta = "USD";
                    break;
                case "4":
                    precio = "MXN";
                    venta = "BRL";
                    break;
                case "5":
                    precio = "MXN";
                    venta = "EUR";
                    break;
                case "6":
                    System.out.println("********************************************");
                    System.out.println("No implementado, Esta historia continuará");
                    continue;
                case "7":
                    HistorialConsultas.mostrarHistorial();
                    continue;
                default:
                    System.out.println("Opción inválida, Intente de nuevo.");
                    continue;
            }
            System.out.println("Ingrese el monto de la moneda a convertir:  ");
            Double cantidad = Double.valueOf(lectura.nextLine());
            Monedas moneda = tipoDeCambio.convertirMonedas(precio, venta);
            operaciones.operacionMonedas(moneda,cantidad);
        }
        lectura.close();
    }
    private void mostrarMenu() {
        System.out.println("******************************************************");
        System.out.println("       Bienvenido al Convertidor de Monedas ");
        System.out.println("******************************************************");
        System.out.println("1) Dolar Estadounidense A Peso Mexicano");
        System.out.println("2) Peso Mexicano A Dolar Estadounidense");
        System.out.println("3) Real Brasileño A Dolar Estadounidense");
        System.out.println("4) Peso Mexicano A Real Brasileño");
        System.out.println("5) Peso Méxicano A Euro");
        System.out.println("6) Covertir a otras monedas que no están en la lista");
        System.out.println("7) Ver Historial de Conversiones");
        System.out.println("8) Salir");
        System.out.println("*******************************************************");
        System.out.println("    Selecciona una opción, entre el 1 y el 7: ");

    }
}
