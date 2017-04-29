import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int pairs(int[] a,int k) {
        HashMap<Integer, Integer> h1 = new HashMap();
        HashSet<Integer> h = new HashSet();
        for (int i = 0; i < a.length; i++)
        {
            h.add(a[i]);
        }
        
        for(int e : h)
        {
            if(h.contains(e + k))
            {
                h1.put(e, e + k);
            }
            else
            {
                h1.put(e, -1);
            }
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : h1.entrySet())
        {
            int key = entry.getKey();
            int exist = entry.getValue();
            if(exist != -1)
            {
                count++;
            }
        }
        
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}
