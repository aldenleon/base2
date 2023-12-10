import java.util.Scanner;

public class Main {

    private static char numeral(int a) {
        if (a < 10) return (char) ('0' + a);
        if (a > 10+26-1) throw new IllegalArgumentException("base too large");
        return (char) ('A' + a-10);
    }

    private static StringBuilder invChangeBase(int n, int base, StringBuilder ret) {
        if (n / base < base) return ret.append(numeral(n % base)).append(numeral(n / base));
        return invChangeBase(n / base, base, ret.append(numeral(n % base)));
    }

    public static String changeBase(int n, int base) {
        return invChangeBase(n, base, new StringBuilder()).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Introduce un número natural");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(changeBase(n, 2));
    }

}