import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean test(int[] A, int[] B, int k)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] + B[i] < k)
            {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i < q; i++)
        {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for(int j = 0; j < n; j++)
            {
                A[j] = in.nextInt();
            }
            for(int j = 0; j < n; j++)
            {
                B[j] = in.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B);
            
            for(int j = 0; j < n/2; j++)
            {
                int tmp = B[n-j-1];
                B[n-j-1] = B[j];
                B[j] = tmp;
            }
            
            if(test(A, B, k))
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