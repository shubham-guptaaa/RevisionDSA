package Graph;
import java.util.*;
class floodFill{
    static int row;
    static int col;
    public static void dfs(int r, int c, int currCol, int newCol, boolean[][] visi, int[][] image){
        if(r<0 || r>=row || c<0 || c>=col) return;
        if(image[r][c]!=currCol) return;
        if(visi[r][c]) return;
        image[r][c] = newCol;
        visi[r][c] = true;
        int[][] adj = {{r+1,c},{r-1,c},{r,c+1},{r,c-1}};
        for(int i[] : adj){
            dfs(i[0], i[1], currCol, newCol, visi, image);
        }
    }
    public static int[][] fill(int[][] image, int sr, int sc, int newCol){
        row = image.length;
        col = image[0].length;
        int currCol = image[sr][sc];
        boolean[][] visi = new boolean[row][col];
        dfs(sr, sc, currCol, newCol, visi, image);
        return image;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // [[1, 0, 1],[0, 1, 0],[1, 0, 1]]
        int[][] image = {{1,0,1},{0,1,0},{1,0,1}};
        int sr = 1;
        int sce = 1;
        int newCol = 2;
        
        image = fill(image, sr, sce, newCol);
        for(int i = 0; i<image.length; i++){
            for(int j = 0; j<image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

    }
}