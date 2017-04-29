import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int knapsack(int[] arr, int k, int i){
        if (k < 0) return Integer.MAX_VALUE;
        if((k >= 0 && k < arr[0]) || i >= arr.length) return k;
        else
            return Math.min(knapsack(arr, k - arr[i], i), knapsack(arr, k, i + 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = in.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(k - knapsack(arr, k, 0));
        }
    }
}