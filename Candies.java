import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        
        int[] candies = new int[n];
        
        for(int i = 0; i < n; i++){
            candies[i]++;
        }
        
        for(int i = 1; i < n; i++){
            if(arr[i-1] < arr[i]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int j = n - 1; j >= 1; j--){
            if(arr[j-1] > arr[j]){
                candies[j-1] = Math.max(candies[j] + 1, candies[j-1]);
            }
        }
        
        long sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += candies[i];
        }
        
        System.out.println(sum);
        
        
    }
}