import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = i+1;
            }
            if(k == 0)
            {
                for(int i = 0; i < n; i++)
                {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            else if(n % 2 != 0)
            {
                System.out.println(-1);
            }
            else if(n % k != 0)
            {
                System.out.println(-1);
            }
            else
            {
                for(int i = 0; i < n; i += 2*k)
                {
                    for(int j = i; j < i + k; j++)
                    {
                        int tmp = arr[j+k];
                        arr[j+k] = arr[j];
                        arr[j] = tmp;
                    }
                }
                for(int i = 0; i < n; i++)
                {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
