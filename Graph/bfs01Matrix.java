package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class bfs01Matrix {
    public static int[][] updateMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j]==0){
                    result[i][j] = 0;
                    q.add(new int[]{i,j});
                }
                else{
                    result[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()){
            int pair[] = q.poll();
            int r = pair[0];
            int c = pair[1];
            int[][] dirs = {{r-1,c},{r+1,c},{r,c-1},{r,c+1}};
            for(int[] dir : dirs){
                int nr = dir[0];
                int nc = dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && result[nr][nc]==-1){
                    result[nr][nc] = result[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] mat = {{0,1,1},{1,1,1},{1,1,1}};
        int[][] result = updateMatrix(mat);
        for(int i =0; i<result.length; i++){
            for(int j = 0; j<result[i].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
