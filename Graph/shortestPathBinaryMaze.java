import java.util.*;
class Pair{
    int i;
    int j;
    int w;
    Pair(int i, int j, int w){
        this.i = i;
        this.j = j;
        this.w = w;
    }
}
public class shortestPathBinaryMaze {
    public static int shortestPathBinaryMatrix(int[][] grid){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        for(int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);
        if(grid[0][0] == 1 || grid[n-1][m-1]==1) return -1;
        result[0][0] = 1;
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},  {0, 1},  {1, -1},  
            {1, 0},   {1, 1}
        };
        pq.add(new Pair(0,0,1));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int i = curr.i;
            int j = curr.j;
            int w = curr.w;
            if(i==n-1 && j==m-1) return w;
            for(int[] dir : directions){
                int nx = i+dir[0];
                int ny = j+dir[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==0){
                    if(result[nx][ny]>w+1){
                        result[nx][ny] = w+1;
                        pq.add(new Pair(nx, ny, result[nx][ny]));
                    }
                }
            }
        }
        return -1;   
    }
    public static void main(String[] args) {
        // Input: grid = [[0,1],[1,0]]
        int[][] grid = {{0,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }   
}
