package Lesson4;
import java.util.Scanner;
public class Triangle {

    public static boolean isTriangle(double a, double b, double c) {
        return ((a + b > c) && (b + c > a) && (c + a > b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        if (isTriangle(a,b,c)){
            double p = (a + b + c) / 2;
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println(s);
        } else {
            System.out.println("Это не треугольник!");
        }
    }


}


