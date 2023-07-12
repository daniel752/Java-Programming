//Lab1 - exc3

import java.util.ArrayList;
import java.util.Scanner;

public class EvenOddSumCount
{
    static ArrayList<Integer> EvenCtr(int num)
    {
        int temp_digit, ctr = 0, temp_num = num;
        ArrayList<Integer> res_arr = new ArrayList<Integer>();
        first:
        while (num > 0)
        {
            second:
            {
                temp_digit = num % 10;
                for (int digit : res_arr)
                    if (temp_digit == digit)
                        break second;
                int j;
                while (temp_num > 0)
                {
                    j = temp_num % 10;
                    if (temp_digit == j)
                        ctr++;
                    temp_num /= 10;
                }
                if (ctr % 2 == 0)
                {
                    res_arr.add(temp_digit);
                }
            }
            ctr = 0;
            num /= 10;
            temp_num = num;
        }
        return res_arr;
    }

    static int OddCtr(int num)
    {
        int temp_digit, ctr = 0, temp_num = num,sum = 0;
        ArrayList<Integer> res_arr = new ArrayList<Integer>();
        first:
        while (num > 0)
        {
            second:
            {
                temp_digit = num % 10;
                for (int digit : res_arr)
                    if (temp_digit == digit)
                        break second;
                int j;
                while (temp_num > 0)
                {
                    j = temp_num % 10;
                    if (temp_digit == j)
                        ctr++;
                    temp_num /= 10;
                }
                if (ctr % 2 == 1)
                    sum += temp_digit;

                res_arr.add(temp_digit);
            }
            ctr = 0;
            num /= 10;
            temp_num = num;
        }
    return sum;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number:");
        int num = input.nextInt();
        System.out.println("Digits that repeat an even number of times:");
        for(int i : EvenCtr(num))
            System.out.print(i+",");
        System.out.println("\b\nSum of digits that repeat an odd number of times:");
        System.out.println(OddCtr(num));
    }
}
