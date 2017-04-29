import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static boolean[][] visited;
    static int[][] matrix;
    static int currSize;
    
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        currSize++;
        if(x > 0 && !visited[x-1][y] && matrix[x-1][y] == 1){
            dfs(x - 1, y);
        }
        if(x < matrix.length - 1 && !visited[x+1][y] && matrix[x+1][y] == 1){
            dfs(x + 1, y);
        }
        if(y > 0 && !visited[x][y-1] && matrix[x][y-1] == 1){
            dfs(x, y - 1);
        }
        if(y < matrix[0].length - 1 && !visited[x][y+1] && matrix[x][y+1] == 1){
            dfs(x, y + 1);
        }
        if(x > 0 && y > 0 && !visited[x-1][y-1] && matrix[x-1][y-1] == 1){
            dfs(x-1, y-1);
        }
        if(x < matrix.length - 1 && y < matrix[0].length - 1 && !visited[x+1][y+1] && matrix[x+1][y+1] == 1){
            dfs(x+1, y+1);
        }
        if(x < matrix.length - 1 && y > 0 && !visited[x+1][y-1] && matrix[x+1][y-1] == 1){
            dfs(x+1, y-1);
        }
        if(x > 0 && y < matrix[0].length - 1 && !visited[x-1][y+1] && matrix[x-1][y+1] == 1){
            dfs(x-1, y+1);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        visited = new boolean[n][m];
        matrix = new int[n][m];
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = false;
                matrix[i][j] = in.nextInt();
            }
        }
        
        int maxSize = 0;
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                currSize = 0;
                if(matrix[i][j] == 1 && visited[i][j] == false){
                    dfs(i, j);
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }
        
        System.out.println(maxSize);
        
        
    }
}