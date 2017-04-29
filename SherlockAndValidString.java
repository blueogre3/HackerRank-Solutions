import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        HashMap<Character, Integer> h1 = new HashMap();
        for (int i = 0; i < s.length(); i++)
        {
            if(!h1.containsKey(s.charAt(i)))
            {
                h1.put(s.charAt(i), 1);
            }
            else
            {
                h1.put(s.charAt(i), h1.get(s.charAt(i)) + 1);
            }
        }
        HashMap<Integer, Integer> h2 = new HashMap();
        for (Map.Entry<Character, Integer> entry : h1.entrySet())
        {
            char c = entry.getKey();
            int v = entry.getValue();
            if(!h2.containsKey(v))
            {
                h2.put(v, 1);
            }
            else
            {
                h2.put(v, h2.get(v) + 1);
            }
        }
        if(h2.size() > 2)
        {
            System.out.print("NO");
        }
        else if(h2.size() <= 1)
        {
            System.out.print("YES");
        }
        else
        {
            int flag = 0;
            for (Map.Entry<Integer, Integer> e : h2.entrySet())
            {
                int num = e.getKey();
                int freq = e.getValue();
                if(freq == 1)
                {
                    System.out.print("YES");
                    flag = 1;
                }
            }
            if(flag == 0)
            {
                System.out.print("NO");
            }
            else
            {
                flag = 0;
            }
        }
    }
}