import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int[] lmemo = new int[100001];
    static int[] hmemo = new int[100001];
    
    public static int lower(int[] arr, int index){
        if(arr.length == 1) return 0;
        if(index == 1) return arr[0] - 1;
        else{
            int hi;
            int lo;
            if(lmemo[index - 1] >= 0){
                lo = lmemo[index - 1];
            }
            else
            {
                lo = lower(arr, index - 1);
            }
            if(hmemo[index - 1] >= 0){
                hi = hmemo[index - 1];
            }
            else
            {
                hi = higher(arr, index - 1);
            }
            lmemo[index] = Math.max(lo, hi + Math.abs(arr[index - 1] - 1));
            return lmemo[index];
        }
    }
    
    public static int higher(int[] arr, int index){
        if(arr.length == 1) return 0;
        if(index == 1) return arr[1] - 1;
        else{
            int hi;
            int lo;
            if(lmemo[index - 1] >= 0){
                lo = lmemo[index - 1];
            }
            else
            {
                lo = lower(arr, index - 1);
            }
            if(hmemo[index - 1] >= 0){
                hi = hmemo[index - 1];
            }
            else
            {
                hi = higher(arr, index - 1);
            }
            hmemo[index] = Math.max(hi + Math.abs(arr[index] - arr[index - 1]), lo + Math.abs(arr[index] - 1));
            return hmemo[index];
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
            {
                arr[j] = in.nextInt();
            }
            
            for(int j = 0; j < lmemo.length; j++){
                lmemo[j] = -1;
                hmemo[j] = -1;
            }
            
            System.out.println(Math.max(lower(arr, arr.length - 1), higher(arr, arr.length - 1)));
            
        }
   
    }
}