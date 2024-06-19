package Operaciones;
import java.io.IOException;
public class CalculosOperaciones {
    public void operacionMonedas(Monedas moneda, double cantidad) throws IOException{
        double resultado = cantidad * moneda.conversion_rate();
        System.out.println(String.format("%.2f", cantidad) +
                " " + moneda.base_code() + " son equivalentes a "
                + String.format("%.2f", resultado) + " " + moneda.target_code() );

        HistorialConsultas.registrarConversion(moneda.base_code(), moneda.target_code(), cantidad, resultado);
    }
}
