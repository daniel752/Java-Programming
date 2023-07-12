//Lab1 - exc4

public class PrimeNumbers
{
    public static void main(String[] args)
    {
        for(int i=2;i<=200;i++)
        {
            for(int j=2;j<=i;j++)
            {
                if (j + 1 == i || i == 2)
                {
                    System.out.print(i + ",");
                    break;
                }
                if (i % j == 0)
                    break;
            }
        }
        System.out.println("\b");
    }
}
