import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isBalanced(String expression) {
        Stack<Character> st = new Stack();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '('){
                st.push(expression.charAt(i));
            }
            else{
                char x1 = expression.charAt(i);
                if(st.empty()) return false;
                char x2 = st.pop();
                if(x1 == '}'){
                    if(x2 != '{') return false;
                }
                if(x1 == ']'){
                    if(x2 != '[') return false;
                }
                if(x1 == ')'){
                    if(x2 != '(') return false;
                }
            }
        }
        if(st.empty()) return true;
        return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
