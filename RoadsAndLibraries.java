import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            
            HashMap<Integer, ArrayList<Integer>> h = new HashMap<>();
            int n = scan.nextInt();
            int m = scan.nextInt();
            int libraryCost = scan.nextInt();
            int roadCost = scan.nextInt();
            
            for (int i = 1; i <= n; i++) {
	           ArrayList<Integer> list = new ArrayList<Integer>();
	           list.add(i);
	           h.put(i, list);
            }
            
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = scan.nextInt();
                int city_2 = scan.nextInt();
                
                /*
                ArrayList<Integer> l2 = h.get(city_1); 
                ArrayList<Integer> l4 = h.get(city_2);
                if(l2 != l4)
                {
                    l2.addAll(l4);
                    l4.forEach(i -> h.put(i, l2));
                }
                */
                ArrayList<Integer> list1 = h.get(city_1);
	               ArrayList<Integer> list2 = h.get(city_2);
	               if (list1 != list2) {
		              list1.addAll(list2);
		              list2.forEach(i -> h.put(i, list1));
	               }
                
            }
            
            if (libraryCost < roadCost)
	           System.out.println((long) n * libraryCost);
            else
            {
                long total = 0;
                for(ArrayList<Integer> l : h.values())
                {
                    int size = l.size();
                    if(size > 0)
                    {
                        total += libraryCost;
                        total += (size - 1) * roadCost;
                        l.removeIf(i -> true);
                    }
                }
                System.out.println(total);
            }
            
        }
    }
}