import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[][] memo;
    
    public static int LCS(String s1, String s2, int start, int end)
    {
        if(start < 0 || end < 0)
        {
            return 0;
        }
        if(memo[start][end] != -1)
        {
            return memo[start][end];
        }
        else if(s1.charAt(start) == s2.charAt(end))
        {
            memo[start][end] = LCS(s1, s2, start - 1, end - 1) + 1;
            return memo[start][end];
        }
        else
        {
            memo[start][end] = Math.max(LCS(s1, s2, start, end - 1), LCS(s1, s2, start - 1, end));
            return memo[start][end];
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        memo = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++)
                memo[i][j] = -1;
        System.out.println(LCS(s1, s2, s1.length() - 1, s2.length() - 1));
    }
    
    
}