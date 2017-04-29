import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int mindiff(int[] arr, int k, int index){
        if(index >= arr.length) return Integer.MAX_VALUE;
        else if(Math.abs(arr[index] - k) == 0) return 0;
        else return Math.min(Math.abs(arr[index] - k), mindiff(arr, k, index + 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int p = in.nextInt();
        int q = in.nextInt();
        
        int index = 0;
        while(index < arr.length && arr[index] < p){
            index++;
        }
        if(index == arr.length) System.out.println(q);
        else if(index == 0 && arr[0] > q) System.out.println(p);
        else{
            int maxdiff = 0;
            int maxindex = 0;
            int start = Math.max(index - 1, 0);
            while(start < arr.length && arr[start] <= q){
                if(start == 0){
                    if(Math.abs(arr[start] - p) > maxdiff){
                        maxdiff = Math.abs(arr[start] - p);
                        maxindex = p;
                    }
                }
                else{
                    if((arr[start] + arr[start - 1])/2 >= p && (arr[start] - arr[start - 1])/2 > maxdiff){
                        maxdiff = (arr[start] - arr[start - 1])/2;
                        maxindex = (arr[start] + arr[start - 1])/2;
                    }
                }
                start++;
            }
            if(start < arr.length){
                for(int i = arr[start-1] + 1; i <= q; i++){
                    if(Math.min(Math.abs(i - arr[start-1]), Math.abs(i - arr[start])) > maxdiff){
                        maxdiff = Math.min(Math.abs(i - arr[start-1]), Math.abs(i - arr[start]));
                        maxindex = i;
                    }
                }
            }
            if(arr[arr.length - 1] < q){
                if(q - arr[arr.length - 1] > maxdiff){
                    System.out.println(q);
                }
                else{
                    System.out.println(maxindex);
                }
            }
            else{
                System.out.println(maxindex);
            }
        }
        
    }
}