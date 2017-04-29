import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int currmax = in.nextInt();
            int nummax = 1;
            for(int i = 1; i < n; i++)
            {
                int a = in.nextInt();
                if(a > currmax)
                {
                    currmax = a;
                    nummax++;
                }
            }
            if(nummax % 2 == 0)
            {
                System.out.println("ANDY");
            }
            else
            {
                System.out.println("BOB");
            }
        }
    }
}
