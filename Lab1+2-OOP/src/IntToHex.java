//Lab1 - exc5

import java.util.Scanner;

public class IntToHex
{
    public static void main(String[] args)
    {
        String res = "";
        int num,reminder;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number to convert to hex:");
        num = input.nextInt();
        char Hex[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(num > 0)
        {
            reminder = num % 16;
            res = Hex[reminder] + res;
            num /= 16;
        }
        if(res.charAt(0)>='A' && res.charAt(0)<='F')
            res = "0" + res;
        System.out.println("Result: " + res+"h");
    }

}
