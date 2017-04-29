import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            int bribes = 0;
            int flag = 1;
            TreeSet<Integer> ts = new TreeSet();
            
            for(int q_i=0; q_i < n; q_i++){
                int a = in.nextInt();
                q[q_i] = a;
                ts.add(a);
            }
            
            for(int i = 0; i < n; i++)
            {
                if(q[i] > i + 3)
                {
                    System.out.println("Too chaotic");
                    flag = 0;
                    break;
                }
                else if(q[i] > i + 1)
                {
                    bribes += (q[i] - i - 1);
                }
                else
                {
                    if(q[i] != n)
                    {
                        int count = ts.subSet(1, q[i]).size();
                        bribes += count;
                    }
                }
                ts.remove(q[i]);
            }
            if(flag == 1)
            {
                System.out.println(bribes);
            }
            
        }
    }
}
