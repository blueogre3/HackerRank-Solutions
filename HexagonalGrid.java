import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean hexagonal(char[] row1, char[] row2, int index1, int index2){
        if(index1 == row1.length && index2 == row2.length) return true;
        else if(index1 > row1.length || index2 > row2.length) return false;
        else
        {
            if(index1 != row1.length && row1[index1] == '1') return hexagonal(row1, row2, index1+1, index2);
            if(index2 != row2.length && row2[index2] == '1') return hexagonal(row1, row2, index1, index2+1);
            
            if((index1 == index2 || index1 == index2+1) && index1 < row1.length - 1 && row1[index1+1] == '0' && index2 < row2.length - 1 && row2[index2+1] == '0') 
                return (hexagonal(row1, row2, index1+1, index2+1) || hexagonal(row1, row2, index1+2, index2) || hexagonal(row1, row2, index1, index2+2));
            else if((index1 == index2 || index1 == index2+1) && index1 < row1.length - 1 && row1[index1+1] == '0')
                return hexagonal(row1, row2, index1+1, index2+1) || hexagonal(row1, row2, index1+2, index2);
            else if((index1 == index2 || index1 == index2+1) && index2 < row2.length - 1 && row2[index2+1] == '0')
                return hexagonal(row1, row2, index1+1, index2+1) || hexagonal(row1, row2, index1, index2+2);
            else if(index1 < row1.length - 1 && row1[index1+1] == '0' && index2 < row2.length - 1 && row2[index2+1] == '0')
                return hexagonal(row1, row2, index1+2, index2) || hexagonal(row1, row2, index1, index2+2);
            else if(index1 == index2 || index1 == index2+1)
                return hexagonal(row1, row2, index1+1, index2+1);
            else if(index1 < row1.length - 1 && row1[index1+1] == '0')
                return hexagonal(row1, row2, index1+2, index2);
            else if(index2 < row2.length - 1 && row2[index2+1] == '0')
                return hexagonal(row1, row2, index1, index2+2);
            else return false;
        }
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            char[] row1 = new char[n];
            char[] row2 = new char[n];
            String s1 = in.next();
            String s2 = in.next();
            row1 = s1.toCharArray();
            row2 = s2.toCharArray();
            if(!hexagonal(row1, row2, 0, 0)) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}