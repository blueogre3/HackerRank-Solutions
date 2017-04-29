import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static HashMap<Integer, ArrayList<Integer>> h = new HashMap();
    static boolean[] visited;
    static int[] prev;
    
    static void bfs(int u)
    {
        LinkedList<Integer> queue = new LinkedList();
        visited[u] = true;
        queue.add(u);
        
        while(queue.size() > 0)
        {
            int x = queue.poll();
            for(Integer v : h.get(x))
            {
                if(visited[v] == false)
                {
                    visited[v] = true;
                    queue.add(v);
                    prev[v] = x;
                }
            }
        }
    }
    
    static int distance(int x, int start){
        if(prev[x] == 0) return -1;
        else if(prev[x] == start) return 6;
        else{
            return 6 + distance(prev[x], start);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i < q; i++)
        {
            int nodes = in.nextInt();
            int edges = in.nextInt();
            
            visited = new boolean[nodes + 1];
            prev = new int[nodes + 1];
            
            for(int j = 1; j <= nodes; j++)
            {
                ArrayList<Integer> l = new ArrayList();
                l.add(j);
                h.put(j, l);
            }
            
            for(int j = 0; j < edges; j++)
            {
                int node1 = in.nextInt();
                int node2 = in.nextInt();
                
                ArrayList<Integer> l2 = h.get(node1);
                l2.add(node2);
                h.put(node1, l2);
                
                ArrayList<Integer> l3 = h.get(node2);
                l3.add(node1);
                h.put(node2, l3);
            }
            
            int start = in.nextInt();
            
            bfs(start);
            
            for(int j = 1; j < nodes + 1; j++){
                if(j != start)
                    System.out.print(distance(j, start) + " ");
            }
            System.out.println();
            
            h.clear();
        }
    }

}