import recursos.MyScanner;
import exceptions.NotCeroException;
import exceptions.RangeNumberException;

public class CalculadoraBasica {
    private static final MyScanner input = new MyScanner();

    public static double pedirNumero(int y) throws RangeNumberException {
        double x = input.pedirNumero("Introduce el número " + y + ": ");
        if (x < 0 || x > 100) {
            throw new RangeNumberException("Introduce un número valido (0-100)");
        }
        return x;
    }

    public static double sumar(double x, double y) {
        return x + y;
    }

    public static double restar(double x, double y) {
        return x - y;
    }

    public static double multiplicar(double x, double y) {
        return x * y;
    }

    public static double dividir(double x, double y) throws NotCeroException {
        if (x == 0 || y == 0) {
            throw new NotCeroException("No se puede dividir por 0");
        }
        return x / y;
    }

    public static void main(String[] args) {
        double x = 0;
        double y = 0;
        boolean bucle = true;
        System.out.printf("=== CALCULADORA BÁSICA ===%n");
        while (bucle) {
            try {
                x+=pedirNumero(1);
                y+=pedirNumero(2);

                try {
                    System.out.printf("===== RESUMEN =====%nNúmero 1: %s%nNúmero 2: %s%nSuma: %s%nResta: %s%nMultiplicación: %s%nDivisión: %s%n", x, y, sumar(x, y), restar(x, y), multiplicar(x, y), dividir(x, y));
                    bucle = false;
                } catch (NotCeroException e) {
                    System.out.printf("===== RESUMEN =====%nNúmero 1: %s%nNúmero 2: %s%nSuma: %s%nResta: %s%nMultiplicación: %s%nDivisión: %s%n", x, y, sumar(x, y), restar(x, y), multiplicar(x, y), e.getMessage());
                    bucle = false;
                }
            } catch (RangeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
