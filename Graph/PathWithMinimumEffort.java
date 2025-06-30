import java.util.*;
class Cell {
    int src;
    int dist;
    int weight;
    Cell(int src, int dist, int weight){
        this.src = src;
        this.dist = dist;
        this.weight = weight;
    }
}
public class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights){
        int n = heights.length;
        int m = heights[0].length;
        int[][] result = new int[n][m];
        for(int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);
        result[0][0] = 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Cell(0, 0, 0));
        int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        while(!pq.isEmpty()){
            Cell curr = pq.poll();
            int u = curr.src;
            int v = curr.dist;
            int wt = curr.weight;
            if(u==n-1 && v==m-1) return wt;
            for(int[] dir : directions){
                int nx = u+dir[0];
                int ny = v+dir[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    int absDiff = Math.abs(heights[u][v]-heights[nx][ny]);
                    int efforts = Math.max(wt, absDiff);
                    if(efforts<result[nx][ny]){
                        result[nx][ny] = efforts;
                        pq.add(new Cell(nx, ny, result[nx][ny]));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // heights = [[1,2,2],[3,8,2],[5,3,5]]
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
}
