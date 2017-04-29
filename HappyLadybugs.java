import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean containsDup(String b)
    {
        int[] arr = new int[26];
        for(int i = 0; i < b.length(); i++)
        {
            char a = b.charAt(i);
            if(a != '_')
            {
                arr[(int)a - 65]++;
            }
        }
        for(int i = 0; i < 26; i++)
        {
            if(arr[i] == 1)
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean containsSpace(String b)
    {
        for(int i = 0; i < b.length(); i++)
        {
            if(b.charAt(i) == '_')
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isHappy(String b)
    {
        if(b.equals("_")) return true;
        else if(b.length() == 1) return false;
        else
        {
            if(b.charAt(0) != b.charAt(1))
            {
                return false;
            }
            if(b.charAt(b.length() - 1) != b.charAt(b.length() - 2))
            {
                return false;
            }
            for(int i = 1; i < b.length() - 1; i++)
            {
                if((b.charAt(i) != b.charAt(i - 1)) && 
                   (b.charAt(i) != b.charAt(i + 1)))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            if(isHappy(b))
            {
                System.out.println("YES");
            }
            else if(!containsSpace(b))
            {
                System.out.println("NO");
            }
            else
            {
                if(containsDup(b))
                {
                    System.out.println("YES");
                }
                else
                {
                    System.out.println("NO");
                }
            }
        }
    }
}
