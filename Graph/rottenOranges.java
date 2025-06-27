import java.util.ArrayDeque;
import java.util.Queue;

class rottenOranges {
    public static int oranges(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int freshCount = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i  =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j]==1){
                    freshCount++;
                }
                else if(mat[i][j]==2){
                    q.add(new int[] {i,j});
                }
            }
        }
        int time = 0;
        //BFS
        while(!q.isEmpty() && freshCount>0){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] rottenLoc = q.poll();
                int r = rottenLoc[0];
                int c = rottenLoc[1];
                int[][] dires = {{r-1,c},{r+1,c},{r,c-1},{r,c+1}};
                for(int[] dir : dires){
                    int nr = dir[0];
                    int nc = dir[1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==1){
                        mat[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        freshCount--;
                    }
                }
            }
            time++;
        }
        return (freshCount==0)? time : -1;
    }

    public static void main(String[] args) {
        // grid = [[2,1,1],[1,1,0],[0,1,1]]
        // int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        // grid = [[2,1,1],[0,1,1],[1,0,1]]

        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(oranges(grid));
    }
}