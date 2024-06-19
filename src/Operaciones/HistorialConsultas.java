package Operaciones;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class HistorialConsultas {
    public static String NOMBRE_ARCHIVO = "Historial_Consultas.txt";
    public static void registrarConversion(String precio, String s, double cantidad, double resultado) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))){
            String tiempoActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String registro = String.format("Current Time: %s: %.2f %s equivale a: %.2f\n", tiempoActual, cantidad, precio, resultado, cantidad);
            writer.write(registro);
        }catch(IOException e ){
            System.out.println("Error al escribir en el archivo " + e.getMessage());
        }
    }
    public static void mostrarHistorial(){
        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            if(lineas.isEmpty()){
                System.out.println("El historial esta vacío");
            }else{
                System.out.println("***** Historial de Conversiones *****");
                for(String linea :lineas ){
                    System.out.println(linea);
                }
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }

}

