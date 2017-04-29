import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void partition(int[] arr, int[] arr2, int start, int end)
    {
        if(start >= end)
        {
            return;
        }
        else
        {
            int pivot = arr[end];
            int index = -1;
            for (int i = 0; i < end; i++)
            {
                if(arr[i] <= pivot)
                {
                    index++;
                    int tmp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = tmp;
                    
                    int tmp3 = arr2[i];
                    arr2[i] = arr2[index];
                    arr2[index] = tmp3;
                }
            }
            
            int tmp2 = arr[end];
            arr[end] = arr[index+1];
            arr[index+1] = tmp2;
            
            int tmp4 = arr2[end];
            arr2[end] = arr2[index+1];
            arr2[index+1] = tmp4;
            
            partition(arr, arr2, start, index);
            partition(arr, arr2, index + 2, end);
            
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[100];
        
        
        int[] index = new int[100];
        
        for(int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            arr[a % k]++;
        }
        
        for(int i = 0; i < 100; i++)
        {
            index[i] = i;
        }
        
        partition(arr, index, 0, 99);
        
        for(int i = 0; i < 100; i++)
        {
            if(index[i] == 0)
            {
                if(arr[i] > 0)
                {
                    arr[i] = 1;
                }
            }
            
            if(index[i] * 2 == k)
            {
                if(arr[i] > 0)
                {
                    arr[i] = 1;
                }
            }
            
        }
        
        for(int i = 99; i >= 0; i--)
        {
            int rem1 = index[i];
            if(arr[i] != 0 && rem1 != 0 && rem1 * 2 != k)
            {
                for(int j = 0; j < 100; j++)
                {
                    if(index[j] == k - rem1)
                    {
                        arr[j] = 0;
                        break;
                    }
                }
            }
        }
        
        
        int sum = 0;
        for(int i = 0; i < 100; i++)
        {
            sum += arr[i];
        }
        
        System.out.print(sum);
        
    }
}