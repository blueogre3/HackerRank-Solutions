import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        String[] words = new String[n];
        
        int[] newarr = new int[n];
        String[] newwords = new String[n];
        
        for(int i = 0; i < n; i++)
        {
            num[i] = in.nextInt();
            words[i] = in.next();
            if(i < n/2)
            {
                words[i] = "-";
            }
        }
        
        int[] arr = new int[100001];
        
        for(int i = 0; i < n; i++)
        {
            int a = num[i];
            arr[a]++;
        }
        
        for(int i = 1; i < arr.length; i++)
        {
            arr[i] += arr[i-1];
        }
        
        for(int j = num.length - 1; j >= 0; j--)
        {
            newarr[arr[num[j]] - 1] = num[j];
            newwords[arr[num[j]] - 1] = words[j];
            arr[num[j]]--;
        }
        
        for(int i = 0; i < n; i++)
        {
            System.out.print(newwords[i] + " ");
        }
        
        
        
        
        
    }
    
}