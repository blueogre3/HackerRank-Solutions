import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    
    public static int maxsum(int[] arr)
    {
        int maxendhere = 0;
        int currmax = Integer.MIN_VALUE;
        
        for(int x : arr)
        {
            maxendhere = Math.max(x, x + maxendhere);
            currmax = Math.max(currmax, maxendhere);
        }
        
        return currmax;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = in.nextInt();
            int[] arr = new int[n];
            int allnegative = 1;
            for(int j = 0; j < n; j++)
            {
                arr[j] = in.nextInt();
                if(arr[j] > 0)
                {
                    allnegative = 0;
                }
            }
            
            int sum = 0;
            
            if(allnegative == 0)
            {
                for(int j = 0; j < n; j++)
                {
                    if(arr[j] > 0)
                    {
                        sum += arr[j];
                    }
                }
            
                System.out.println(maxsum(arr) + " " + sum);
            }
            else
            {
                int min = Integer.MIN_VALUE;
                for(int j = 0; j < n; j++)
                {
                    if(min < arr[j])
                    {
                        min = arr[j];
                    }
                }
                sum = min;
                System.out.println(sum + " " + sum);
            }
            
            
            
        }
        
    }
}