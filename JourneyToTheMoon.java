import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static HashMap<Integer, ArrayList<Integer>> h = new HashMap();
    static boolean[] visited;
    static ArrayList<Integer> arr = new ArrayList();
    
    static int dfs(int u)
    {
        int count = 0;
        for (Integer v : h.get(u)) {
            if (visited[v] == false) {
                visited[v] = true;
                count += (1 + dfs(v));
            }
        }
        return count;
    }
    
    static void countComponents() {
        for (Integer u : h.keySet()) {
            if (visited[u] == false) {
                visited[u] = true;
                arr.add(dfs(u) + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        
        visited = new boolean[n];
            
        for(int i = 0; i < n; i++)
        {
            ArrayList<Integer> l = new ArrayList();
            l.add(i);
            h.put(i, l);
        }
        
        for(int i = 0; i < p; i++)
        {
            int astro_2 = in.nextInt();
            int astro_1 = in.nextInt();
                
            ArrayList<Integer> l2 = h.get(astro_1);
            l2.add(astro_2);
            h.put(astro_1, l2);
                
            ArrayList<Integer> l4 = h.get(astro_2);
            l4.add(astro_1);
            h.put(astro_2, l4);
        }
        
        countComponents();
        
        int[] newarr = new int[arr.size()];
        int[] total = new int[arr.size()];
        
        int index = 0;
        int sum = 0;
        
        for(int e : arr)
        {
            sum += e;
            newarr[index] = e;
            index++;
        }
        
        
        for (int i = 0; i < newarr.length; i++)
        {
            total[i] = sum - newarr[i];
            sum -= newarr[i];
        }
        
        long totalcomb = 0;
        
        for(int i = 0; i < total.length; i++)
        {
            totalcomb += (long)(total[i] * newarr[i]);
        }
        
        System.out.println(totalcomb);
        
        
        
        
    }
}
