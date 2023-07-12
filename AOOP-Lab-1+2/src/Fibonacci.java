//Lab1 - exc2

import java.util.Scanner;

public class Fibonacci
{
    static int Fib(int N)
    {
        if(N <= 1)
            return N;

        return Fib(N-1) + Fib(N-2);
    }

    public static void main(String[] args)
    {
        System.out.println("Enter N for Fib series:");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for(int i=1;i<=N;i++)
        {
            System.out.print(Fib(i));
            if(i+1 <= N)
                System.out.print(",");
        }
    }
}
