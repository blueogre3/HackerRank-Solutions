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
        int i = k - 1;
        int count = 0;
        int shiftcount = 0;
        int[] arr = new int[n];
        for (int j = 0; j < n; j++)
        {
            arr[j] = in.nextInt();
        }
        while(i >= 0 && i < n)
        {
            if(arr[i] == 1)
            {
                shiftcount = 0;
                count++;
                arr[i] = 0;
                i += (2*(k-1) + 1);
            }
            else if(shiftcount < (2*(k-1) + 1))
            {
                i--;
                shiftcount++;
            }
            else
            {
                System.out.print(-1);
                return;
            }
        }
        i -= (2*(k-1) + 1);
        i += k;
        if(i < n) count++;
        
        if(i < 0)
        {
            System.out.print(-1);
            return;
        }
        System.out.print(count);
    }
}