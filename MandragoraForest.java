import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int[] arr = new int[n];
            long sum = 0;
            
            for(int j = 0; j < n; j++){
                arr[j] = in.nextInt();
                sum += arr[j];
            }

            
            Arrays.sort(arr);
            
            long currStrength = 1;
            long maxScore = sum;
            long currScore = 0;
            
            for(int j = 0; j < n; j++){
                currStrength++;
                sum -= arr[j];
                currScore = currStrength * sum;
                if(currScore > maxScore) maxScore = currScore;
            }
            
            System.out.println(maxScore);
            
        }
    }
}