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
            for(int j = 0; j < n; j++){
                arr[j] = in.nextInt();
            }
            int[] greater = new int[n];
            for(int j = 0; j < n; j++){
                int a = arr[j];
                for(int k = 0; k < n; k++){
                    if(arr[k] >= a){
                        greater[j]++;
                    }
                }
            }
            double sum = 0.0;
            for(int j = 0; j < n; j++){
                sum += (double)(n+1)/(greater[j]+1);
            }
            
            System.out.print(Math.round(sum * 100.00)/100.00);
            String s = Double.toString((Math.round(sum * 100.00)/100.00));
            if(s.charAt(s.length() - 3) != '.'){
                System.out.print(0);
            }
            System.out.println();
        }
    }
}