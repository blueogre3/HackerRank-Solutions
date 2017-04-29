import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String num = in.next();
        StringBuilder number = new StringBuilder(num);
        String track = "";
        for (int i = 0; i < (n + 1)/2; i++)
        {
           if(number.charAt(i) != number.charAt(n - i - 1))
           {
               if(number.charAt(i) > number.charAt(n - i - 1))
               {
                   number.setCharAt(n - i - 1, number.charAt(i));
               }
               else
               {
                   number.setCharAt(i, number.charAt(n - i - 1));
               }
               track += "1";
               k--;
           }
           else
           {
               track += "0";
           }
        }
        if(k < 0)
        {
            System.out.print(-1);
        }
        else if (k == 0)
        {
            System.out.print(number);
        }
        else if (k > 0)
        {
            int index = 0;
            while (k > 0 && index < (n+1)/2)
            {
                if(number.charAt(index) != '9')
                {
                    if(track.charAt(index) == '1')
                    {
                        number.setCharAt(index, '9');
                        number.setCharAt(n - index - 1, '9');
                        k -= 1;
                    }
                    else if(k >= 2)
                    {
                        number.setCharAt(index, '9');
                        number.setCharAt(n - index - 1, '9');
                        k -= 2;
                    }
                }
                index++;
            }
            if(k > 0)
            {
                number.setCharAt((n+1)/2 - 1, '9');
            }
            System.out.print(number);
        }
        
    }
}
