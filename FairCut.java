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
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        
        Arrays.sort(arr);
        
        int mid = n/2;
        
        int[] belong = new int[n];
        
        if(k > n/2) k = n - k;
        
        for(int i = mid - k + 1; i < mid + k + 1; i += 2){
            belong[i] = 1;
        }
        
        
        
        long sumdiff = 0;
        
        
        for(int i = 0; i < n; i++){
            if(belong[i] == 1)
            {
                for(int j = 0; j < n; j++){
                    if(belong[j] == 0){
                        sumdiff += Math.abs(arr[i] - arr[j]);
                    }
                }
            }
        }
        
        System.out.println(sumdiff);
        
        
    }
}