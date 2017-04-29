import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int l = 0; l < q; l++){
            int m = in.nextInt();
            int n = in.nextInt();
            long[] yarr = new long[m-1];
            long[] xarr = new long[n-1];
            for(int i = 0; i < m - 1; i++){
                yarr[i] = in.nextLong();
            }
            Arrays.sort(yarr);
            for(int i = 0; i < n - 1; i++){
                xarr[i] = in.nextLong();
            }
            Arrays.sort(xarr);
            int xindex = xarr.length - 1;
            int yindex = yarr.length - 1;
            long xsegment = 1;
            long ysegment = 1;
        
            long totalcost = 0;
            
            int c = 1000000007;
        
            while(xindex >= 0 || yindex >= 0 ){
            
                if(xindex < 0){
                    totalcost = (totalcost + (yarr[yindex] * ysegment))%c;
                    xsegment++;
                    yindex--;
                }
            
                else if(yindex < 0){
                    totalcost = (totalcost + (xarr[xindex] * xsegment))%c;
                    ysegment++;
                    xindex--;
                }
            
                else if(xarr[xindex] >= yarr[yindex]){
                    totalcost = (totalcost + (xarr[xindex] * xsegment))%c;
                    ysegment++;
                    xindex--;
                }
            
                else if(yarr[yindex] > xarr[xindex]){
                    totalcost = (totalcost + (yarr[yindex] * ysegment))%c;
                    xsegment++;
                    yindex--;
                }
            
            }
        
            System.out.println(totalcost);
        }
    }
}