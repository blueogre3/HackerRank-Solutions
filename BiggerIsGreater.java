import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++)
        {
            String s = in.next();
            int i;
            int flag = 1;
            for(i = s.length() - 1; i >= 1; i--)
            {
                if(s.charAt(i) > s.charAt(i-1))
                {
                    flag = 0;
                    break;
                }
            }
            
            
            if(flag == 1)
            {
               System.out.println("no answer"); 
            }
            else
            {
                char c = 'z';
                int index = -1;
                for(int j = i; j < s.length(); j++)
                {
                    if(s.charAt(j) > s.charAt(i-1) && s.charAt(j) <= c)
                    {
                        c = s.charAt(j);
                        index = j;
                    }
                }
                
                char[] arr = s.toCharArray();
                
                char tmp = arr[i-1];
                arr[i-1] = arr[index];
                arr[index] = tmp;
                s = String.valueOf(arr);
                
                String sub = s.substring(i);
                char[] subarr = sub.toCharArray();
                Arrays.sort(subarr);
                
                for(int w = 0; w < subarr.length; w++)
                {
                    arr[w + i] = subarr[w];
                }
                
                String newstring = String.valueOf(arr);
                
                System.out.println(newstring);
                
                
            }
            
        }
    }
}