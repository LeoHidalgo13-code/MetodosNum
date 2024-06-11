import java.util.Scanner;

public class MetodoSecante {
    static double xu, xl;
    static float el;
    static double PI = Math.acos(-1.0);

    static double evaluar(double x) {
        return Math.sin(x) + x + 2;
    }

    static void algoritmo(double e0, int i) {
        double fu, fl, fr, xr, e;
        fu = evaluar(xu);
        fl = evaluar(xl);
        xr = xu - ((fu * (xl - xu)) / (fl - fu));
        fr = evaluar(xr);

        e = Math.abs(((xr - e0) / xr)) * 100;
        System.out.printf("    %d      %.10f      %.10f      %.10f      %.10f      %.10f      %.10f      %.10f\n",
                i, xl, xu, xr, fl, fu, fr, e);

        if (fr * fl > 0)
            xl = xr;
        else
            xu = xr;

        if (e < el) {
            System.out.println("Finaliza");
            return;
        } else {
            e0 = xr;
            algoritmo(e0, ++i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer punto:");
        xl = scanner.nextDouble();
        System.out.println("Ingrese el segundo punto:");
        xu = scanner.nextDouble();
        System.out.println("Ingrese el error mínimo:");
        el = scanner.nextFloat();

        System.out.println("Iteración      Xl                   Xu                Xr                 F(Xl)              F(Xu)              F(Xr)               Error");
        algoritmo(0, 1);

        scanner.close();
    }
}
