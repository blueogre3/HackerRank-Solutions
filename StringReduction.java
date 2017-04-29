import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /* Head ends here */
    static int stringReduction(String s) {
       int acount = 0;
       int bcount = 0;
       int ccount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') acount++;
            if(s.charAt(i) == 'b') bcount++;
            if(s.charAt(i) == 'c') ccount++;
        }
        if((acount == 0 && bcount == 0) || (acount == 0 && ccount == 0) || (bcount == 0 && ccount == 0)) return s.length();
        if(acount % 2 == bcount % 2 && bcount % 2 == ccount % 2) return 2;
        else return 1;
       }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _t_cases = Integer.parseInt(in.nextLine());
        for (int _t_i = 0; _t_i<_t_cases; _t_i++) {
            String _a = in.nextLine();
            res = stringReduction(_a);
            System.out.println(res);
        }
    }
}
