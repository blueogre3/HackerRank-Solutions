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
            HashMap<Integer, Integer> h = new HashMap();
            TreeSet<Integer> tree = new TreeSet();
            int min = 0;
            for(int j = 0; j < n; j++){
                int num = in.nextInt();
                tree.add(num);
                if(!h.containsKey(num)){
                    h.put(num, 1);
                }
                else{
                    h.put(num, h.get(num) + 1);
                }
            }
            
            int mincount = Integer.MAX_VALUE;
            
            while(!h.isEmpty()){
                int x = tree.first();
                int y = x + 1;
                int currcount = 1;
                while(h.containsKey(y)){
                    if(h.get(y-1) != null && h.get(y) < h.get(y-1)){
                        break;
                    }
                    currcount++;
                    y++;
                }
                for(int j = x; j < y; j++){
                    if(h.get(j) == 1){
                        h.remove(j);
                        tree.remove(j);
                    }
                    else{
                        h.put(j, h.get(j) - 1);
                    }
                }
                if(currcount < mincount){
                    mincount = currcount;
                }
            }
            
            
            if(mincount == Integer.MAX_VALUE){
                mincount = 0;
            }
            System.out.println(mincount);
        }
    }
}