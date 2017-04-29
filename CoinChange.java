import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class Tuple { 
        public final int x; 
        public final int y; 
        public Tuple(int x, int y) { 
            this.x = x; 
            this.y = y; 
        }
        
        @Override
        public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Tuple)) {
            return false;
        }

        Tuple t = (Tuple) o;

        return t.x == x &&
                t.y == y;
        }
        
        @Override
        public int hashCode() {
            
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
            
        }

        
    }
    
    static HashMap<Tuple, Long> h = new HashMap();
    
    public static long comb(int n, int[] arr, int i)
    {
        Tuple t = new Tuple(n, i);
        if(i >= arr.length || n < arr[i])
        {
            return 0;
        }
        else if(n == arr[i])
        {
            return 1;
        }
        else if(h.get(t) != null)
        {
            return h.get(t);
        }
        else
        {
            long x = comb(n - arr[i], arr, i) + comb(n, arr, i+1);
            h.put(t, x);
            return x;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++)
        {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        
        System.out.print(comb(n, arr, 0));
        
        h.clear();
        
      
    }
}