package Principal;
import Modelos.ConvertirMonedas;
import java.io.IOException;
public class Principal {
    public static void main(String[] args) throws IOException{
        ConvertirMonedas convertidor = new ConvertirMonedas();
        convertidor.iniciar();
    }
}
