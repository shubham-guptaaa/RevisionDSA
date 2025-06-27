// Same as the Surrounded Regions (DFS)

public class NumberofEnclaves {
    public static void dfs(int r, int c, int[][] visi, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        visi[r][c] = 1;
        int[][] dirs = {{r-1,c},{r+1,c},{r,c-1},{r,c+1}};
        for(int[] dir : dirs){
            int nr = dir[0];
            int nc = dir[1];
            if(nr>=0 && nr<n && nc>=0 && nc<m && visi[nr][nc]==0 && grid[nr][nc]==1){
                dfs(nr, nc, visi, grid);
            }
        }
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visi = new int[n][m];
        for(int i = 0; i<n; i++){
            if(visi[i][0]==0 && grid[i][0]==1){
                dfs(i, 0, visi, grid);
            }
            if(visi[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i, m-1, visi, grid);
            }
        }
        for(int j = 0; j<m; j++){
            if(visi[0][j]==0 && grid[0][j]==1){
                dfs(0, j, visi, grid);
            }
            if(visi[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1, j, visi, grid);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(visi[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,1,1,0},
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0},
        };
        System.out.println(numEnclaves(grid));
    }
    
}
