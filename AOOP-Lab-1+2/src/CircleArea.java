//Lab1 - exc1
import java.util.Scanner;
import static java.lang.Math.pow;

public class CircleArea
{
    public static void main(String[] args)
    {
        double radius, area;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter circle radius: ");
        radius = input.nextDouble();
        double pi = 3.14159;
        area = pi*pow(radius,2);
        System.out.println("Circle's area: " + area);
    }

}
