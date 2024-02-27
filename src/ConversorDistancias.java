
public class ConversorDistancias {
	public static double convertirAKilometros(double valor, String unidad) {
        switch (unidad) {
            case "Millas":
                return valor * 0.621371;
            case "Pies":
                return valor * 3280.84;
            case "Pulgadas":
                return valor * 39370.1;
            default:
                return valor;
        }
    }
}
